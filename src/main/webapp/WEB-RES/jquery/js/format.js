function myformatter(date) {
	var y = date.getFullYear();
	var m = date.getMonth() + 1;
	var d = date.getDate();
	return y + '-' + (m < 10 ? ('0' + m) : m) + '-' + (d < 10 ? ('0' + d) : d);
}
function myparser(s) {
	if (!s)
		return new Date();
	var ss = (s.split('-'));
	var y = parseInt(ss[0], 10);
	var m = parseInt(ss[1], 10);
	var d = parseInt(ss[2], 10);
	if (!isNaN(y) && !isNaN(m) && !isNaN(d)) {
		return new Date(y, m - 1, d);
	} else {
		return new Date();
	}
}

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
		"0": "星期日",
		"1": "星期一",
		"2": "星期二",
		"3": "星期三",
		"4": "星期四",
		"5": "星期五",
		"6": "星期六"
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
function formatDate(value){
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
}