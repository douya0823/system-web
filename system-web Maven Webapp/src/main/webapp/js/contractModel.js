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
														+ value.name
														+ "</option>");
									});
						} else if ($("#type").val() == "edit") {
							$("#contractType").empty();
							$.each(data, function(index, value) {
										$("#contractType")
												.append("<option value='"
														+ value.id + "'>"
														+ value.name
														+ "</option>");
									});
						}

					}

				});
	} else {
		if ($("#type").val() == "query") {
			$("#contract_type").empty();
		} else if ($("#type").val() == "edit") {
			$("#contractType").empty();
		}

	}

}
// 获取用户列表
function page_init(params) {
	$("#contractModel").datagrid({
		url : "../print/getContractModelPage",
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
						return row.systemInfo.name;
					}
				}, {
					field : "contractType",
					title : "合同类型",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						return row.contractType.name;
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
				}, {
					field : "show",
					title : "操作",
					align : "center",
					width : 200,
					formatter : function(value, row, index) {
						if(row.url){
								return '<a href="#" onclick="editCtract('
								+ row.id
								+ ')">编辑</a>&nbsp&nbsp<a href="#" onclick="downloadFile('
								+ row.id + ')">预览下载</a>';
						}else{
								return '<a href="#" onclick="editCtract('
								+ row.id
								+ ')">编辑</a>&nbsp&nbsp<a href="#" style="color: gray;" disabled="true">预览下载</a>';
						}
					
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
					'height=960,width=1600,status=no,toolbar=no,menubar=no,location=no,top=0,left=100,scrollbars=yes,resizable=yes');

	// $("#tabs-2").attr("data-options", "selected:true");
}
function doSearch() {
	page_init(getParams());
}
function fillForm(row) {
	$("#contractModelInfo").form('load', row);
	$("#systemId").val(row.systemInfo.id);
	$("#contractType").val(row.contractType.id);
}
function openDialog(e, row) {
	$("#contractModelInfo").form('reset');
	title = "新增";
	if ($(e).attr("tag") == "edit") {
		var row = $('#contractModel').datagrid('getSelected');
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
	var row = $('#contractModel').datagrid('getSelected');
	if (row) {
		$.messager.confirm('提示', '确定删除吗?', function(r) {
			$.ajax({
						url : "../print/deleteContractModel",
						type : 'post',
						data : {
							id : row.id
						},
						dataType : 'json',
						success : function(data) {
							$.messager.alert('提示', data, 'info');
							$("#contractModel").datagrid('reload');
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
	var data = $("#contractModelInfo").serializeJson();
	$.ajax({
				url : '../print/updateContractModel',
				type : 'post',
				contentType : 'application/json;charset=UTF-8',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(data) {
					$.messager.alert('提示', data, 'info');
					$("#contractModel").datagrid('reload');

					$('#editDialog').dialog("close");
				},
				error : function(data) {
					$.messager.alert('错误', "失败", 'error');
				}
			});
}
function formReset() {
	// $("#contractModelInfo").form('reset');

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
	/*
	 * $.ajax({ url : '../pdf/getPdf', type : 'get', //contentType :
	 * 'application/json;charset=UTF-8', data : {'info':'{query:{id:'+id+'}}'},
	 * //data:'', dataType : 'json',//返回参数类型 success : function(data) {
	 * if(data.code=="1111"){ $.messager.alert('错误', data.message, 'error');
	 * }else if(data.code=="0000"){ $.messager.alert('info', data.message,
	 * 'error'); } }, error : function(data) { $.messager.alert('错误',
	 * data.message, 'error'); } });
	 */
	window
			.open(
					"../pdf/previewPdf?info=" + "{query:{id:" + id + "}}",
					'_blank',
					'height=960,width=1600,status=no,toolbar=no,menubar=no,dependent:yes,directions:no,location=no,top=0,left=100,scrollbars=yes,resizable=yes');
	/*
	 * $('#previewDialog').dialog({ title : '', width : 400, height : 300,
	 * closed : false, cache : false, collapsible : true, maximizable : true,
	 * resizable : true, shadow : true, left : 250, top : 50, href :
	 * '../pdf/getPdf?info='+'{query:{id:'+id+'}}', modal : true, content : ''
	 * });
	 */
}