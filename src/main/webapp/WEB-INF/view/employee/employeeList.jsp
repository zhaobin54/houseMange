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
Date.prototype.pattern = function (fmt) {
	var o = {
		"M+": this.getMonth() + 1, //月份		
		"d+": this.getDate(), //日		
		"h+": this.getHours() % 12 == 0 ? 12 : this.getHours() % 12, //小时		
		"H+": this.getHours(), //小时		
		"m+": this.getMinutes(), //分		
		"s+": this.getSeconds(), //秒		
		"q+": Math.floor((this.getMonth() + 3) / 3), //季度		
		"S": this.getMilliseconds() //毫秒		
	};
	var week = {
		"0": "/u65e5",
		"1": "/u4e00",
		"2": "/u4e8c",
		"3": "/u4e09",
		"4": "/u56db",
		"5": "/u4e94",
		"6": "/u516d"
	};
	if (/(y+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	}
	if (/(E+)/.test(fmt)) {
		fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "/u661f/u671f" : "/u5468") : "") + week[this.getDay() + ""]);
	}
	for (var k in o) {
		if (new RegExp("(" + k + ")").test(fmt)) {
			fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
		}
	}
	return fmt;
}
$(function(){
	$('#dg').datagrid({
	    url:baseUrl+'/employee/list.htmls',
	    columns:[[
	        {field:'name',title:'姓名',width:'15%',align:'center'},
	        {field:'phone',title:'联系方式',width:"15%",align:'center'},
	        {field:'birthday',title:'生日',width:"15%",align:'center',formatter:function(value,row,index){
	        	if (value == undefined) {
		            return "";
		        }
	        	var dt;
	    		if (value instanceof Date) {
	    			dt = value;
	    		}
	    		else {
	    			dt = new Date(value);
	    			if (isNaN(dt)) {
	    				value = value.replace(/\/Date\((-?\d+)\)\//, '$1'); //标红的这段是关键代码，将那个长字符串的日期值转换成正常的JS日期格式
	    				dt = new Date();
	    				dt.setTime(value);
	    			}
	    		}
	    		return dt.pattern("yyyy-MM-dd");
	        }},
	        {field:'province',title:'所属省份',width:"15%",align:'center'},
	        {field:'city',title:'所属城市',width:"15%",align:'center'},
	        {field:'district',title:'所属区域',width:"10%",align:'center'},
	        {field:'listprice',title:'操作',width:"15%",align:'center',
	        	formatter:function(value,row,index){
	        		var s = "<a href=\"edit\" class=\"edit\" >编辑  </a>";
					var c = "<a href=\"del\" class=\"del\">删除</a>";
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
		onLoadSuccess:function(data){  
			$('.edit').linkbutton({text:"编辑",plain:'true'});
			$('.del').linkbutton({text:"删除",plain:'true',iconCls:'icon-cancel'});
        },
		onDblClickCell: function(index,field,value){
			 var data = $('#dg').datagrid('getData').rows[index];
			 alert(data.uuid);
		}
	});
	
})
</script>
<body>
<h2>员工记录</h2>
	<div id="tb" style="padding:2px 5px;">
		姓名: <input class="easyui-textbox" style="width:110px">
		<a href="#" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add">Add</a>
	</div>
	<table id="dg"></table>
	
</body>
</html>