layui.use(['table', 'form', 'jquery', 'element'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , element = layui.element;

    //表格加载
    table.render({
        elem: '#demo'
        , url: 'getPerms'
        , toolbar: 'default'
        , title: '权限数据表'
        , id: 'layuiTable' //用作主键 做刷新用
        , page: true
        , limit: 10//默认每页显示数量
        , limits: [10, 20, 30]//每页显示数量类型
        , cols: [[
            {type: 'checkbox',width: 50}
            , {field: 'flag', title: '权限标志', width: 150, align: 'center'}
            , {field: 'name', title: '权限', width: 100, align: 'center'}
            , {field: 'createTimeUtc', title: '创建时间', align: 'center', width: 180, sort: true}
        ]]
    });

    form.render();

    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var permName = data.field.permName;

        table.reload('layuiTable', {
            where: {"keyword": permName}
        });
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                openAddPerm();
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    openUpdatePerm(data);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    openDeletePerm(data);
                }
                break;
        }
        ;
    });

    var openUpdatePerm = function (json) {
        $("#editName").val(json[0].name);
        $("#editId").val(json[0].id);
        $("#editFlag").val(json[0].flag);
        layer.open({
            title: ['编辑权限', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['350px', '220px']//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=user/editPerm'
            , success: function (layero, index) {
                //layer高度自适应
                //layer.iframeAuto(index);
            }
            , end: function () {
                var editResult = $("#editResult").val();
                if (editResult == "success") {

                    $("#editResult").val("");
                    table.reload("layuiTable");
                    layer.msg('编辑成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            }
        })

    }


    var openDeletePerm = function (json) {
        layer.confirm('确定删除勾选数据吗？', {icon: 3, title: '提示'}, function (index) {
            var arr = new Array();
            for (var i = 0; i < json.length; i++) {
                arr.push(json[i].id);
            }
            $.ajax({
                type: "POST",
                url: "/deletePerm",
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

    var openAddPerm = function () {
        layer.open({
            title: ['添加权限', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['350px', '220px']//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=user/addPerm'
            , success: function (layero, index) {
                //layer高度自适应
                //layer.iframeAuto(index);
            }
            , end: function () {
                var addResult = $("#addResult").val();
                if (addResult == "success") {

                    $("#addResult").val("");
                    table.reload("layuiTable");
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            }
        })
    }


})
