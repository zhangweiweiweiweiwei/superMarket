$(function () {
    var length = $("#length").text();
    console.log(length)
    for (i = 1; i <= length; i++) {
        var id1 ='#year1'+i;
        console.log(id1)
        var time1=Date.parse($(id1).text());
        console.log(time1)
        var id2 ='#year2'+i;
        var time2=Date.parse($(id2).text());
        var days=Math.ceil(parseInt((time1-time2)/1000/3600/24/365));
        console.log(days)
        var id3 = '#' + i
        $(id3).text(days)
    }
});