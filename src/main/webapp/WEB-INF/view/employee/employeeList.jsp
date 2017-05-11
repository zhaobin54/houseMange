<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Layout - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/demo.css">
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/jquery.easyui.min.js"></script>
</head>
<script type="text/javascript">
var baseUrl="${ctx}";
$(function(){
	$('#dg').datagrid({
	    url:baseUrl+'/employee/list.htmls',
	    columns:[[
	        {field:'productid',title:'姓名',width:100},
	        {field:'productname',title:'联系方式',width:100},
	        {field:'unitcost',title:'生日',width:100},
	        {field:'status',title:'所属区域',width:100},
	        {field:'listprice',title:'操作',width:100,align:'center',
	        	formatter:function(value,row,index){
	        		var s = '<a href="#" class="easyui-linkbutton" data-options="plain:true">编辑</a>';
					var c = '<a href="#" class="easyui-linkbutton" data-options="plain:true,iconCls:\'icon-cancel\'">删除</a>';
					return s+c;	
			  }
	       }  
	    ]],
	    toolbar: '#tb',
	    loadMsg:'数据正在加载中...',
		pagination :true,
		pagePosition:'bottom',
		pageNumber:1,
		pageSize:10,
		pageList:[10,20,30,40,50],
		onDblClickCell: function(index,field,value){
			alert(value);
		}
	});
})
</script>
<body>
<h2>员工记录</h2>
	<div id="tb" style="padding:2px 5px;">
		姓名: <input class="easyui-textbox" style="width:110px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
	</div>
	<table id="dg">
		
	</table>
	
</body>
</html>