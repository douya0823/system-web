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
	page_init(getParams());
	selectList($("#system_id").val());
	$("#system_id").change(function() {
				$("#type").val("query");
				var system_id = $("#system_id").val();
				selectList(system_id);
			});
	$("#systemId").change(function() {
				$("#type").val("edit");
				var systemId = $("#systemId").val();
				selectList(systemId);
			});
});
// 获取查询条件
function getParams() {
	var params = $("#queryForm").serializeJson();
	return params;
}
// 获取填充数据
function selectList(systemId) {
	if (systemId) {
		$.ajax({
			url : '../print/getContractModelList',
			typt : 'get',
			async : false,
			data : {
				system_id : systemId
			},
			success : function(data) {
				data = JSON.parse(data);
				if ($("#type").val() == "query") {
					$("#model_id").empty();
					$("#model_id").append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
								$("#model_id").append("<option value='"
										+ value.id + "'>" + value.name
										+ value.version + "</option>");
							})
				} else if ($("#type").val() == "edit") {
					$("#modelId").empty();
					$("#modelId").append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
								$("#modelId").append("<option value='"
										+ value.id + "'>" + value.name
										+ value.version + "</option>");
							})
				}

			}

		});
		$.ajax({
			url : '../print/getParamList',
			typt : 'get',
			async : false,
			data : {
				system_id : systemId
			},
			success : function(data) {
				data = JSON.parse(data);
				if ($("#type").val() == "query") {
					$("#param_id").empty();
					$("#param_id").append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
								$("#param_id").append("<option value='"
										+ value.id + "'>" + value.description
										+ "</option>");
							})
				} else if ($("#type").val() == "edit") {
					$("#paramId").empty();
					$("#paramId").append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
								$("#paramId").append("<option value='"
										+ value.id + "'>" + value.description
										+ "</option>");
							})
				}

			}

		});
	} else {
		if ($("#type").val() == "query") {
			$("#model_id").empty();
			$("#param_id").empty();
		} else if ($("#type").val() == "edit") {
			$("#modelId").empty();
			$("#paramId").empty();
		}

	}
}
// 获取用户列表
function page_init(params) {
	$("#contractParam").datagrid({
				url : "../print/getContractParamPage",
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
							field : 'index',
							checkbox : true
						}, {
							field : 'id',
							hidden : true
						}, {
							field : "systemInfo",
							title : "系统",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								return row.contractModel.systemInfo.name;
							}
						}, {
							field : "contractInfo",
							title : "合同模板",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								return row.contractModel.name+'('+row.contractModel.version+')';
							}
						}, {
							field : "paramName",
							title : "参数名",
							align : "center",
							width : 300,
							formatter : function(value, row, index) {
								return row.param.name+'('+row.param.description+')';
							}
						}]],
				loadFilter : function(data) {
					if (data.rows) {
						console.log(data)
						return data;
					}
				},
				onDblClickRow : function(index, row) {
					$("#type").val("edit");
					dialog('编辑', row);
				}
			});

}
function doSearch() {
	page_init(getParams());
}
function fillForm(row) {
	$("#id").val(row.id);
	$("#systemId").val(row.contractModel.systemInfo.id);
	$("#modelId").val(row.contractModel.id);
	$("#paramId").val(row.param.id);	
}
function openDialog(e, row) {
	$("#contractParamInfo").form('reset');
	title = "新增";
	if ($(e).attr("tag") == "edit") {
		var row = $('#contractParam').datagrid('getSelected');
		if (row) {
			title = "编辑";
		} else {
			$.messager.alert('提示', '请选择一条数据', 'info');
			return;
		}
	}
	$("#type").val("edit");
	dialog(title, row);
}
function dialog(title, row) {

	if (title == "编辑") {
		var systemId = row.contractModel.systemInfo.id;
		selectList(systemId);
		fillForm(row);
	} else {
		var systemId = $("#systemId").val();
		selectList(systemId);
	}
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
	var row = $('#contractParam').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除吗?', function(r) {
			$.ajax({
						url : "../print/deleteContractParam",
						type : 'post',
						data : {
							id : row.id
						},
						dataType : 'json',
						success : function(data) {
							$.messager.alert('提示', data, 'info');
							$("#contractParam").datagrid('reload');
						},
						error : function(data) {
							$.messager.alert('错误', "失败", 'error');
						}

					});
		});
	} else {
		$.messager.alert('提示', '请选择一条数据', 'info');
		return;
	}
}

function doEdit() {
	var data = $("#contractParamInfo").serializeJson();
	$.ajax({
				url : '../print/updateContractParam',
				type : 'post',
				contentType : 'application/json;charset=UTF-8',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					$.messager.alert('提示', data, 'info');
					$("#contractParam").datagrid('reload');
					$("#contractParamInfo").form('reset');
					$('#editDialog').dialog("close");
				},
				error : function(data) {
					$.messager.alert('错误', "失败", 'error');
				}
			});
}
