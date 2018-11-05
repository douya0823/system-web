<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/jquery-easyui/themes/default/easyui.css"
	type="text/css" />
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/js/jquery-easyui/themes/icon.css"
	type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/dialog.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui/easyui.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="<%=path%>/js/formUtil.js"></script>
<script type="text/javascript" src="<%=path%>/js/contractParam.js"></script>
<style type="text/css">
.datagrid-row-selected{
    background-color:#dbe8ff;
}
</style>
<form id="queryForm" style="margin-bottom: 0px;"">
	<div id="tb" style="padding-top: 10px;padding-bottom: 10px">
		<span>系统:</span>
        <select id="system_id" name="system_id" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:100px;;height:27px" >
        </select>
		<span>模板:</span> 
		<select id="model_id" name="model_id" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:100px;;height:27px" >
        </select>
		<span>参数:</span> 
		<select id="param_id" name="param_id" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:130px;;height:27px" >
        </select>
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
		<a href="#" tag="add" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="openDialog(this)">新增</a> 
		<a href="#" tag="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="openDialog(this)">编辑</a> 
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onclick="doDelete()">删除</a> 
	</div>

</form>
<table id="contractParam" class="easyui-datagrid" title="合同参数"
	data-options="singleSelect:true,collapsible:true,method:'get'">
</table>
<input id="type" value="query" hidden="hidden"/>
<div id="editDialog" class="easyui-dialog" title="新增""
        closed="true" buttons="#dlg-buttons">

	<form id="contractParamInfo" method="post"
		style="margin-top: 20px; margin-left: 20px;">
			<input id="id" name="id" hidden="hidden"/>
 		<div class="fitem">
                <label>系统:</label>
                <select id="systemId" name="systemId" class="addselect" style="width:100px;">
                </select>
            </div>
		<div class="fitem">
			<label>模板:</label> 
			<select id="modelId" name="modelId" class="addselect" style="width:100px;">
			</select> 
		</div>
		<div class="fitem">
			<label>参数:</label>
        	<select id="paramId" name="paramId"  class="addselect" style="width:100px;" >
        	</select>
		</div>
		<div id="dlg-buttons" style="display: block">
			<a id="confirm" href="javascript:void(0)"
				class="easyui-linkbutton c6" iconcls="icon-ok" onclick="doEdit()"
				style="width: 90px">提交</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" iconcls="icon-cancel"
				onclick="javascript:$('#editDialog').dialog('close')"
				style="width: 90px">取消</a>
		</div>
	</form>
</div>