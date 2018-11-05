// 页面加载初始化
$(function() {
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
	$.ajax({
				url : '../print/getCityList',
				typt : 'get',
				 async: false,
				data : {
					system_id : systemId
				},
				success : function(data) {
					data = JSON.parse(data);
					if ($("#type").val() == "query") {
						$("#city_id").empty();
						$("#city_id").append("<option value=''><--请选择-></option>");
						$.each(data, function(index, value) {
									$("#city_id").append("<option value='"
											+ value.id + "'>" + value.name+value.code
											+ "</option>"); 
								})
					} else if ($("#type").val() == "edit") {
						$("#cityId").empty();
						$.each(data, function(index, value) {
									$("#cityId").append("<option value='"
											+ value.id + "'>" + value.name+value.code
											+ "</option>"); 
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
									$("#product_id").append("<option value='"
											+ value.id + "'>" + value.name
											+ "</option>");
								})
					} else if ($("#type").val() == "edit") {
						$("#productId").empty();
						$.each(data, function(index, value) {
									$("#productId").append("<option value='"
											+ value.id + "'>" + value.name
											+ "</option>");
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
									$("#contract_type")
											.append("<option value='"
													+ value.id + "'>"
													+ value.name + "</option>");
								})
					} else if ($("#type").val() == "edit") {
						$("#contractTypeId").empty();
						$.each(data, function(index, value) {
									$("#contractTypeId")
											.append("<option value='"
													+ value.id + "'>"
													+ value.name + "</option>");
								})
					}

				}

			});
	$.ajax({
				url : '../print/getContractInfoList',
				typt : 'get',
				async : false,
				data : {
					system_id : systemId
				},
				success : function(data) {
					data = JSON.parse(data);
					if ($("#type").val() == "query") {
						$("#contract_id").empty();
						$("#contract_id")
								.append("<option value=''><--请选择-></option>");
						$.each(data, function(index, value) {
									$("#contract_id").append("<option value='"
											+ value.contractId + "'>"
											+ value.contractCode
											+ value.contractType.name
											+ "</option>");
								})
					} else if ($("#type").val() == "edit") {
						$("#contractId").empty();
						$.each(data, function(index, value) {
									$("#contractId").append("<option value='"
											+ value.contractId + "'>"
											+ value.contractCode
											+ value.contractType.name
											+ "</option>");
								})
					}

				}

			});

}
// 获取用户列表
function page_init(params) {
	$("#contractVersion").datagrid({
		url : "../print/getContractVersionPage",
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
					field : "contractInfo",
					title : "合同编码",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.contractInfo.contractCode;
					}
				}, {
					field : "city",
					title : "城市",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.contractInfo.city.name;
					}
				}, {
					field : "product",
					title : "产品",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.contractInfo.product.name;
					}
				}, {
					field : "contractType",
					title : "合同类型",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.contractInfo.contractType.name;
					}
				}, {
					field : "version",
					title : "版本",
					align : "center",
					width : 200
				}, {
					field : "url",
					title : "地址",
					align : "center",
					width : 200
				}, {
					field : "status",
					title : "是否使用",
					align : "center",
					width : 200
				}, {
					field : "show",
					title : "操作",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return '<a href="#" onclick="editCtract('
								+ row.id
								+ ')">编辑</a>&nbsp&nbsp<a href="#" onclick="downloadFile('
								+ row.id + ')">预览下载</a>';
					}
				}]],
		loadFilter : function(data) {
			if (data.rows) {
				return data;
			}
		},
		onDblClickRow : function(index, row) {
			$("#type").val("edit");
			$("#isAdd").val("1");
			dialog('编辑', row);
		}
	});

}
function editCtract(id) {
	// $("#contractDialog").dialog({
	// title : '',
	// width : 1000,
	// height : 800,
	// closed : false,
	// cache : false,
	// collapsible : true,
	// maximizable : true,
	// resizable : true,
	// shadow : true,
	// left : 150,
	// top : 50,
	// href : '../print/toM',
	// modal : true
	//				
	// });
	window
			.open(
					'../print/toM?id=' + id,
					'',
					'height=1000,width=1600,status=no,toolbar=no,menubar=no,location=no,top=0,left=100,scrollbars=yes,resizable=yes');

	// $("#tabs-2").attr("data-options", "selected:true");
}
function doSearch() {
	page_init(getParams());
}
function fillForm(row) {
	$("#contractVersionInfo").form('load', row);
	$("#contractId").val(row.contractInfo.contractId);
}
function openDialog(e, row) {
	$("#contractVersionInfo").form('reset');
	$("#isAdd").val("0");
	title = "新增";
	if ($(e).attr("tag") == "edit") {
		var row = $('#contractVersion').datagrid('getSelected');
		if (row) {
			$("#isAdd").val("1");
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
		var systemId = row.contractInfo.systemId;
		selectList(systemId);
		fillForm(row);
	} else {
		var systemId = $("#systemId").val();
		selectList(systemId);
	}
	$('#editDialog').dialog({
				title : title,
				width : 400,
				height : 300,
				closed : false,
				cache : false,
				collapsible : true,
				maximizable : true,
				resizable : true,
				shadow : true,
				left : 250,
				top : 50,
				href : '',
				modal : true,
				content : ''
			});
}
function doDelete() {
	var row = $('#contractVersion').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除吗?', function(r) {
			$.ajax({
						url : "../print/deleteContractVersion",
						type : 'post',
						data : {
							id : row.id
						},
						dataType : 'json',
						success : function(data) {
							$.messager.alert('提示', data, 'info').panel('move',
									{
										left : 400,
										top : 100
									});
							$("#contractVersion").datagrid('reload');
						},
						error : function(data) {
							$.messager.alert('错误', "失败", 'error');
						}

					});
		}).panel('move', {
					left : 400,
					top : 100
				});
	} else {
		$.messager.alert('提示', '请选择一条数据', 'info');
		return;
	}
}

function doEdit() {
	var data = $("#contractVersionInfo").serializeJson();
	$.ajax({
				url : '../print/updateContractVersion',
				type : 'post',
				contentType : 'application/json;charset=UTF-8',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					$.messager.alert('提示', data, 'info');
					$("#contractVersion").datagrid('reload');
					$("#contractVersionInfo").form('reset');
					$('#editDialog').dialog("close");
				},
				error : function(data) {
					$.messager.alert('错误', "失败", 'error');
				}
			});
}
function upload() {
	$("#uploadDialog").dialog({
						title : '',
						width : 400,
						height : 120,
						closed : false,
						cache : false,
						collapsible : true,
						maximizable : true,
						resizable : true,
						shadow : true,
						left : 350,
						top : 150,
						modal : true

					});
}
function confirmUpload(id) {
	$.ajax({
				url : '../print/upload',
				type : 'post',
				contentType : 'application/json;charset=UTF-8',
				data : $("#uploadFile").val(),
				dataType : 'json',
				success : function() {

				},
				error : function() {
				}
			});
}
function downloadFile(id) {
	/*$.ajax({
				url : '../pdf/getPdf',
				type : 'get',
				//contentType : 'application/json;charset=UTF-8',
				data : {'info':'{query:{id:'+id+'}}'},
				//data:'',
				dataType : 'json',//返回参数类型
				success : function(data) {
					if(data.code=="1111"){
					$.messager.alert('错误', data.message, 'error');
					}else if(data.code=="0000"){
						$.messager.alert('info',  data.message, 'error');
					}
				},
				error : function(data) {
					$.messager.alert('错误',  data.message, 'error');
				}
			});*/
	window.open("../pdf/downPdf?info="+"{query:{id:"+id+"}}",'_blank','height=1000,width=1600,status=no,toolbar=no,menubar=no,dependent:yes,directions:no,location=no,top=0,left=100,scrollbars=yes,resizable=yes');
	/*$('#previewDialog').dialog({
				title : '',
				width : 400,
				height : 300,
				closed : false,
				cache : false,
				collapsible : true,
				maximizable : true,
				resizable : true,
				shadow : true,
				left : 250,
				top : 50,
				href : '../pdf/getPdf?info='+'{query:{id:'+id+'}}',
				modal : true,
				content : ''
			});*/
}