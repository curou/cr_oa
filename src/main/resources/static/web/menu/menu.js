layui.use(['table', 'form', 'jquery', 'element'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , element = layui.element;

    //表格加载
    table.render({
        elem: '#demo'
        , url: '/menu/list'
        , toolbar: 'default'
        , title: '菜单数据表'
        , id: 'layuiTable' //用作主键 做刷新用
        , page: true
        , limit: 10//默认每页显示数量
        , limits: [10, 20, 30]//每页显示数量类型
        , cols: [[
            {type: 'checkbox'}
            , {field: 'title', title: '标题', width: 100, align: 'center'}
            , {field: 'sort', title: '顺序', width: 100, align: 'center'}
            , {
                field: 'icon', title: '图标', width: 100, align: 'center', templet: function (res) {

                    return '<i class="' + res.icon + '" style="font-size: 25px;"></i>';

                }
            }
            , {
                field: 'do', title: '操作', width: 100, align: 'center', templet: function (res) {

                    return '<input hidden="hidden" value="' + res.id + '"><button class="layui-btn layui-btn-sm editIcon">更换图标</button>';

                }
            }

        ]]
    });

    form.render();

    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var title = data.field.title;

        table.reload('layuiTable', {
            where: {"keyword": title}
        });
    });

    //更改图标
    $(document).off('click', '.editIcon').on('click', '.editIcon', function () {
        $("#idHidden").val($(this).prev().val());
        layer.open({
            title: ['选择菜单图标', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['630px', '500px']//宽度
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
                    var icon = $("#iconHidden").val();
                    var id = $("#idHidden").val();
                    var obj = {};
                    obj.id = id;
                    obj.icon = icon;
                    var json = JSON.stringify(obj);
                    layer.msg(json);
                    //更新图标
                    $.ajax({
                        type: "POST",
                        url: "/menu/update",
                        traditional: true,
                        dataType: "json",
                        data: json,
                        contentType: "application/json",
                        success: function (list) {
                            table.reload("layuiTable");
                            layer.msg('编辑成功！', {
                                icon: 1,
                                time: 1000 //2秒关闭（如果不配置，默认是3秒）
                            });
                        },
                        error: function () {
                            console.log("更新菜单失败！");
                        }
                    });
                    layer.close(index);
                }

            }, btn2: function (index, layero) {
                layer.close(index);
            }, end: function () {
                $("#iconHidden").val("");
            }
        })
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                var html = "";
                $.ajax({
                    type: "GET",
                    url: "/getFtl?path=menu/addMenu.ftl",
                    async: false,
                    success: function (data) {
                        html = data.result;
                    },
                    error: function () {
                        console.log("调用页面载入方法失败！");
                    }
                });
                $("#mainbody").html(html);
                addMenu();
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    openUpdateMenu(data);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    openDeleteRole(data);
                }
                break;
        }
        ;
    });

    var openDeleteRole = function (json) {
        layer.confirm('确定删除勾选数据吗？', {icon: 3, title: '提示'}, function (index) {
            var arr = new Array();
            for (var i = 0; i < json.length; i++) {
                arr.push(json[i].id);
            }
            $.ajax({
                type: "POST",
                url: "/deleteRole",
                traditional: true,
                data: JSON.stringify(arr),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    table.reload("layuiTable");
                    layer.msg('删除成功！', {
                        icon: 1,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    });
                },
                error: function () {
                    console.log("调用删除方法失败！");
                }
            });
        });
    }


    var openUpdateMenu = function (json) {
        var str = JSON.stringify(json[0]);
        $("#editMenuHidden").val(str);
        layer.open({
            title: ['编辑菜单', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['440px', '220px']//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=menu/editMenu'
            , success: function (layero, index) {
                //layer高度自适应
                //layer.iframeAuto(index);
                //$('iframe').css("display","flex");
            }
            , end: function () {
                var resultHidden = $("#resultHidden").val();
                if (resultHidden == "success") {

                    $("#resultHidden").val("");
                    table.reload("layuiTable");
                    layer.msg('编辑成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            }
        })

    }


})

