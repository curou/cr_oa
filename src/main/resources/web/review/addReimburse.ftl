<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
<div style="margin-right: 20px;margin-top: 10px">
<form class="layui-form" action="javascript:;" id="addForm">
    <div class="layui-form-item">
            <label class="layui-form-label">金额</label>
            <div class="layui-input-inline">
                <input type="text" name="amount" id="amount" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
    </div>
    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">事项</label>
        <div class="layui-input-block">
            <textarea placeholder="请输入内容" name="content" lay-verify="required" class="layui-textarea"></textarea>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>
</div>
<input hidden="hidden" id="reimburseHidden" type="text"/>
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['element','form','layer'], function(){
        var $ = layui.jquery
            ,layer = layui.layer
            ,form = layui.form
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块


        //监听提交
        form.on('submit(demo1)', function (data) {
            var json = JSON.stringify(data.field);
            var index = parent.layer.getFrameIndex(window.name);
            //layer.msg(json);
            $.ajax({
                type: "POST",
                url: "/addReimburse",
                data: json,
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    parent.layui.$("#addReimburseHidden").val(data.result);
                    parent.layer.close(index);
                },
                error: function (data) {
                    parent.layui.$("#addReimburseHidden").val(2);
                    parent.layer.close(index);
                }
            });
        });



    });
</script>

</body>
</html>