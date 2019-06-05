layui.use(['table', 'form', 'jquery', 'element', 'layer', 'curou'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , layer = layui.layer
        , curou = layui.curou
        , element = layui.element;


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var status = data.field.searchStockStatus;
        var keyword = $("#keyword").val();
        var begin = $("#date1").val();
        var end = $("#date2").val();
        //table.reload();
        table.reload('stockList', {
            where: {"keyword": keyword, "beginStr": begin, "endStr": end, "status": status}
        });
    });

    curou.render({
        elem: '#treeDemo'
        , treeTitle: 'title'//需要树状展示的字段
        , url: '/menu/menuIncludeChildren'
        , isOpen: false//节点是否展开，默认false
        , moveTool:true//是否开启移动菜单工具
        , moveToolIndex:4//移动菜单工具所在列下标，从左按0开始，不配置则在最后一列
        , cols: [
            {filed: "title", align: "center", width: 200, title: "菜单"},
            {
                filed: "icon", align: "center", width: 200, title: "图标", templet: function (data) {
                    if (data.icon == null || data.icon == "") {
                        return "/";
                    } else {
                        return '<i class="' + data.icon + ' edit" style="font-size: 25px;"></i>';
                    }
                }
            },
            {filed: "path", align: "center", width: 200, title: "路径"},
            {filed: "permissionName", align: "center", width: 200, title: "访问权限"},
            {
                filed: "doSth", align: "center", width: 500, title: "操作", templet: function (data) {
                    var str = '';
                    str += '<a class="layui-btn layui-btn-primary layui-btn-sm" lay-event="addNode">添加子节点</a>';
                    str += '<a class="layui-btn layui-btn-sm" lay-event="editNode">编辑</a>';
                    str += '<a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="delNode">删除</a>';
                    if (data.icon == null || data.icon == "") {
                        return str;
                    } else {
                        str += '<a class="layui-btn layui-btn-warm layui-btn-sm" lay-event="editIcon">编辑图标</a>';
                        return str;
                    }
                }
            },
        ]

    });




    $(document).off('click', 'a[lay-event=editIcon]').on('click', 'a[lay-event=editIcon]', function () {
        var obj = {};
        var tr = $(this).parents("tr:first");
        var id = tr.attr("nodeId");
        obj.id = id;
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
                    layer.close(index);
                    var val = $("#iconHidden").val();
                    obj.icon = val;
                    tr.find('i[class$=edit]').attr('class', obj.icon);
                    var json = JSON.stringify(obj);
                    layer.msg(json);
                    $.ajax({
                        type: "POST",
                        url: "/menu/update",
                        traditional: true,
                        dataType: "json",
                        data: json,
                        contentType: "application/json",
                        success: function (data) {
                            layer.msg('编辑成功！', {
                                icon: 1,
                                time: 1000 //如果不配置，默认是3秒
                            });
                        },
                        error: function () {
                            layer.msg('更新图标失败！', {
                                icon: 1,
                                time: 1000 //如果不配置，默认是3秒
                            });
                        }
                    });

                }
            }, btn2: function (index, layero) {
                layer.close(index);
            }, end: function () {
                $("#iconHidden").val("");
            }
        })
    })
    $(document).off('click', 'a[lay-event=addNode]').on('click', 'a[lay-event=addNode]', function () {
        layer.msg('addNode');
    })
    $(document).off('click', 'a[lay-event=editNode]').on('click', 'a[lay-event=editNode]', function () {
        var tr = $(this).parents("tr:first");
        var id = tr.attr('nodeId');
        var pid = tr.attr('nodePid');
        var title = tr.find("span[class=title]").html();
        var permissionName = tr.find("span[class=permissionName]").html();

    });
    $(document).off('click', 'a[lay-event=delNode]').on('click', 'a[lay-event=delNode]', function () {
        var button = $(this);
        layer.confirm('确定删除该节点码？如节点下有子节点，将全部删除！', {icon: 3, title: '提示'}, function (index) {
            var id = button.parents("tr:first").attr('nodeId');
            $.ajax({
                type: "GET",
                url: "/menu/delete",
                traditional: true,
                dataType: "json",
                data: {
                    "id": id
                },
                success: function (data) {
                    initTable();
                    layer.msg('删除成功！', {
                        icon: 1,
                        time: 1000 //如果不配置，默认是3秒
                    });
                },
                error: function () {
                    layer.msg('删除失败！', {
                        icon: 1,
                        time: 1000 //如果不配置，默认是3秒
                    });
                }
            });
        })
    })


})
