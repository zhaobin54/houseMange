function del(id,index,url) { 
	$.messager.confirm('确认', '确认删除?', function(row) {
		if (row) {
			var data = $('#dg'+id).datagrid('getData').rows[index];
			$.ajax({
				url : url,
				dataType : "json",
				data:{
					"uuid":data.uuid,	
				},
				success : function(data) {
					if(data.success==true){
						msgShow('提示',"删除成功");
						$('#dg'+id).datagrid('reload');
					}else{
						msgShow('提示',"删除失败");
					}
				}
			});
			
		}
	})
}

function initDialog(id,title,width,heigt,url,func){
	$('#'+id).dialog({
	    title: title,
	    width: width,
	    height: heigt,
	    closed: true,
	    minimizable:true,
	    maximizable:true,
	    modal: true,
	    buttons: [{
			text:'save',
			iconCls:'icon-save',
			handler:function(){
				$.ajax({
					type : "POST",
					url : url,
					dataType : "json",
					data:$("#frm"+id).serialize(),
					error : function() {
						msgShow('提示','error!');
					},
					success : function(data, textStatus) {
						msgShow('提示','操作成功!');
						$('#'+id).dialog('close');
						$('#dg'+id).datagrid('reload');
					}
				});
			}
		},{
			text:'Cancel',
			iconCls:'icon-cancel',
			handler:function(){
				$('#'+id).dialog('close');
			}
		}]
	});
}

function editDialog(id,title,width,heigt,url,data){
	$('#'+id).dialog({
	    title: title,
	    width: width,
	    height: heigt,
	    closed: true,
	    minimizable:true,
	    maximizable:true,
	    modal: true,
	    buttons: [{
			text:'update',
			iconCls:'icon-save',
			handler:function(){
				$.ajax({
					type : "POST",
					url : url,
					dataType : "json",
					data:$("#frm"+id).serialize(),
					error : function() {
						msgShow('提示','error!');
					},
					success : function(data, textStatus) {
						msgShow('提示','操作成功!');
						$('#'+id).dialog('close');
						$('#dg'+id).datagrid('reload');
					}
				});
			}
		},{
			text:'Cancel',
			iconCls:'icon-cancel',
			handler:function(){
				$('#'+id).dialog('close');
			}
		}]
	});
}