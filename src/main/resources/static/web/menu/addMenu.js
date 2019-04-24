layui.use(['layer', 'jquery', 'form'], function () {
    var layer = layui.layer
        , $ = layui.jquery
        , form = layui.form;

    //监听提交
    form.on('submit(demo1)', function (data) {
        var str = JSON.stringify(data.field);
        layer.msg(str);
        $.ajax({
            type: "POST",
            url: "/addMenu",
            data: str,
            dataType: "json",
            contentType: "application/json",
            success: function (msg) {
                console.log("调用添加菜单方法成功！");
                //$("#menuForm")[0].reset();
                //form.render();
                layer.msg('添加成功！', {
                    icon: 1,
                    time: 500 //如果不配置，默认是3秒
                }, function () {
                    location.reload();
                });
            },
            error: function (msg) {
                console.log(str);
                console.log("调用添加菜单方法失败！");
                //清空表单
                $("#menuForm")[0].reset();
                form.render();
            }
        });
    });

    var openIcon = function (width, height) {
        layer.open({
            title: ['选择菜单图标', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: [width + 'px', height + 'px']//宽度
            , shadeClose: true
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: "/icon"
            , btn: ['确定', '关闭']
            , yes: function (index, layero) {
                var val = $("#iconHidden").val();
                if (val == "" || val == null) {
                    layer.msg("请选择图标！");
                } else {
                    layer.close(index);
                    var val = $("#iconHidden").val();
                    $("#icon").attr("class", val);
                    $("#iconInput").val(val);
                }
            }, btn2: function (index, layero) {
                layer.close(index);
            }, end: function () {
                $("#iconHidden").val("");
            }
        })
    }

    $("#goBack").click(function () {
        $("a[url=menu]").click();
    });


    $("#icon").click(function () {
        var windowWidth = $(window).width();
        if (windowWidth < 768) {
            openIcon(300, 300);
            // layer.open({
            //     title: ['选择菜单图标', 'font-size:18px;']
            //     , shade: 0.6 //遮罩透明度
            //     , area: ['285px', '300px']//宽度
            //     , shadeClose:true
            //     , type: 2
            //     , anim: 1 //0-6的动画形式，-1不开启
            //     , content: "/icon"
            //     ,btn: ['确定', '关闭']
            //     ,yes: function(index, layero){
            //         var val = $("#iconHidden").val();
            //         if(val==""||val==null){
            //             layer.msg("请选择图标！");
            //         }else{
            //             layer.close(index);
            //             var val = $("#iconHidden").val();
            //             $("#icon").attr("class", val);
            //             $("#iconInput").val(val);
            //         }
            //     },btn2: function(index, layero){
            //         layer.close(index);
            //     },end:function(){
            //         $("#iconHidden").val("");
            //     }
            // })
        } else {
            openIcon(630, 500);
            //     layer.open({
            //         title: ['选择菜单图标', 'font-size:18px;']
            //         , shade: 0.6 //遮罩透明度
            //         , area: ['630px', '500px']//宽度
            //         , type: 2
            //         , shadeClose:true
            //         , anim: 1 //0-6的动画形式，-1不开启
            //         , content: "/icon"
            //         ,btn: ['确定', '关闭']
            //         ,yes: function(index, layero){
            //             var val = $("#iconHidden").val();
            //             if(val==""||val==null){
            //                 layer.msg("请选择图标！");
            //             }else{
            //                 layer.close(index);
            //                 debugger;
            //                 var val = $("#iconHidden").val();
            //                 $("#icon").attr("class", val);
            //                 $("#iconInput").val(val);
            //             }
            //         },btn2: function(index, layero){
            //             layer.close(index);
            //         },end:function(){
            //             $("#iconHidden").val("");
            //         }
            //     })
        }

    });


});
