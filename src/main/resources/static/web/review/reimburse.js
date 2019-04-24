layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element;
    // $("#mainbody").html($("#reimburseHtml").html());
    form.render();

    var tableRender = function () {

        //执行一个 table 实例
        var x = false;
        table.render({
            elem: '#demo'
            , id: "reimburseList"
            , url: 'getReimburse' //数据接口
            , title: '报销单明细表'
            , page: true //开启分页
            , toolbar: '#toolbarDemo'
            , limit: 10
            , limits: [10, 20, 30]
            , done: function () {
                if (!x) {

                    $("[data-field='flow']").css('display', 'none');
                }
            }
            , cols: [[ //表头
                {type: 'numbers', title: '序号', width: 80}
                , {field: 'content', align: 'center', title: '内容', width: 200}
                , {field: 'amount', align: 'center', title: '金额', width: 130}
                , {
                    field: 'status', title: '状态', align: 'center', width: 90, templet: function (res) {
                        if (res.status == 1) {
                            return '<p style="color: red">驳回</p>';
                        } else if (res.status == 0) {
                            return '审批中';
                        } else {
                            return '已通过';
                        }
                    }
                }
                , {
                    field: 'do', title: '操作', align: 'center', width: 170, templet: function (res) {
                        if (res.status == 1) {
                            return '<button  class="layui-btn layui-btn-sm layui-btn-normal notice">查看原因</button><button class="layui-btn layui-btn-sm edit">编辑</button><input type="text" hidden="hidden" value="' + res.id + '"><input type="text" hidden="hidden" value="' + res.taskId + '">';
                        } else if (res.status == 0) {
                            return '<input type="text" hidden="hidden" value="' + res.id + '"><button class="layui-btn layui-btn-sm layui-btn-danger del">撤销</button>';
                        } else {
                            return '';
                        }
                    }
                }
                , {
                    field: 'flow', align: 'center', title: '查看节点', width: 130, templet: function (res) {
                        if (res.status != 2) {
                            x = true;
                            return '<input type="text" hidden="hidden" value="' + res.taskId + '"><button class="layui-btn layui-btn-sm layui-btn-danger flow">查看流程图</button>';
                        }
                    }
                }
            ]]
        });
    }

    //初始化表格
    tableRender();


    var openUpdateReimburse = function (json) {
        layer.open({
            title: ['报销单', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: '400px'//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=review/editReimburse'
            , success: function (layero, index) {
                //layer高度自适应
                layer.iframeAuto(index);
            }
            , end: function () {
                if ($("#editReimburseHidden").val() == "success") {
                    tableRender();
                    layer.msg('提交成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }


            }
        })
    }

    //填写报销单
    var openAddReimburse = function () {
        layer.open({
            title: ['报销单', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: '400px'//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=review/addReimburse'
            , success: function (layero, index) {
                //layer高度自适应
                layer.iframeAuto(index);
            }
            , end: function () {
                var addReimburseHidden = $("#addReimburseHidden").val();

                if (addReimburseHidden == "success") {

                    $("#addReimburseHidden").val("");
                    tableRender();
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                } else if (addReimburseHidden == 2) {
                    layer.msg('添加失败',
                        {icon: 2, time: 500}
                    )
                } else if (addReimburseHidden == "repeatName") {
                    layer.msg('仓库名重复',
                        {icon: 2, time: 800}
                    )
                }
            }
        })
    }

    //撤销报销单
    var openDeleteReimburse = function (id) {
        layer.confirm('确定撤销吗？', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                type: "POST",
                url: "/deleteProcessInstance",
                traditional: true,
                data: {"reimburseId": id},
                dataType: "text",
                success: function (data) {
                    table.reload("reimburseList");
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


    //监听头工具栏事件
    //填写申请单
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'addReimburse':
                openAddReimburse();
                break;
        }
        ;
    });


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var status = $("#status").val();
        table.reload('reimburseList', {
            where: {"status": status}
        });
    });

    //监听按钮点击事件查看流程图
    $(document).off('click', '.flow').on('click', '.flow', function (data) {
        var val = $(this).prev().val();
        $("#reimburse-taskId").val(val);
        layer.open({
            title: ['流程图', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: ['850px', '450px']
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'viewCurrentImage?taskId=' + val
        })
    });

    //监听按钮点击事件撤销申请单
    $(document).off('click', '.del').on('click', '.del', function (data) {
        openDeleteReimburse($(this).prev().val());
    });

    //监听按钮点击事件编辑申请单
    $(document).off('click', '.edit').on('click', '.edit', function (data) {
        //layer.msg($(this).next().val());
        $("#parentId").val($(this).next().val());
        openUpdateReimburse();
    });

    //查看原因
    $(document).off('click', '.notice').on('click', '.notice', function (data) {
        var html = "";
        var taskId = $(this).next().next().next().val();
        $.ajax({
            type: "POST",
            url: "/getComment",
            traditional: true,
            data: {"taskId": taskId},
            async: false,
            dataType: "text",
            success: function (list) {
                var obj = JSON.parse(list);
                var comment = "";
                debugger;
                for (var i = 0; i < obj.length; i++) {
                    comment += '审批人：' + obj[i].userId + '<br>审批信息：' + obj[i].fullMessage + '<br>审批时间：' + obj[i].time + '<br><hr>';
                }
                html = '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' + comment + '</div>'
            },
            error: function () {
                console.log("查看审批信息方法失败！");
            }
        });

        layer.open({
            type: 1
            , title: false //不显示标题栏
            , closeBtn: false
            , area: '300px;'
            , shade: 0.8
            , id: 'LAY_layuipro' //设定一个id，防止重复弹出
            , btn: ['知道了']
            , btnAlign: 'c'
            , moveType: 1 //拖拽模式，0或者1
            , content: html
        });

    });
})


