var  loginNamePassed=true;
var userName=$("#name").val();
function isExistUser(loginName){
	$.get("/user/exist"+userName, function(data){
		if(data!=null){
			$("#name_span").text("用户账号已存在，请更换新账号");
			loginNamePassed=false;
		}else{
			$("#name_span").text("");
		}
	}) ;
}
// var billId=$("#billId").val();
// window.location="/bill/toBillUpdate/"+billId;

$("#add").bind("click",function(){
	//判断是否是数字的正则表达式
	var  passed=true;
	var p1 = "^\\d+$";
	if(!$("#name").val())
	{
		$("#name_span").text("请输入用户名");
		passed=false;
	}
	if(!$("#password").val())
	{
		$("#password_span").text("请设置账号密码");
		passed=false;
	}else if(!$("#rpassword").val()){
		$("#password_span").text("请填写确认密码");
		passed=false;
	}else if($("#rpassword").val()!=$("#password").val()){
		$("#password_span").text("确认密码不相同");
		passed=false;
	}
	if(!$("#birthDate").val())
	{
		$("#birthDate_span").text("请输入出生日期");
		passed=false;
	}else{
		var pattern = /^(\d{4})-(\d{2})-(\d{2})$/;
		if(!pattern.test($("#birthDate").val()))
		{
			$("#birthDate_span").text("请输入正确的日期格式，如1988-08-02");
			$("#birthDate").val("");
			passed=false;
		}
	}
	if(!$("#phone").val())
	{
		$("#phone_span").text("请输入电话");
		passed=false;
	}else{
		var pattern = new RegExp(p1);
		if(!pattern.test($("#phone").val()))
		{
			$("#phone_span").text("请输入正确的电话号码");
			$("#phone").val("");
			passed=false;
		}
	}
	if(passed&&loginNamePassed){
		if(confirm("确认提交？"))
			$("#form1").submit();
		else
			return false;
		
	}
});
