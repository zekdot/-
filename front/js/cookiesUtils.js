function setCookie(name,value,expires,path,domain,secure){
	document.cookie=name+'='+encodeURI(value)+
	((expires)?";expires="+expires:"")+
	((path)?";path="+path:"")+
	((domain)?";domain="+domain:"")+
	((secure)?";secure":"")
}
function getCookie(name){
	var cookieString=decodeURI(document.cookie)
	//alert(cookieString)
	var cookieArray=cookieString.split("; ")
	for(var i=0;i<cookieArray.length;i++){
		var cookieNum=cookieArray[i].split("=");
		var cookieName=cookieNum[0];
		//alert('找到名称'+cookieName)
		//alert('当前名称为'+cookieName+',要找的为'+name+',情况为'+(name==cookieName))
		if(name==cookieName)
			return cookieNum[1];
	}
	return null
}
function deleteCookie(name){
	var date=new Date()
	date.setTime(date.getTime()-10000);//设置一个过期的时间
	document.cookie=name+"=删除"+";expires="+date.toGMTString();
}