<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${pageContext.request.contextPath }"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>员工管理</title>
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${ctx}/WEB-RES/jquery/demo.css">
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/js/address.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/js/format.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/js/message.js"></script>
	<script type="text/javascript" src="${ctx}/WEB-RES/jquery/js/common.js"></script>
</head>
<script type="text/javascript">
var baseUrl="${ctx}";

$(function(){
	$('#dgdd').datagrid({
	    url:baseUrl+'/employee/list.htmls',
	    columns:[[
	        {field:'name',title:'姓名',width:'15%',align:'center'},
	        {field:'phone',title:'联系方式',width:"15%",align:'center'},
	        {field:'birthday',title:'生日',width:"15%",align:'center',formatter:function(value,row,index){
	        	return formatDate(value);
	        }},
	        {field:'province',title:'所属省份',width:"15%",align:'center'},
	        {field:'city',title:'所属城市',width:"15%",align:'center'},
	        {field:'district',title:'所属区域',width:"10%",align:'center'},
	        {field:'listprice',title:'操作',width:"15%",align:'center',
	        	formatter:function(value,row,index){
	        		var url=baseUrl+"/employee/delEm.htmls";
	        		return "<a href=\"javascript:del('dg',"+index+",'"+url+"')\" class=\"del\">删除</a>";	
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
			$('.del').linkbutton({text:"删除",plain:'true',iconCls:'icon-cancel'});
        },
		onDblClickCell: function(index,field,value){
			var data = $('#dgdd').datagrid('getData').rows[index];
			 $('#dd').dialog('open').dialog('center').dialog('setTitle','编辑');
			 $('#frmdd').form('load', {  
				    uuid:data.uuid,
				    name: data.name,  
				    birthday : formatDate(data.birthday),  
				    phone : data.phone,  
		      });  
			 addressInit('cmbProvince', 'cmbCity', 'cmbArea',data.province,data.city,data.district); 
		}
	});
	 initDialog('dd','新增',400,200,baseUrl+'/employee/addEm.htmls');
	 addressInit('cmbProvince', 'cmbCity', 'cmbArea'); 
});

function add(){
	$('#frmdd').form('clear');
	$('#dd').dialog('open').window('center').dialog('setTitle','新增');
	addressInit('cmbProvince', 'cmbCity', 'cmbArea'); 
}

function search(){
	 $('#dgdd').datagrid('load',{  
         name:$('#searchKey').textbox('getValue') 
        }  
      );
}

</script>
<body>
<h2>员工记录</h2>
	<div id="tb" style="padding:2px 5px;">
		姓名: <input class="easyui-textbox" style="width:110px" id="searchKey"/>
		<a href="javascript:search()" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		<a href="javascript:add()" class="easyui-linkbutton" iconCls="icon-add">Add</a>
	</div>
	<table id="dgdd"></table>
	<div class="easyui-dialog" title="Basic Dialog" data-options="iconCls:'icon-save'" id="dd">
		<form id="frmdd" method="post">
		     <input type="hidden" name="uuid" id="uuid"/>
			 <table>
			   <tr>
			      <th  style="text-align: right;">姓名：</th>
			      <td  style="text-align: left;">
			         <input id="name" class="easyui-textbox" name="name" style="width:100px;" data-options="required:true"/>
			      </td>
			      <th style="text-align: right;">生日：</th>
			      <td  style="text-align: left;">
			        <input id="birthday" class="easyui-datebox" name="birthday" style="width:100px;"  data-options="required:true,validType:'md[\'10/11/2015\']',formatter:myformatter,parser:myparser"/>
			      </td>
			   </tr>
			  <tr>
			      <th  style="text-align: right;">联系方式：</th>
			      <td  style="text-align: left;" colspan="3">
			         <input id="phone" class="easyui-textbox" name="phone" style="width:200px;" data-options="required:true"/>
			      </td>
			   </tr>
			   <tr>
			      <th  style="text-align: right;">地址：</th>
			      <td  style="text-align: left;" colspan="3">
			            <select  id="cmbProvince" name="province" style="height: 25px;width: 80px;"></select>  
                        <select id="cmbCity" name="city" style="height: 25px;width: 80px;"></select>  
                        <select id="cmbArea" name="district" style="height: 25px;width: 80px;"></select> 
			      </td>
			   </tr>
			 </table>
		</form>
	</div>
</body>
</html>