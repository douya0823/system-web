// 页面加载初始化
$(function() {
	$.ajax({
				url : '../print/getSystemList',
				typt : 'get',
				async : false,
				data : {},
				success : function(data) {
					data = JSON.parse(data);
					$("#system_id")
							.append("<option value=''><--请选择-></option>");
					$("#systemId").append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
								$("#system_id").append("<option value='"
										+ value.id + "'>" + value.name
										+ "</option>");
								$("#systemId").append("<option value='"
										+ value.id + "'>" + value.name
										+ "</option>");
							});
				}

			});
	$("#systemId").change(function() {
				var system_id = $("#systemId").val();
				initPid(system_id);
			})

	page_init(getParams());

});
// 获取查询条件
function getParams() {
	var params = $("#queryForm").serializeJson();
	return params;
}

// 获取用户列表
function page_init(params) {
	$("#param").datagrid({
				url : "../print/getParamPage",
				queryParams : params,
				pagination : true,// 允许分页
				rownumbers : true,// 行号
				striped : true, // 交替行换色
				singleSelect : true,// 只选择一行
				pageSize : 5,// 每一页数据数量
				pageNumber : 1, // 每次都要初始化为1,否则默认为上一次页面
				checkOnSelect : true,
				pageList : [5, 10, 15, 20, 25],
				toolbar : '#queryForm',
				columns : [[{
							field : 'id',
							checkbox : true
						}, {
							field : "name",
							title : "参数名",
							align : "center",
							width : 200
						}, {
							field : "description",
							title : "参数中文描述",
							align : "center",
							width : 200
						}, {
							field : "systemInfo",
							title : "系统",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								return row.systemInfo.name;
							}
						}, {
							field : "pId",
							title : "父参数",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								if (row.pId) {
									return row.pId.name;
								}
							}
						}]],
				loadFilter : function(data) {
					if (data.rows) {
						return data;
					}
				},
				onDblClickRow : function(index, row) {
					$("#paramInfo").form('load', row);
					initPid(row.systemInfo.id);
					$("#systemId").val(row.systemInfo.id);
					if (row.pId) {
						$("#pId").val(row.pId.id);
					}
					dialog('编辑');
				}
			});

}
function initPid(system_id) {
	$("#pId").empty();
	if (system_id) {
		$.ajax({
					url : '../print/getParamList',
					typt : 'get',
					async : false,
					data : {
						system_id : system_id
					},
					success : function(data) {
						data = JSON.parse(data);
						$("#pId").append("<option value=''><--请选择-></option>");
						$.each(data, function(index, value) {
									$("#pId").append("<option value='"
											+ value.id + "'>"
											+ value.description + "</option>");
								});
					}
				});
	}else{
			$("#pId").empty();
	}
}
function doSearch() {
	page_init(getParams());
}
function openDialog(e, row) {
	$("#paramInfo").form('reset');
	$("#pId").empty();
	title = "新增";
	if ($(e).attr("tag") == "edit") {
		var row = $('#param').datagrid('getSelected');
		if (row) {
			$("#paramInfo").form('load', row);
			$("#systemId").val(row.systemInfo.id);
			title = "编辑";
		} else {
			$.messager.alert('提示', '请选择一条数据', 'info');
			return;
		}
	}
	dialog(title);
}
function dialog(title) {
	$('#editDialog').dialog({
				title : title,
				width : 400,
				height : 250,
				closed : false,
				cache : false,
				collapsible : true,
				maximizable : true,
				resizable : true,
				shadow : true,
				left : 150,
				top : 50,
				href : '',
				modal : true,
				content : ''
			});
}
function doDelete() {
	var row = $('#param').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除吗?', function(r) {
					$.ajax({
								url : "../print/deleteParam",
								type : 'post',
								data : {
									id : row.id
								},
								dataType : 'json',
								success : function(data) {
									$.messager.alert('提示', data, 'info');
								},
								error : function(data) {
									$.messager.alert('错误', "失败", 'error');
								},
								complete : function() {
									$("#param").datagrid('reload');
								}
							});
				});
	} else {
		$.messager.alert('提示', '请选择一条数据', 'info');
		return;
	}
}

function doEdit() {
	var data = $("#paramInfo").serializeJson();
	$.ajax({
				url : '../print/updateParam',
				type : 'post',
				contentType : 'application/json;charset=UTF-8',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					$.messager.alert('提示', data, 'info');
				},
				error : function(data) {
					$.messager.alert('错误', "失败", 'error');
				},
				complete : function() {
					$("#param").datagrid('reload');
					$("#paramInfo").form('reset');
					$('#editDialog').dialog("close");
				}
			});
}
