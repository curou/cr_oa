layui.use(['table', 'form', 'jquery', 'element'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , element = layui.element;


    //加载部门列表
    $.ajax({
        type: "POST",
        url: "/getAllDepartment",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            var str = '<option value=""></option>';
            for (var i = 0; i < list.length; i++) {
                str += '<option value="' + list[i].id + '">' + list[i].name + '</option>';
            }
            $("#department").html(str);

        },
        error: function () {
            console.log("获取仓库列表失败！");
        }
    });

    //表格加载
    table.render({
        elem: '#test'
        , url: '/user/list'
        , toolbar: 'default'
        , title: '用户数据表'
        , id: 'userTable' //用作主键 做刷新用
        , page: true
        , limit: 10//默认每页显示数量
        , limits: [10, 20, 30]//每页显示数量类型
        , cols: [[
            {type: 'checkbox',width: 50}
            , {field: 'account', title: '用户名', width: 120, align: 'center'}
            , {field: 'name', title: '姓名', width: 100, align: 'center', sort: true}
            , {field: 'sex', title: '性别', width: 70, align: 'center'}
            , {field: 'mobilePhone', title: '手机', width: 130, align: 'center'}
            , {field: 'role', title: '角色', width: 250, align: 'center'}
            , {field: 'department', title: '所属部门', align: 'center', width: 150}
            , {field: 'createTimeUtc', title: '创建时间', align: 'center', width: 180, sort: true}
        ]]
    });

    form.render();

    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var sex = data.field.userSex;
        var userName = $("#userName").val();
        var mobilePhone = $("#phone").val();
        var department = $("#department").val();

        table.reload('userTable', {
            where: {"name": userName, "mobilePhone": mobilePhone, "department": department, "sex": sex}
        });
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                openAddUser();
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    openUpdateUser(data);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    openDeleteUser(data);
                }
                break;
        }
        ;
    });


    var openDeleteUser = function (json) {
        layer.confirm('确定删除勾选数据吗？', {icon: 3, title: '提示'}, function (index) {
            var arr = new Array();
            for (var i = 0; i < json.length; i++) {
                arr.push(json[i].id);
            }
            $.ajax({
                type: "POST",
                url: "/user/delete",
                traditional: true,
                data: JSON.stringify(arr),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    table.reload("userTable");
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

    var openUpdateUser = function (json) {
        var str = JSON.stringify(json[0])
        $("#editUserHidden").val(str);
        layer.open({
            title: ['编辑用户', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['500px', '425px']
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=user/editUser'
            , success: function (layero, index) {
                //layer高度自适应
                //layer.iframeAuto(index);
            }
            , end: function () {
                var resultHidden = $("#resultHidden").val();
                if (resultHidden == "success") {

                    $("#resultHidden").val("");
                    table.reload("userTable");
                    layer.msg('编辑成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            }
        })
    }

    var openAddUser = function () {
        layer.open({
            title: ['添加用户', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['500px', '425px']
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=user/addUser'
            , success: function (layero, index) {
                //layer高度自适应
                //layer.iframeAuto(index);
            }
            , end: function () {
                var resultHidden = $("#resultHidden").val();
                if (resultHidden == "success") {

                    $("#resultHidden").val("");
                    table.reload("userTable");
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            }
        })
    }


})
