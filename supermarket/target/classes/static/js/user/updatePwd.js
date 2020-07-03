
//修改密码
$("#update").bind("click",function(){
	var userId=$("#userId").val();
	var oldPwd=$("#oldPassword").val();
	var newPwd=$("#newPassword").val();
	if(confirm("确认修改密码？")){
		//window.location="/user/toPwdUpdate/"+newPwd;
		$.ajax({
			url:"/user/toPwdUpdate/"+newPwd,
			type:"post",
			success:function (data) {
				console.log(data);
				if (data === "登录成功"){
					top.location = "/login";
				}
			}
		})
	}
});
