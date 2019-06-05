layui.use(['table', 'form', 'jquery', 'element'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , element = layui.element;

    //表格加载
    table.render({
        elem: '#demo'
        , url: 'getRoles'
        , toolbar: 'default'
        , title: '角色数据表'
        , id: 'layuiTable' //用作主键 做刷新用
        , page: true
        , limit: 10//默认每页显示数量
        , limits: [10, 20, 30]//每页显示数量类型
        , cols: [[
            {type: 'checkbox',width: 60}
            // , {field: 'flag', title: '标志', width: 100, align: 'center'}
            , {field: 'name', title: '角色名', width: 200, align: 'center'}
            , {field: 'perm', title: '权限', width: 300, align: 'center'}
            , {field: 'createTimeUtc', title: '创建时间', align: 'center', width: 220, sort: true}
        ]]
    });

    form.render();

    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var roleName = data.field.roleName;

        table.reload('layuiTable', {
            where: {"keyword": roleName}
        });
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                openAddRole();
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    openUpdateRole(data);
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

    var openAddRole = function () {
        layer.open({
            title: ['添加角色', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['400px', '215px']//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=user/addRole'
            , success: function (layero, index) {
                //layer高度自适应
                //layer.iframeAuto(index);
            }
            , end: function () {
                var resultHidden = $("#resultHidden").val();
                if (resultHidden == "success") {

                    $("#resultHidden").val("");
                    table.reload("layuiTable");
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            }
        })
    }

    var openUpdateRole = function (json) {
        $("#editRoleNameHidden").val(json[0].name);
        $("#editRoleIdHidden").val(json[0].id);
        $("#editRolePermHidden").val(json[0].perm);
        $("#editRolePermIdHidden").val(json[0].permId);
        layer.open({
            title: ['编辑角色', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['440px', '220px']//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=user/editRole'
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
