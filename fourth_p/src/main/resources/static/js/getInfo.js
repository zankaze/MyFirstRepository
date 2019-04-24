$.ajax({
    type: "get",
    url: 'getUserName',
    async: false, // 使用同步方式
    contentType: "application/json; charset=utf-8",
    success: function(data) {
        $("#touxiang").attr("src",data.headportrait);
        var uname = document.getElementById("username")
        var jifen = document.getElementById("jifen")
        uname.innerText=data.username;
        jifen.innerText=data.userintegral;

    }
});
$.ajax({
    type:"get",
    url:"getUserName",
    async: false,
    contentType: "application/json; charset=utf-8",
    success:function (data) {
        var level=data.userlevel;
        if(level!="0"){
            var Str = "<a href='snake.html' class=\"tpl-dropdown-content-message\">\n" +
                "<span class=\"tpl-dropdown-content-photo\">\n" +
                "<img src=\"img/tanchishe.jpg\" alt=\"\"> </span>\n" +
                "<span class=\"tpl-dropdown-content-subject\">\n" +
                "<span class=\"tpl-dropdown-content-from\">贪吃蛇</span>\n" +
                "</span>\n" +
                "<span class=\"tpl-dropdown-content-font\"> 尊贵VIP的专享游戏，获得大量积分的同时还可以锻炼手脑的反应  </span>\n" +
                "</a>";
            $("#youxi").append(Str);
        }else{

            var Str2="<li>\n" +
                " <a href=\"personal-center.html\" class=\"tpl-dropdown-content-message\">\n" +
                "<span class=\"tpl-dropdown-content-photo\">\n" +
                "<img src=\"img/vip.png\" alt=\"\"> </span>\n" +
                "<span class=\"tpl-dropdown-content-subject\">\n" +
                "<span class=\"tpl-dropdown-content-from\">办理VIP</span>\n" +
                "<span class=\"tpl-dropdown-content-font\"> 成为尊贵的VIP，畅玩所有游戏,获得双倍积分！ </span>\n" +
                "</span></a>\n" +
                " </li>";
            $("#chongzhi").append(Str2);
        }


    }
});