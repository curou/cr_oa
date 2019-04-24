<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加用户</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
</head>
<body>
<div style="margin-right: 20px;margin-top: 10px">
    <form class="layui-form" action="javascript:;" id="editUserForm">
        <div class="layui-form-item">
            <label class="layui-form-label">标题</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="title" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">顺序</label>
            <div class="layui-input-block">
                <input type="text" name="sort" id="sort" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <input hidden="hidden" name="id" id="menuId">

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>
</div>
<script src="/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['table', 'form', 'jquery', 'element'], function () {
        var table = layui.table
            , form = layui.form
            , $ = layui.jquery
            , element = layui.element;

        var json = parent.layui.$("#editMenuHidden").val();
        var obj = JSON.parse(json);
        $("#title").val(obj.title);
        $("#sort").val(obj.sort);
        $("#menuId").val(obj.id);



        //监听搜索按钮
        form.on('submit(demo1)', function (data) {
            if(data.field.title==obj.title&&data.field.sort==obj.sort){
                layer.msg("数据未改变！");
            }else{
                var json = JSON.stringify(data.field);
                var index = parent.layer.getFrameIndex(window.name);
                $.ajax({
                    type: "POST",
                    url: "/menu/update",
                    data:json,
                    dataType:"json",
                    contentType: "application/json",
                    success: function (data) {
                        parent.layui.$("#resultHidden").val(data.result);
                        parent.layer.close(index);
                    },
                    error: function (data) {
                        layer.msg(JSON.parse(data.responseText).message,{ icon: 1, time: 1000 });
                    }
                });
            }

        });


    });
</script>
</body>
</html>