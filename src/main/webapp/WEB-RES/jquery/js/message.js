function msgShow(title,message) {
	$.messager.show({
		title : title,
		msg : message,
		showType : 'fade',
		timeout : 800,
		style:{ 
            right:'', 
            top:document.body.scrollTop+document.documentElement.scrollTop, 
            bottom:'' 
        } 
	});
}