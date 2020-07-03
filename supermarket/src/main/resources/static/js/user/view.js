//跳转修改页面
$("#update").bind("click",function(){
	var userId=$("#userId").val();
	window.location="/user/toUserUpdate/"+userId;
});
//删除
$("#del").bind("click",function(){
	var userId=$("#userId").val();
		if(confirm("确认删除？")){
			window.location="/user/userDelete/"+userId;
		}
});
//重置密码
$("#repassword").bind("click",function(){
	var userId=$("#userId").val();
	if(confirm("确认重置密码？")){

	}
});
//得到年龄
$(function () {

	var time1=Date.parse($("#year1").text());
	var time2=Date.parse($("#year2").text());
	var days=Math.ceil(parseInt((time1-time2)/1000/3600/24/365));
	$("#old").text(days)
});
