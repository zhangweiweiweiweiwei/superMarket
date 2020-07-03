$(function () {
    var length = $("#length").text();
    console.log(length)
    for (i = 1; i <= length; i++) {
        //此处为字符串拼接  为时间戳（加上id方便定位输出时定位到相应的id用户）  勋魂遍历所有用户，则每个id对应一个年龄
        var id1 ='#year1'+i;
        console.log(id1)
        var time1=Date.parse($(id1).text());
        console.log(time1)
        var id2 ='#year2'+i;
        var time2=Date.parse($(id2).text());
        // 时间戳由毫秒到年
        var days=Math.ceil(parseInt((time1-time2)/1000/3600/24/365));
        console.log(days)
        // 此处为关键理解，字符串拼接id3  意味着为$(#i),对应id值输出年龄
        var id3 = '#' + i
        $(id3).text(days)
    }
});