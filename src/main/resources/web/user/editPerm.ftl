<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加权限</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
</head>
<body>
<div style="margin-right: 20px;margin-top: 10px">
    <form class="layui-form" action="javascript:;" id="addPermForm">
        <div class="layui-form-item">
            <label class="layui-form-label">权限名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" id="name" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限标志</label>
            <div class="layui-input-inline">
                <input type="text" name="flag" id="flag" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>



        <div class="layui-form-item">
            <div class="layui-input-inline">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
        <input id="editId" name = "id" hidden="hidden">
    </form>
</div>
<script src="/layui/layui.js"></script>
<script type="text/javascript">

    layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
        var table = layui.table
            , form = layui.form
            , $ = layui.jquery
            , element = layui.element;

        $("#name").val(parent.layui.$("#editName").val());
         $("#flag").val(parent.layui.$("#editFlag").val());
        $("#editId").val(parent.layui.$("#editId").val());
        //监听搜索按钮
        form.on('submit(demo1)', function (data) {
            console.log(data);
            var index = parent.layer.getFrameIndex(window.name);
            var json = JSON.stringify(data.field);
            $.ajax({
                type: "POST",
                url: "/permissionAOU",
                data: json,
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    parent.layui.$("#editResult").val(data.result);
                    parent.layer.close(index);
                },
                error: function (data) {
                    layer.msg(JSON.parse(data.responseText).message, {icon: 1, time: 1000});
                }
            });

        });


    });
</script>
</body>
</html>