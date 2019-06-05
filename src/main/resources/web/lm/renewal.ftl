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
    <form class="layui-form" action="javascript:;">
        <div class="layui-form-item">
                <label class="layui-form-label">卡类型</label>
                <div class="layui-input-block">
                    <select name="cardType" id="cardType" lay-search="" lay-verify="required">
                    </select>
                </div>
        </div>
        <div class="layui-form-item">
                <label class="layui-form-label">数量</label>
                <div class="layui-input-block">
                    <input type="text" name="count"  autocomplete="off" class="layui-input" lay-verify="required">
                </div>
        </div>
        <input type="text" name="id"  hidden="hidden" id="hiddenId" lay-verify="required">
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

    </form>
</div>
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['element','form','layer'], function(){
        var $ = layui.jquery
            ,layer = layui.layer
            ,form = layui.form
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块

        $("#cardType").html(parent.layui.$("#cardType").html());
        $("#hiddenId").val(parent.layui.$("#hiddenId").val());
        form.render();

        var index = parent.layer.getFrameIndex(window.name);
        debugger;
        //监听提交
        form.on('submit(demo1)', function (data) {
            var json = JSON.stringify(data.field);
            $.ajax({
                type: "POST",
                url: "lmRegistrationCode/renewal",
                data: json,
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    debugger;
                    parent.layui.$("#resultHidden").val(data.result);
                    parent.layer.close(index);
                },
                error: function (data) {
                    parent.layui.$("#resultHidden").val(2);
                    parent.layer.close(index);
                }
            });
        });



    });
</script>

</body>
</html>