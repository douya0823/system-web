// 页面加载初始化
$(function() {
	$('#setModelDialog').dialog({
				title : "模板设置",
				width : 1000,
				height : 500,
				closed : true,
				cache : false,
				collapsible : true,
				maximizable : true,
				resizable : true,
				shadow : true,
				left : 150,
				top : 50,
				href : '',
				modal : true
			});
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
			})
	$("#systemId").change(function() {
				$("#type").val("edit");
				var systemId = $("#systemId").val();
				selectList(systemId);
			})

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
			url : '../print/getCityList',
			typt : 'get',
			async : false,
			data : {
				system_id : systemId
			},
			success : function(data) {
				data = JSON.parse(data);
				if ($("#type").val() == "query") {
					$("#city_id").empty();
					$("#city_id").append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
						$("#city_id").append("<option value='" + value.id
								+ "'>" + value.name + value.code + "</option>");
					})
				} else if ($("#type").val() == "edit") {
					$("#cityId").empty();
					$("#cityId").append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
								$("#cityId").append("<option value='"
										+ value.id + "'>" + value.name
										+ value.code + "</option>");
							})
				}

			}

		});
		$.ajax({
			url : '../print/getProductList',
			typt : 'get',
			async : false,
			data : {
				system_id : systemId
			},
			success : function(data) {
				data = JSON.parse(data);
				if ($("#type").val() == "query") {
					$("#product_id").empty();
					$("#product_id")
							.append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
						$("#product_id").append("<option value='" + value.id
								+ "'>" + value.name + value.code + "</option>");
					})
				} else if ($("#type").val() == "edit") {
					$("#productId").empty();
					$("#productId")
							.append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
						$("#productId").append("<option value='" + value.id
								+ "'>" + value.name + value.code + "</option>");
					})
				}

			}

		});
		$.ajax({
			url : '../print/getContractTypeList',
			typt : 'get',
			async : false,
			data : {
				system_id : systemId
			},
			success : function(data) {
				data = JSON.parse(data);
				if ($("#type").val() == "query") {
					$("#contract_type").empty();
					$("#contract_type")
							.append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
						$("#contract_type").append("<option value='" + value.id
								+ "'>" + value.name + value.code + "</option>");
					})
				} else if ($("#type").val() == "edit") {
					$("#contractTypeId").empty();
					$("#contractTypeId")
							.append("<option value=''><--请选择-></option>");
					$.each(data, function(index, value) {
								$("#contractTypeId").append("<option value='"
										+ value.id + "'>" + value.name
										+ value.code + "</option>");
							})
				}

			}

		});
	} else {
		if ($("#type").val() == "query") {
			$("#city_id").empty();
			$("#product_id").empty();
			$("#contract_type").empty();
		} else if ($("#type").val() == "edit") {
			$("#cityId").empty();
			$("#productId").empty();
			$("#contractTypeId").empty();
		}

	}

}
// 获取用户列表
function page_init(params) {
	$("#contract").datagrid({
		url : "../print/getContractInfoPage",
		queryParams : params,
		pagination : true,// 允许分页
		rownumbers : true,// 行号
		striped : true, // 交替行换色
		singleSelect : true,// 只选择一行
		pageSize : 10,// 每一页数据数量
		pageNumber : 1, // 每次都要初始化为1,否则默认为上一次页面
		checkOnSelect : true,
		pageList : [5, 10, 15, 20, 25],
		toolbar : '#queryForm',
		columns : [[{
					field : 'index',
					checkbox : true
				}, {
					field : 'contractId',
					hidden : true
				}, {
					field : "contractCode",
					title : "合同编码",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.contractCode;
					}
				}, {
					field : "city",
					title : "城市",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.city.name + row.city.code;
					}
				}, {
					field : "product",
					title : "产品",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.product.name + row.product.code;
					}
				}, {
					field : "contractType",
					title : "合同类型",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.contractType.name + row.contractType.code;
					}
				}, {
					field : "contractModel",
					title : "合同模板",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						if (row.contractModel) {
							return row.contractModel.name
									+ row.contractModel.version;

						} else {
							return '<lable style="color:red">未设定模板</lable>';
						}
					}
				}, {
					field : "systemInfo",
					title : "系统",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.systemInfo.name;
					}
				}, {
					field : "show",
					title : "操作",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return '<a href="#" onclick="setModel('
								+ row.systemInfo.id + ',' + row.contractType.id
								+ ')">模板设置</a>';
					}
				}]],
		loadFilter : function(data) {
			if (data.rows) {
				return data;
			}
		},
		onDblClickRow : function(index, row) {
			$("#type").val("edit");
			dialog('编辑', row);
		}
	});

}
function fillForm(row) {
	$("#systemId").val(row.systemInfo.id);
	$("#cityId").val(row.city.id);
	$("#productId").val(row.product.id);
	$("#contractTypeId").val(row.contractType.id);
	$("#contractCode").val(row.contractCode);
	$("#contractId").val(row.contractId);
}
function doSearch() {
	page_init(getParams());
}
function openDialog(e, row) {
	$("#contractInfo").form('reset');
	title = "新增";
	if ($(e).attr("tag") == "edit") {
		var row = $('#contract').datagrid('getSelected');
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
		var systemId = row.systemInfo.id;
		selectList(systemId);
		fillForm(row);
	} else {
		var systemId = $("#systemId").val();
		selectList(systemId);
	}
	$('#editDialog').dialog({
				title : title,
				width : 400,
				height : 320,
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
	var row = $('#contract').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除吗?', function(r) {
			$.ajax({
						url : "../print/deleteContractInfo",
						type : 'post',
						data : {
							contractId : row.contractId
						},
						dataType : 'json',
						success : function(data) {
							$.messager.alert('提示', data, 'info');
							$("#contract").datagrid('reload');
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
	var data = $("#contractInfo").serializeJson();
	$.ajax({
				url : '../print/updateContractInfo',
				type : 'post',
				contentType : 'application/json;charset=UTF-8',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					$.messager.alert('提示', data, 'info');
					$("#contract").datagrid('reload');
					$("#contractInfo").form('reset');
					$('#editDialog').dialog("close");
				},
				error : function(data) {
					$.messager.alert('错误', "失败", 'error');
				}
			});
}
function modelData(queryParams) {
	$("#model").datagrid({
				url : "../print/getContractModelPage",
				queryParams : queryParams,
				pagination : true,// 允许分页
				rownumbers : true,// 行号
				striped : true, // 交替行换色
				singleSelect : true,// 只选择一行
				pageSize : 5,// 每一页数据数量
				pageNumber : 1, // 每次都要初始化为1,否则默认为上一次页面
				checkOnSelect : true,
				pageList : [5, 10, 15, 20, 25],
				columns : [[{
							field : 'index',
							checkbox : true
						}, {
							field : 'contractId',
							hidden : true
						}, {
							field : "systemInfo",
							title : "系统",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								return row.systemInfo.name;
							}
						}, {
							field : "name",
							title : "名称",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								return row.name;
							}
						}, {
							field : "version",
							title : "版本",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								return row.version;
							}
						}, {
							field : "url",
							title : "地址",
							align : "center",
							width : 200,
							formatter : function(value, row, index) {
								return row.url;
							}
						}]],
				loadFilter : function(data) {
					if (data.rows) {
						return data;
					}
				},
				onDblClickRow : function(index, row) {
					doSetModel();
				}
			});
}
function setModel(systemId, contractTypeId) {
	var queryParams = {
		system_id : systemId,
		contract_type : contractTypeId
	};
	 //$('#model').datagrid('reload',queryParams);
	$('#setModelDialog').dialog("open");
	modelData(queryParams);

}
function doSetModel() {
	var contractRow = $('#contract').datagrid('getSelected');
	var rows = $('#model').datagrid('getSelections');
	if (rows) {
		var ids = new Array();
		$.each(rows, function(index, value) {
					ids.push(rows[index].id);
				});
		var ss = ids.join(',');
		$.ajax({
					url : '../print/setModel',
					type : 'post',
					data : {
						contractId : contractRow.contractId,
						ids : ss
					},
					success : function(data) {
						$.messager.alert('提示', data, 'info');
						$('#setModelDialog').dialog("close");
						$("#contract").datagrid('reload');
					},
					error : function(data) {
						$.messager.alert('错误', "失败", 'error');
					}
				})
	} else {
		$.messager.alert('提示', "请选择数据", 'error');
	}
}
