$("#add").bind("click",function(){
	//判断是否是数字的正则表达式
	var  passed=true;
	var p1 = "^\\d+$";
	if(!$("#productName").val())
	{
		$("#productName_span").text("请输入商品名称");
		passed=false;
	}
	if(!$("#productUnit").val())
	{
		$("#productUnit_span").text("请输入商品单位");
		passed=false;
	}
	
	if(!$("#productCount").val())
	{
		$("#productCount_span").text("请输入商品数量");
		passed=false;
	}else{
		var pattern = new RegExp(p1);
		if(!pattern.test($("#productCount").val()))
		{
			$("#productCount_span").text("请输入正确的商品数量");
			$("#productCount").val("");
			passed=false;
		}else{
			$("#productCount_span").text("");
		}
	}
	
	if(!$("#billMoney").val())
	{
		$("#billMoney_span").text("请输入总额");
		passed=false;
	}else{
		var pattern = new RegExp(p1);
		if(!pattern.test($("#billMoney").val()))
		{
			$("#billMoney_span").text("请输入正确的总额数字");
			$("#billMoney").val("");
			passed=false;
		}else{
			$("#billMoney_span").text("");
		}
	}
	
	if(!$("#proId").val())
	{
		$("#proId_span").text("请选择供应商");
		passed=false;
	}
	
	if(passed){
		if(confirm("确认提交？"))
			$("#form1").submit();
		else
			return false;
		
	}
});
