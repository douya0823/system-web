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
<script type="text/javascript" src="<%=path%>/js/contractVersion.js"></script>
<style type="text/css">
.datagrid-row-selected{
    background-color:#dbe8ff;
}
</style>
<form id="queryForm" style="margin-bottom: 0px;"">
	<div id="tb" style="padding-top: 10px;padding-bottom: 10px">
		<span>系统:</span>
        <select id="system_id" name="system_id" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:100px;;height:27px" >
        	<option value=''><--请选择-></option>
        	<option value="1">1</option>
            <option value="2">2</option>
        </select>
        <span>城市:</span> 
		<select id="city_id" name="city_id" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:100px;;height:27px" >
			<option value=""><--请选择-></option>
        </select>
		<span>产品:</span> 
		<select id="product_id" name="product_id" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:130px;;height:27px" >
			<option value=""><--请选择-></option>
        </select>
		<span>合同类型:</span> 
		<select id="contract_type" name="contract_type" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:100px;height:27px" >
			<option value=""><--请选择-></option>
        </select>
        <span>合同编码:</span>
        <input id="contract_code" name="contract_code" style="line-height: 23px; border: 1px solid #ccc" /> 
<!-- 		<span>合同编码:</span> 
		<select id="contract_id" name="contract_id" data-options="multiple:true,panelHeight:'auto'" class="esayui-combobox" style="width:130px;;height:27px" >
			<option value=""><--请选择-></option>
        </select> -->
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="doSearch()">查询</a>
		<a href="#" tag="add" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="openDialog(this)">新增</a> 
		<a href="#" tag="edit" class="easyui-linkbutton" data-options="iconCls:'icon-edit'" onclick="openDialog(this)">编辑</a> 
		<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-clear'" onclick="doDelete()">删除</a> 
	</div>

</form>
<table id="contractVersion" class="easyui-datagrid" title="合同版本"
	data-options="singleSelect:true,collapsible:true,method:'get'">
</table>
<input id="type" value="query" hidden="hidden"/>
<div id="editDialog" class="easyui-dialog" title="新增""
        closed="true" buttons="#dlg-buttons">                              
         
        <form id="contractVersionInfo" method="post" style="margin-top: 20px; margin-left: 20px;">
            <div class="fitem" style="display: none">
                <input name="id" class="easyui-textbox"  hidden="hidden"/>
            </div>
            <div class="fitem">
                <label>系统:</label>
                <select id="systemId" name="systemId" class="addselect" style="width:100px;">
                	<option value="1">1</option>
                	<option value="2">2</option>
                </select>
            </div>
			<div class="fitem">
				<label>合同编码:</label> 
				<select id="contractId" name="contractId" class="addselect" style="width:100px;">
				<option value=''><--请选择-></option>
				</select> 
			</div>
            
            <div class="fitem">
                <label>版本:</label>
                <input id="version" name="version" class="easyui-textbox"  />
            </div>
<!--             <div class="fitem">
                <label>地址:</label>
                <input id="url" name="url" class="easyui-textbox"  />
            </div> -->
             <div class="fitem">
                <label>是否使用:</label>
                <select id="status" name="status" class="addselect" style="width:100px;">
                	<option value="1">否</option>
                	<option value="0">是</option>
                </select>
            </div>
           
            <div id="dlg-buttons" style="display: block">
                <a id="confirm" href="javascript:void(0)" class="easyui-linkbutton c6" iconcls="icon-ok" onclick="doEdit()" style="width: 90px">提交</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-cancel" onclick="javascript:$('#editDialog').dialog('close')" style="width: 90px">取消</a>
            </div>
        </form>
    </div>
    <div id="uploadDialog" class="easyui-dialog" title="" closed="true" buttons="#upload-buttons"> 
    	<form  style="margin-top: 20px; margin-left: 20px;">
    		<div class="fitem">
                <label>模板:</label>
                <input type="file" id="uploadFile">
            </div>
    		<div id="upload-buttons" style="display: block">
                <a id="upload" href="javascript:void(0)" class="easyui-linkbutton c6" iconcls="icon-ok" onclick="confirmUpload()" style="width: 90px">提交</a>
                <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-cancel" onclick="javascript:$('#uploadDialog').dialog('close')" style="width: 90px">取消</a>
            </div>
           </form>
	</div>
	<div id="previewDialog" class="easyui-dialog" title="" closed="true" buttons="#preview-buttons"> 
		<div id="upload-buttons" style="display: block">
                <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-cancel" onclick="javascript:$('#previewDialog').dialog('close')" style="width: 90px">取消</a>
         </div>
	</div>