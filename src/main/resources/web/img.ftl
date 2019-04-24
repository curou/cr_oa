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
<body style="transform: scale(.8)">

<img style="position: absolute;top: 0px;left: 0px;" src="" id="imgId">
<div style="position: absolute;border:1px solid red;top:${info.y}px;left: ${info.x}px;width: ${info.width-1}px;height:${info.height-1}px;border-radius: 8px;">
</div>

<script src="/layui/layui.js" charset="utf-8"></script>

<script>
    layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
        var  $ = layui.jquery;
        var taskId = parent.layui.$("#reimburse-taskId").val();
        $("#imgId").attr("src","getImg?taskId="+taskId)
    })
</script>

</body>
</html>