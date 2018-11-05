<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html lang="en">
<head>
<base href="<%=basePath%>">

<!-- 引入EasyUI的样式文件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/default/easyui.css" type="text/css" />
<!-- 引入EasyUI的图标样式文件-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-easyui/themes/icon.css" type="text/css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/css/index.css">
<script type="text/javascript" src="<%=path%>/js/jquery.js"></script>
<!-- 引入EasyUI -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/easyui.js"></script>
<!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>


</head>
<body class="easyui-layout" id="body" data-options="fit:true">
	<div data-options="region:'north'" class="top" style="height:50px"></div>
	<div data-options="region:'center'">
		<div class="easyui-layout" data-options="fit:true">
			<div data-id="leftmenu" id="leftMenu" data-options="region:'west',collapsible:true">
				<div id="div_welcome">欢迎您</div>
			</div>
			<div id="mainTabs" class="easyui-tabs"  data-options="region:'center'">
			</div>
			<!-- 以下为tabs右击事件 -->
			<div id="tab-tools" class="easyui-menu" style="width:100px">
				<div id="1" data-odivtions="iconCls:'icon-arrow_refresh'">刷新</div>
				<div id="2" data-options="iconCls:'icon-cross'">关闭当前标签</div>
				<div id="3" data-options="iconCls:'icon-cross'">关闭非当前标签</div>
				<div class="menu-sep"></div>
				<div id="4" data-options="iconCls:'icon-cross'">关闭左侧标签</div>
				<div id="5" data-options="iconCls:'icon-cross'">关闭右侧标签</div>
				<div id="6" iconCls="icon-cancel">关闭所有标签</div>
				</div>
			<!-- 也可这样设置图标 -->
		</div>
	</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath}/js/index.js"></script>
</body>
</html>
