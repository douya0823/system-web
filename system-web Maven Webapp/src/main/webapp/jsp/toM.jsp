<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	System.out.print(path);
%>
<base href="<%=basePath%>">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/dialog.css">
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/js/ueditor/ueditor.parse.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/js/ueditor/ueditor.all.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/js/ueditor/lang/zh-cn/zh-cn.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=path%>/js/addCustomizeCombox.js"></script>
<style type="text/css">
.edui-default{
margin:0 auto;

}
.top {
	margin:0 auto;
	width:1200px;
	margin-top: 15px;
	margin-bottom: 15px;
	
}

.title {
	font-family: fantasy;
	font-size: 17px;
	background: #8c99a0;
	color: white;
	padding: 8px 15px;
	border-radius: 11px;
	font-weight: 900;
}
.version{
}
.mybutton{background:#5fbd77;;color: white; 
line-height: 26px;border-radius: 11px;    border: none;
padding:3px 10px;font-size: 17px;font-weight: 900;
outline: none;}
</style>
<body style="background: gainsboro;">
<div class="top">
	<span class="title">${contractModel.systemInfo.name}</span> 
	<span class="title">${contractModel.contractType.name}</span>
	<span class="title">${contractModel.name}</span> 
	<span class="title version">${contractModel.version}</span>&nbsp;&nbsp;
	<input id="save" class="mybutton" type="button" value="保 存" onclick="saveContractHtml()">
	<input id="save" class="mybutton" type="button" value="获取html" onclick="getHtml()">
</div>
<div>
	<textarea id="editor" type="text/plain"
		style="width:1200px;height:800px">
</textarea>
<div id=page></div>

</div>
</body>
<input id="model_id" value="${model_id}" hidden="hidden">
<textarea id="params"  hidden="hidden">${params}</textarea>
<script type="text/javascript" charset="utf-8"
	src="<%=path%>/js/contractEdit.js"></script>
<script type="text/javascript">

</script>