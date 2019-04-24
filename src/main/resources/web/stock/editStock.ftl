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


<div style="margin-top: 10px;margin-right: 40px">
    <form class="layui-form" action="javascript:;">
        <div class="layui-form-item">
            <label class="layui-form-label">仓库名</label>
            <div class="layui-input-block">
                <input type="text" name="stockName" lay-verify="required" autocomplete="off" placeholder="请输入仓库名"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">启用/禁用</label>
            <div class="layui-input-block">
                <input type="checkbox" checked="" name="stockStatus" lay-skin="switch" lay-filter="switchTest"
                       lay-text="ON|OFF">
            </div>
        </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            </div>
        </div>
    </form>
</div>


<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['form', 'layedit', 'laydate'], function () {
        var form = layui.form
            , layer = layui.layer
            , layedit = layui.layedit
            , laydate = layui.laydate
            , $ = layui.$;

        //监听提交
        form.on('submit(demo1)', function (data) {
            var status = data.field.stockStatus;
            var index = parent.layer.getFrameIndex(window.name);
            if (status == "on") {
                data.field.stockStatus = 0;
            } else {
                data.field.stockStatus = 1;
            }
            var json = JSON.stringify(data.field);
            $.ajax({
                type: "POST",
                url: "/addStock",
                data: json,
                dataType: "json",
                contentType: "application/json",
                success: function (msg) {
                    parent.layui.$("#addStockHidden").val(1);
                    parent.layer.close(index);
                },
                error: function (msg) {
                    parent.layui.$("#addStockHidden").val(2);
                    parent.layer.close(index);
                }
            });
        });

    });
</script>

</body>
</html>