var proNamePassed = true;

function isExist(proName) {
    $.post("provider.do", {method: "exist", proName: proName}, function (data) {
        if (data) {
            $("#proName_span").text("供应商已存在");
            proNamePassed = false;
        } else {
            $("#proName_span").text("");
            proNamePassed = true;
        }
    });
}

$("#proName").bind("blur", function () {
    if ($("#proName").val()) {
        isExist($("#proName").val());
    }
});

$("#add").bind("click", function () {
    //判断是否是数字的正则表达式
    var passed = true;
    var p1 = "^\\d+$";
    if (!$("#proName").val()) {
        $("#proName_span").text("请输入供应商名称");
        passed = false;
    }
    if (!$("#proContact").val()) {
        $("#proContact_span").text("请输入联系人");
        passed = false;
    }

    if (!$("#proPhone").val()) {
        $("#proPhone_span").text("请输入电话");
        passed = false;
    } else {
        var pattern = new RegExp(p1);
        if (!pattern.test($("#proPhone").val())) {
            $("#proPhone_span").text("请输入正确的电话号码");
            $("#proPhone").val("");
            passed = false;
        } else {
            $("#proPhone_span").text("");
        }
    }
    if (passed && proNamePassed) {
        if (confirm("确认提交？"))
            $("#form1").submit();
        else
            return false;

    }
});
