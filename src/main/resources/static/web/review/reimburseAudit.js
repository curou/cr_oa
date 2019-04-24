layui.use(['table', 'form', 'jquery', 'element', 'layer', 'laydate'], function () {
    var table = layui.table
        , layer = layui.layer
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element;
    //$("#mainbody").html($("#reimburseAuditHtml").html());
    var tableRender = function () {
        //执行一个 table 实例
        table.render({
            elem: '#demo'
            , id: "reimburseList"
            , url: 'getReimburseByAssignee' //数据接口
            , title: '待审批明细表'
            , page: true //开启分页
            , limit: 10
            , limits: [10, 20, 30]
            , cols: [[ //表头
                {type: 'numbers', title: '序号', width: 80}
                , {field: 'userName', align: 'center', title: '提交人', width: 200}
                , {field: 'content', align: 'center', title: '内容', width: 200}
                , {field: 'amount', align: 'center', title: '金额', width: 130}
                , {fixed: 'right', align: 'center', title: '操作', toolbar: '#barDemo', width: 150}
            ]]
        });
    }

    //初始化表格
    tableRender();


    var overruledReimburse = function (json) {
        layer.open({
            title: ['驳回原因', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: '400px'//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=review/overruled'
            , success: function (layero, index) {
                //layer高度自适应
                layer.iframeAuto(index);
                $("#parentId").val(json.id);
                $("#parentUserId").val(json.userId);
                $("#parentTaskId").val(json.taskId);
            }
            , end: function () {
                var overruledHidden = $("#overruledHidden").val();
                if (overruledHidden == "success") {

                    $("#overruledHidden").val("");
                    tableRender();
                    layer.msg('已驳回', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                }
            }
        })


    };

    var completeReimburse = function (json) {
        $.ajax({
            type: "POST",
            url: "/completeReimburse",
            traditional: true,
            data: JSON.stringify(json),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                table.reload("reimburseList");
                layer.msg('已通过！', {
                    icon: 1,
                    time: 1000 //2秒关闭（如果不配置，默认是3秒）
                });
            },
            error: function () {
                console.log("调用删除方法失败！");
            }
        });
    };


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var keyword = $("#userName").val();
        table.reload('reimburseList', {
            where: {"keyword": keyword}
        });
    });


    //监听行工具事件
    table.on('tool(test)', function (obj) {
        var data = obj.data;
        console.log(data);
        if (obj.event === 'overruled') {
            overruledReimburse(data);


        } else if (obj.event === 'complete') {
            layer.confirm('确定通过吗？', function (index) {
                completeReimburse(data);
                layer.close(index);
            });
        }
    });


});

