var passed=true;
$("#update").bind("click",function(){
	//判断是否是数字的正则表达式
	passed=true;
	var p1 = "^\\d+$";
	if(!$("#name").val())
	{
		$("#name_span").text("请输入用户名");
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
	if(passed){
		if(confirm("确认修改？"))
			$("#form1").submit();
		else
			return false;
		
	}
});
