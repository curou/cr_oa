//初始化自定义菜单
// layui.use('jquery', function () {
//     var $ = layui.jquery;
//
//     // var script = document.createElement("script");
//     // script.type = "text/javascript";
//     // script.appendChild(document.createTextNode($("#aa").html()));
//     // document.body.appendChild(script);
//     // getPermission();
//
//
//     $.ajax({
//         type: "POST",
//         url: "/menu/getAll",
//         dataType: "json",
//         async:false,
//         contentType: "application/json",
//         success: function (data) {
//             var val ="";
//             for (var i = 0; i < data.length; i++) {
//                 for (var j = 0; j <data[i].length ; j++) {
//                     // if(i==0&j==0){
//                     //     //菜单默认展开
//                     //     //val='<li class="layui-nav-item layui-nav-itemed">';
//                     //     val+='<li class="layui-nav-item">';
//                     // }
//                     // if(i!=0&j==0){
//                     //     val+='<li class="layui-nav-item">';
//                     // }
//                     if(j==0){
//                         val+='<li class="layui-nav-item">';
//                         val+='<a href="javascript:;" url="'+data[i][j].url+'" title="'+data[i][j].title+'"><i class="'+data[i][j].icon+'"></i><cite class="menu">'+data[i][j].title+'</cite></a>';
//                         continue;
//                     }
//                     //如果只有2行
//                     if(j==1&&j==data[i].length-1){
//                         val+='<dl class="layui-nav-child">';
//                         val+='<dd><a style="padding-left: 45px;" href="javascript:;" url="'+data[i][j].url+'">'+data[i][j].title+'</a></dd></dl></li>';
//                         continue;
//                     }
//                     if(j==1&&j!=data[i].length-1){
//                         val+='<dl class="layui-nav-child">';
//                         val+='<dd><a style="padding-left: 45px;" href="javascript:;" url="'+data[i][j].url+'">'+data[i][j].title+'</a></dd>';
//                         continue;
//                     }
//                     if(j==data[i].length-1){
//                         val+='<dd><a style="padding-left: 45px;" href="javascript:;" url="'+data[i][j].url+'">'+data[i][j].title+'</a></dd></dl></li>';
//                     }else{
//                         val+='<dd><a style="padding-left: 45px;"href="javascript:;" url="'+data[i][j].url+'">'+data[i][j].title+'</a></dd>';
//                     }
//                 }
//             }
//
//             console.log(val);
//             $("#navtree").html(val);
//         },
//         error: function () {
//             console.log("菜单载入失败！");
//         }
//     });
// })

//初始化全局
layui.use(['table', 'form', 'jquery', 'element'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , element = layui.element;

    //窗口宽度
    var windowWidth = $(window).width();

    //窗口宽度标准
    var windowWidthCriterion = 880;

    //窗口状态，缩小时为0，展开时为1
    var flexStatus;

    //菜单伸缩状态，隐藏状态0，显示图标状态60，展开状态200
    var menuStatus;

    //伸缩状态，true为伸缩动画完成，false为伸缩动画未完成
    var animateStatus = true;

    //伸缩速度
    var animateSpeed = 100;

    //载入时窗口宽度小于标准
    if (windowWidth <= windowWidthCriterion) {
        flexStatus = 0;
        menuStatus = 0;
        $(".layui-body").css({"position": "relative", "top": "0px"});
        $("#menu-button").find("i").attr("class", "layui-icon layui-icon-spread-left");
        $("#menu-button").attr("class", "showtab");

        $("#leftmenu").animate({left: $("#leftmenu").position().left - 200 + "px"}, animateSpeed);
        //$(".layui-logo").animate({width: $(".layui-logo").width() - 200 + "px"},animateSpeed);
        $(".layui-side-menu").animate({width: $(".layui-side-menu").width() - 200 + "px"}, animateSpeed);
        //正文伸缩
        $(".layui-body").animate({left: $(".layui-body").position().left - 200 + "px"}, animateSpeed, null, function () {
            $("#logoStatus").val($("#logo").html());
            $("#logo").html("");
        });
    }
    if (windowWidth > windowWidthCriterion) {
        flexStatus = 1;
        menuStatus = 200;
    }

    //控制菜单文本隐藏显示
    var menuTextChange = function (status) {
        $(".layui-nav-tree").find("li").each(function (em, ind) {
            $(this).find("cite").css("display", status);
            $(this).find("dl").css("display", status);
        });
    }

    var menuButtonChange = function (status) {
        if (status == "show") {
            $("#menu-button").attr("class", "showtab");
            $("#menu-button").find("i").attr("class", "layui-icon layui-icon-spread-left");
        } else if (status == "hide") {
            $("#menu-button").attr("class", "hidetab");
            $("#menu-button").find("i").attr("class", "layui-icon layui-icon-shrink-right");
        }

    }


    //当浏览器大小变化时
    $(window).resize(function () {
        windowWidth = $(window).width();
        //窗口宽度小于标准并且处于展开状态时
        if (windowWidth <= windowWidthCriterion && flexStatus == 1) {
            //窗口伸缩状态为隐藏
            flexStatus = 0;

            if (menuStatus == 60) {//左侧菜单处于半收缩状态
                //logo恢复
                $("#logo").css("text-align", "center");
                $("#companyName").css("display", "none");
                $("#osName").css("display", "");
                //头部左侧图标
                $("#leftmenu").animate({left: $("#leftmenu").position().left - 60 + "px"}, animateSpeed);
                //logo
                //$(".layui-logo").animate({width: $(".layui-logo").width() - 200 + "px"},animateSpeed);
                //左侧菜单
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() - 60 + "px"}, animateSpeed);
                //正文伸缩
                $(".layui-body").animate({left: $(".layui-body").position().left - 60 + "px"}, animateSpeed);
            } else {

                menuStatus = 0;
                //菜单收缩图标改变方向
                menuButtonChange("show");
                $("#leftmenu").animate({left: $("#leftmenu").position().left - 200 + "px"}, animateSpeed);

                //$(".layui-logo").animate({width: $(".layui-logo").width() - 200 + "px"},animateSpeed);
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() - 200 + "px"}, animateSpeed);
                //正文伸缩
                $(".layui-body").animate({left: $(".layui-body").position().left - 200 + "px"}, animateSpeed);

            }

        }
        //窗口宽度大于标准并且处于缩小状态时
        if (windowWidth > windowWidthCriterion && flexStatus == 0) {
            //窗口伸缩状态为展开
            flexStatus = 1;
            $(".layui-body").css({"position": "absolute", "top": "60px"});
            if (menuStatus == 60) {//左侧菜单处于图标状态
                console.log("小窗口处于图标状态");
                $("#logo").css("text-align", "center");
                $("#companyName").css("display", "none");
                $("#osName").css("display", "");
                $("#leftmenu").animate({left: $("#leftmenu").position().left + 200 + "px"}, animateSpeed);
                //$(".layui-logo").animate({width: $(".layui-logo").width() + 200 + "px"},animateSpeed);
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() + 60 + "px"}, animateSpeed);
                //正文伸缩
                $(".layui-body").animate({left: $(".layui-body").position().left + 60 + "px"}, animateSpeed);
                //$("#logo").html($("#logoStatus").val());
            } else if (menuStatus == 200) {
                //$("#logo").html($("#logoStatus").val());
                $(".layui-header").animate({left: $(".layui-header").position().left - 200 + "px"}, animateSpeed);
                $("#leftmenu").animate({left: $("#leftmenu").position().left + 200 + "px"}, animateSpeed);
                $(".layui-body").css({"position": "absolute", "top": "60px"});
                //$(".layui-body").animate({left: $(".layui-body").position().left - 200 + "px"},animateSpeed);
                //$("#leftmenu").animate({left: $("#leftmenu").position().left + 200 + "px"},animateSpeed);
                //{left: $(".layui-header").position().left + 200+ "px"},animateSpeed);
                //$(".layui-logo").animate({width: $(".layui-logo").width() + 200 + "px"},animateSpeed);
            } else if (menuStatus == 0) {
                menuStatus = 200;
                //菜单收缩图标改变方向
                menuButtonChange("hide");
                $("#leftmenu").animate({left: $("#leftmenu").position().left + 200 + "px"}, animateSpeed);
                //$(".layui-logo").animate({width: $(".layui-logo").width() + 200 + "px"},animateSpeed);
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() + 200 + "px"}, animateSpeed);
                //正文伸缩
                $(".layui-body").animate({left: $(".layui-body").position().left + 200 + "px"}, animateSpeed);
                // $("#logo").html($("#logoStatus").val());
            }
        }
    });


    //左侧垂直菜单监控
    element.on('nav(navtree)', function (elem) {
        //判断是否收缩状态
        if (menuStatus == 60) {
            menuStatus = 200;
            menuButtonChange("hide");
            menuTextChange("");
            $("#logo").css("text-align", "center");
            $("#companyName").css("display", "none");
            $("#osName").css("display", "");
            $(".layui-side-menu").animate({width: $(".layui-side-menu").width() + 140 + "px"}, animateSpeed);
            $(".layui-body").animate({left: $(".layui-body").position().left + 140 + "px"}, animateSpeed);
            $(".layui-layout-left").animate({left: $(".layui-layout-left").position().left + 140 + "px"}, animateSpeed);
        } else {
            //展开状态点击操作
            var url = $(this).attr("url");
            if (url != "main") {
                loadMainBody($(this).attr("path"));
                if (flexStatus == 0) {
                    menuButtonChange("show");
                    menuStatus = 0;
                    $(".layui-body").css({"position": "absolute", "top": "60px"});
                    $(".layui-side-menu").animate({width: $(".layui-side-menu").width() - 200 + "px"}, animateSpeed);
                    $(".layui-body").animate({left: $(".layui-body").position().left - 200 + "px"}, animateSpeed);
                    $(".layui-header").animate({left: $(".layui-header").position().left - 200 + "px"}, animateSpeed);
                }
            }


        }
    })

    //顶部左侧菜单监控
    element.on('nav(leftmenu)', function (elem) {
        while (!animateStatus) {

        }
        //隐藏显示侧边菜单
        if (elem[0].className == "hidetab") {//隐藏
            animateStatus = false;
            menuButtonChange("show");

            if (windowWidth <= windowWidthCriterion) {
                $(".layui-body").css({"position": "absolute", "top": "60px"});
                menuStatus = 0;
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() - 200 + "px"}, animateSpeed);
                $(".layui-header").animate({left: $(".layui-header").position().left - 200 + "px"}, animateSpeed);
                $(".layui-body").animate({left: $(".layui-body").position().left - 200 + "px"}, animateSpeed, null, function () {
                    animateStatus = true;
                });
            } else {
                $("#logo").css("text-align", "left");
                $("#companyName").css("display", "");
                $("#osName").css("display", "none");
                menuStatus = 60;
                //侧边菜单只显示图标
                menuTextChange("none");
                //侧边菜单伸缩
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() - 140 + "px"}, animateSpeed);
                $(".layui-layout-left").animate({left: $(".layui-layout-left").position().left - 140 + "px"}, animateSpeed);
                //正文伸缩
                $(".layui-body").animate({left: $(".layui-body").position().left - 140 + "px"}, animateSpeed, null, function () {
                    animateStatus = true;
                });
            }
        } else if (elem[0].className == "showtab") {//显示
            animateStatus = false;
            menuStatus = 200;
            menuButtonChange("hide");
            menuTextChange("");
            $("#logo").css("text-align", "center");
            $("#companyName").css("display", "none");
            $("#osName").css("display", "");
            if (windowWidth > windowWidthCriterion) {
                console.log("大窗口显示菜单");
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() + 140 + "px"}, animateSpeed);
                $(".layui-layout-left").animate({left: $(".layui-layout-left").position().left + 140 + "px"}, animateSpeed);
                $(".layui-body").animate({left: $(".layui-body").position().left + 140 + "px"}, animateSpeed, null, function () {
                    animateStatus = true;
                });
            } else {
                console.log("小窗口显示菜单");
                //$("#logo").html($("#logoStatus").val());
                $(".layui-body").css({"position": "relative", "top": "0px"});
                $(".layui-side-menu").animate({width: $(".layui-side-menu").width() + 200 + "px"}, animateSpeed);
                $(".layui-header").animate({left: $(".layui-header").position().left + 200 + "px"}, animateSpeed);
                $(".layui-body").animate({left: $(".layui-body").position().left + 200 + "px"}, animateSpeed, null, function () {
                    animateStatus = true;
                });
            }
        }
    });


    var loadMainBody = function (path) {
        var html = "";
        $.ajax({
            type: "GET",
            url: "/getFtl?path=" + path+".ftl",
            async: false,
            success: function (data) {
                html = data.result;
                $("#mainbody").html(html);
                loadJS(path);
            },
            error: function () {
                console.log("调用页面载入方法失败！");
                layer.msg('还没添加内容，敬请期待！',
                    {icon: 2, time: 1000}
                );
            }
        });
    }
    var loadJS = function(path){
        jQuery.getScript("web/"+path+".js")
            .done(function () {
                console.log("异步加载JS成功！");
            })
            .fail(function () {
                console.log("异步加载JS失败！");
            });
    }


})










