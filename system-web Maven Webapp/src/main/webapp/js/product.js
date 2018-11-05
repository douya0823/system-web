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

		});
// 获取查询条件
function getParams() {
	var params = $("#queryForm").serializeJson();
	return params;
}

// 获取用户列表
function page_init(params) {
	$("#product").datagrid({
				url : "../print/getProductPage",
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
							field : "name",
							title : "名称",
							align : "center",
							width : 200
						}, {
							field : "code",
							title : "编码",
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
						}]],
				loadFilter : function(data) {
					if (data.rows) {
						return data;
					}
				},
				onDblClickRow : function(index, row) {
					$("#productInfo").form('load', row);
					$("#systemId").val(row.systemInfo.id);
					dialog('编辑');
				}
			});

}
function doSearch() {
	page_init(getParams());
}
function openDialog(e, row) {
	$("#productInfo").form('reset');
	title = "新增";
	if ($(e).attr("tag") == "edit") {
		var row = $('#product').datagrid('getSelected');
		if (row) {
			$("#productInfo").form('load', row);
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
	var row = $('#product').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除吗?', function(r) {
			$.ajax({
						url : "../print/deleteProduct",
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
							$("#product").datagrid('reload');
						}
					});
		}).panel('move', {
					left : 200,
					top : 200
				});
	} else {
		$.messager.alert('提示', '请选择一条数据', 'info').panel('move', {
					left : 200,
					top : 200
				});
		return;
	}
}

function doEdit() {
	var data = $("#productInfo").serializeJson();
	$.ajax({
				url : '../print/updateProduct',
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
					$("#product").datagrid('reload');
					$("#productInfo").form('reset');
					$('#editDialog').dialog("close");
				}
			});
}
