<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加用户</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <link href="/formSelects/formSelects-v4.css" rel="stylesheet" />
    <script src="/js/jquery.min.js"></script>
    <script src="/formSelects/formSelects-v4.js"></script>
</head>
<body>
<div style="margin-right: 20px;margin-top: 10px">
    <form class="layui-form" action="javascript:;" id="editUserForm">
        <div class="layui-form-item">
            <label class="layui-form-label">角色名</label>
            <div class="layui-input-block">
                <input type="text" name="name" id="roleName" lay-verify="required" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">权限</label>
            <div class="layui-input-block">
                <#--<select id="perm" name="perm" id="perm" lay-filter="perm"  lay-search></select>-->
                <select name="perm" xm-select="perm" xm-select-search xm-select-search-type="dl" id="perm" >
                </select>
            </div>
        </div>
        <input hidden="hidden" name="id" id="roleId">

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
    layui.config({
        base: '/formSelects/' //此处路径请自行处理, 可以使用绝对路径
    }).extend({
        formSelects: 'formSelects-v4'
    });
    layui.use(['table', 'form', 'jquery', 'element', 'formSelects'], function () {
        var table = layui.table
            , form = layui.form
            , $ = layui.jquery
            ,formSelects = layui.formSelects
            , element = layui.element;

        //遍历权限列表
        $.ajax({
            type: "POST",
            url: "/getAllPerms",
            traditional: true,
            dataType: "json",
            async:false,
            contentType: "application/json",
            success: function (list) {
                var str = '';
                for (var i = 0; i < list.length; i++) {
                    str += '<option value="' + list[i].id + '">' + list[i].name + '</option>';
                }
                $("#perm").html(str);
            },
            error: function () {
                console.log("获取权限列表失败！");
            }
        });
        formSelects.render('perm');
        $("#roleName").val(parent.layui.$("#editRoleNameHidden").val());
        $("#roleId").val(parent.layui.$("#editRoleIdHidden").val());
        //id集合文本，如1，2，3
        var idStr = parent.layui.$("#editRolePermIdHidden").val();
        if(idStr!=null||idStr!=""){
            var idArr = idStr.split(",");
            formSelects.render('perm');
            formSelects.value('perm', idArr);
        }


        form.render();





        //监听搜索按钮
        form.on('submit(demo1)', function (data) {
            var arr = formSelects.value('perm', 'val');       //取值val数组

                var index = parent.layer.getFrameIndex(window.name);
                var obj = new Array();
                for (var i = 0; i < arr.length; i++) {
                    obj.push(arr[i]);
                }
                data.field.permList=obj;
                var json = JSON.stringify(data.field);
                //layer.msg(json);
                $.ajax({
                    type: "POST",
                    url: "/roleAOU",
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


        });


    });
</script>
</body>
</html>