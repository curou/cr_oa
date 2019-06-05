<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>编辑菜单</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
</head>
<body>
<div style="margin-right: 20px;margin-top: 10px">
    <form class="layui-form" action="javascript:;" id="editUserForm">
        <div class="layui-form-item">
            <label class="layui-form-label">菜单</label>
            <div class="layui-input-block">
                <input type="text" name="title" id="title" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">路径</label>
            <div class="layui-input-block">
                <input type="text" name="path" id="path" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">访问权限</label>
            <div class="layui-input-block">
                <select name="permissionId" lay-filter="permissionId" id="permissionId">
                </select>
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
        var title = obj.title;
        $("#title").val(title);
        var permissionName = obj.permissionName;
        $("#menuId").val(obj.id);
        var path = obj.path;
        $("#path").val(path);

        //遍历权限列表
        $.ajax({
            type: "POST",
            url: "/getAllPerms",
            traditional: true,
            dataType: "json",
            async:false,
            contentType: "application/json",
            success: function (list) {
                var str = '<option value=""></option>';
                for (var i = 0; i < list.length; i++) {
                    if(list[i].name==permissionName){
                        str += '<option value="' + list[i].id + '" selected>' + list[i].name + '</option>';
                    }else{
                        str += '<option value="' + list[i].id + '">' + list[i].name + '</option>';
                    }

                }
                $("#permissionId").html(str);
            },
            error: function () {
                console.log("获取权限列表失败！");
            }
        });

        form.render();



        //监听搜索按钮
        form.on('submit(demo1)', function (data) {
            var perm = $("#permissionId").find("option:selected").text();
            if(data.field.title==obj.title&&data.field.path==obj.path&&perm==permissionName){
                layer.msg("数据未改变！");
            }else{
                var json = JSON.stringify(data.field);
                var index = parent.layer.getFrameIndex(window.name);
                debugger;
                $.ajax({
                    type: "POST",
                    url: "/menu/update",
                    data:json,
                    dataType:"json",
                    contentType: "application/json",
                    success: function (map) {
                        parent.layui.$("#resultHidden").val(map.result);
                        parent.layui.$('tr[nodeId='+data.field.id+']').find('span[class=title]').html(data.field.title);
                        parent.layui.$('tr[nodeId='+data.field.id+']').find('span[class=path]').html(data.field.path);
                        parent.layui.$('tr[nodeId='+data.field.id+']').find('span[class=permissionName]').html(perm);
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