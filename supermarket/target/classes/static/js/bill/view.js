//跳转修改页面
$("#update").bind("click",function(){
	var billId=$("#billId").val();
	window.location="/bill/toBillUpdate/"+billId;
});
//删除
$("#del").bind("click",function(){
	var billId=$("#billId").val();
		if(confirm("确认删除？")){
			window.location="/bill/billDelete/"+billId;
		}
});
