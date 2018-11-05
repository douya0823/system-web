<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Summernote</title>
<link href="<%=path%>/dist/bootstrap.css" rel="stylesheet">
<script src="<%=path%>/js/jquery.js"></script>
<script src="<%=path%>/js/jquery.js"></script>
<script src="<%=path%>/js/bootstrap.js"></script>
<link href="<%=path%>/dist/summernote.css" rel="stylesheet">
<script src="<%=path%>/dist/summernote.js"></script>
<script src="<%=path%>/dist/lang/summernote-zh-CN.js"></script>

</head>

<style type="text/css">
.edui-default{
margin:0 auto;

}
.top {
    text-align: center;
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
.container{
    width: 900px;
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
	<textarea id="params" hidden="hidden">${params}</textarea>
	<select id="param">
	<option value="">参数选择</option>
	<c:forEach items="${params}" var="v">
		<option value="${v}">${v}</option>
	</c:forEach>
	</select>
</div>
<input id="model_id" value="${model_id}" hidden="hidden">
<div class="container">
    <div id="summernote"><p>Hello World</p></div>
</div>
	<input type="button" id="bb" value="hah" onclick="cc()">
	<textarea id="dd" rows="" cols=""></textarea>
</body>
<script src="<%=path%>/js/contractEdit2.js"></script>
</html>