<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/demo.css">
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/menu.js"></script>
</head>

<body class="easyui-layout">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">
	  乌托邦-房屋租赁管理系统
	</div>
	<div data-options="region:'west',split:'true',hide:'true'"title="导航菜单" style="width:180px;" id="west">
     <div id='wnav' class="easyui-accordion" data-options="fit:'true',border:'false'" >
	  <!--  <div title="员工管理" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;">
			<h3 style="color:#0099FF;"><a href="#">员工列表</a></h3>
		</div>	 -->
	 </div>
    </div>
	<div id="mainPanle" data-options="region:'center'" style="background: #eee; overflow-y:hidden">
        <div id="tabs" class="easyui-tabs" style="width: 100%;height: 100%;">
		<div title="乌托邦首页" style="padding:10px">
			<p style="font-size:14px">jQuery EasyUI framework helps you build your web pages easily.</p>
			<ul>
				<li>easyui is a collection of user-interface plugin based on jQuery.</li>
				<li>easyui provides essential functionality for building modem, interactive, javascript applications.</li>
				<li>using easyui you don't need to write many javascript code, you usually defines user-interface by writing some HTML markup.</li>
				<li>complete framework for HTML5 web page.</li>
				<li>easyui save your time and scales while developing your products.</li>
				<li>easyui is very easy but powerful.</li>
			</ul>
		</div>
	</div>
   </div>
   <div id="mm" class="easyui-menu" style="width:150px;">
		<div id="mm-tabupdate">刷新</div>
		<div class="menu-sep"></div>
		<div id="mm-tabclose">关闭</div>
		<div id="mm-tabcloseall">全部关闭</div>
		<div id="mm-tabcloseother">除此之外全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-tabcloseright">当前页右侧全部关闭</div>
		<div id="mm-tabcloseleft">当前页左侧全部关闭</div>
		<div class="menu-sep"></div>
		<div id="mm-exit">退出</div>
	</div>
</body>
</html>