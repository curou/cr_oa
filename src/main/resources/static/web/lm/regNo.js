layui.use(['table', 'form', 'jquery', 'element', 'laydate', 'carousel', 'upload', 'slider'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element
        , upload = layui.upload;//上传

    var html = "";
    $.ajax({
        type: "GET",
        url: "/getFtl?path=lm/regNo.ftl",
        async: false,
        dataType: "json",
        success: function (data) {
            html = data.result;
        },
        error: function () {
            console.log("调用页面载入方法失败！");
        }
    });

    $("#mainbody").html(html);

    //遍历项目列表
    $.ajax({
        type: "POST",
        url: "/getAllProject",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            var str = '<option value=""></option>';
            for (var i = 0; i < list.length; i++) {
                str += '<option value="' + list[i].id + '">' + list[i].proName + '</option>';
            }
            $("#proType").html(str);
        },
        error: function () {
            console.log("获取项目列表失败！");
        }
    });

    //遍历卡类型列表
    $.ajax({
        type: "POST",
        url: "/getAllCard",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            var str = '<option value=""></option>';
            for (var i = 0; i < list.length; i++) {
                str += '<option value="' + list[i].id + '">' + list[i].cardName + '</option>';
            }
            $("#cardType").html(str);
        },
        error: function () {
            console.log("获取卡类型列表失败！");
        }
    });

    //日期
    laydate.render({
        elem: '#date1'
        , type: 'datetime'
    });
    laydate.render({
        elem: '#date2'
        , type: 'datetime'
    });


    //初始化数据表格
    table.render({
        elem: '#demo'
        , id: "layuiTable"
        , url: 'lmRegistrationCode/list' //数据接口
        , title: '查询明细表'
        , page: true //开启分页
         , toolbar: '#toolbarDemo'
        , limit: 50
        , limits: [50,100,200,500]
        , cols: [[ //表头
            {type: 'numbers', title: '序号'}
            , {field: 'code', align: 'center', title: '注册码', width: 300}
            , {field: 'cardName', align: 'center', title: '卡类型', width: 85}
            , {field: 'proName', align: 'center', title: '项目类型', width: 95}
            , {field: 'remark', align: 'center', title: '备注', width: 95}
            , {field: 'status', align: 'center', title: '状态', width: 80,templet: function (res) {
                   if(res.status==0){
                        return "未使用";
                   }else if(res.status==1){
                        return "使用中";
                    }else{
                        return "已过期";
                    }
                }

           }
            , {field: 'createTimeUtc', align: 'center', title: '创建时间', width: 180}
            , {field: 'activationTime', align: 'center', title: '激活时间', width: 180}
            , {field: 'expirationTime', align: 'center', title: '到期时间', width: 180}
            ,{
                fixed:"right",filed: "doSth", align: "center", width: 280, title: "操作", templet: function (data) {
                    var str = '';
                    if (data.freezeStatus == 0) {
                        str += '<span hidden="hidden">'+data.id+'</span><a class="layui-btn layui-btn-primary layui-btn-sm freeze">冻结</a>';
                    } else {
                        str += '<span hidden="hidden">'+data.id+'</span><a class="layui-btn layui-btn-primary layui-btn-sm freeze">解冻</a>';
                    }
                    if (data.status != 0) {
                        str += '<a class="layui-btn layui-btn-sm renewal">续费</a>';
                    }
                    str += '<a class="layui-btn layui-btn-danger layui-btn-sm del">删除</a>';
                    if (data.bindStatus == 0) {
                        return str;
                    } else {
                        str += '<a class="layui-btn layui-btn-warm layui-btn-sm unbind">解绑</a>';
                        return str;
                    }
                }
            },
        ]]
    });
    form.render();

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                openAddRegCode();
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        }
        ;
    });

    $(document).off('click', '.freeze').on('click', '.freeze', function (data) {
        var id = $(this).parent().find("span").html();
        var str = $(this).html();
        freezeCode(id,str);
    });
    $(document).off('click', '.addCode').on('click', '.addCode', function (data) {
        openAddRegCode();
    });
    $(document).off('click', '.unbind').on('click', '.unbind', function (data) {
        var id = $(this).parent().find("span").html();
        unbindCode(id);
    });
    $(document).off('click', '.del').on('click', '.del', function (data) {
        var id = $(this).parent().find("span").html();
        openDeleteCode(id);
    });
    $(document).off('click', '.renewal').on('click', '.renewal', function (data) {
        var id = $(this).parent().find("span").html();
        $("#hiddenId").val(id);
        openRenewalCode();

    });


    var openAddRegCode = function () {
        layer.open({
            title: ['生成注册码', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            //, area: ['700px','250px']//宽度
            , area: '710px'
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=lm/addRegNo'
            , success: function (layero, index) {
                //layer高度自适应
                layer.iframeAuto(index);
            }
            , end: function () {
                var resultHidden = $("#resultHidden").val();
                if (resultHidden == "success") {
                    table.reload("layuiTable");
                    $("#resultHidden").val("");
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                } else if (resultHidden == 2) {
                    layer.msg('添加失败',
                        {icon: 2, time: 500}
                    )
                }
            }
        })
    }

    var openRenewalCode = function () {

        layer.open({
            title: ['续费', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            //, area: ['700px','250px']//宽度
            , area: '350px'
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=lm/renewal'
            , success: function (layero, index) {
                //layer高度自适应
                layer.iframeAuto(index);
            }
            , end: function () {
                debugger;
                var resultHidden = $("#resultHidden").val();
                if (resultHidden == "success") {
                    table.reload("layuiTable");
                    $("#resultHidden").val("");

                    $("#hiddenId").val("");
                    layer.msg('续费成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                } else if (resultHidden == 2) {
                    layer.msg('续费失败',
                        {icon: 2, time: 500}
                    )
                }
            }
        })
    }

    var openDeleteCode = function (id) {
        layer.confirm('确定删除勾选数据吗？', {icon: 3, title: '提示'}, function (index) {

            $.ajax({
                type: "POST",
                url: "lmRegistrationCode/del",
                traditional: true,
                data: {
                    "id": id
                },
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
    var freezeCode = function (id,str) {
        layer.confirm('确定'+str+'吗？', {icon: 3, title: '提示'}, function (index) {

            $.ajax({
                type: "POST",
                url: "lmRegistrationCode/freeze",
                traditional: true,
                data: {
                    "id": id
                },
                success: function (data) {
                    table.reload("layuiTable");
                    layer.msg(str+'成功！', {
                        icon: 1,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    });
                },
                error: function () {
                    console.log(str+"失败！");
                }
            });
        });
    }

    var unbindCode = function (id) {
        layer.confirm('确定解绑吗？', {icon: 3, title: '提示'}, function (index) {

            $.ajax({
                type: "POST",
                url: "lmRegistrationCode/unbind",
                traditional: true,
                data: {
                    "id": id
                },
                success: function (data) {
                    table.reload("layuiTable");
                    layer.msg('解绑成功！', {
                        icon: 1,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    });
                },
                error: function () {
                    console.log("失败！");
                }
            });
        });
    }


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        table.reload('layuiTable', {
            where: {"proType": data.field.proType,"cardType": data.field.cardType, "beginStr": data.field.beginDate, "endStr": data.field.endDate, "status": data.field.status,"keyword":data.field.remark}
        });
    });

    // //监听按钮点击
    // $(document).off('click', '.export').on('click', '.export', function (data) {
    //     //layer.msg($(this).prev().attr("data"));
    //     $.ajax({
    //         type: "GET",
    //         url: "/exportCompanyInfo?uploadDetailId=" + $(this).prev().attr("data"),
    //         async: false,
    //         dataType: "json",
    //         success: function (data) {
    //
    //         },
    //         error: function () {
    //             console.log("调用页面载入方法失败！");
    //         }
    //     });
    // });


})
