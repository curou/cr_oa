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
    <form class="layui-form" action="javascript:;" id="selectStockForm">
        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-block">
                <input hidden="hidden" id="userId" name="id"/>
                <input type="text" name="account" id="account" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="name" id="userName" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">手机</label>
            <div class="layui-input-block">
                <input type="text" name="mobilePhone" id="mobilePhone" lay-verify="required|phone"
                       autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name="sex" id="sex" lay-verify="required" lay-filter="sex" id="sex">
                    <option value=""></option>
                    <option value="男">男</option>
                    <option value="女">女</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">

            <label class="layui-form-label">部门</label>
            <div class="layui-input-block">
                <select id="departmentId" name="departmentId" lay-verify="required" lay-search></select>


            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">角色</label>
            <div class="layui-input-block">
                <#--<select id="role" name="role" lay-filter="role"  lay-search=""></select>-->
                <select name="role" xm-select="role" xm-select-search xm-select-search-type="dl" id="role" xm-select-direction="down">
                </select>
            </div>
        </div>


        <#--<div class="layui-form-item"  id="tabDiv" style="margin-left: 30px;display: none">-->
            <#--<div class="layui-tab layui-tab-brief" lay-filter="demo" lay-allowclose="true" id="demo">-->
                <#--<ul class="layui-tab-title" >-->
                <#--</ul>-->
                <#--<div class="layui-tab-content">-->
                <#--</div>-->
            <#--</div>-->
        <#--</div>-->

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
            , formSelects = layui.formSelects
            , element = layui.element;

        $("#departmentId").html(parent.layui.$("#department").html());

        //遍历角色列表
        $.ajax({
            type: "POST",
            url: "/getAllRoles",
            traditional: true,
            dataType: "json",
            async:false,
            contentType: "application/json",
            success: function (list) {
                var str = '';
                for (var i = 0; i < list.length; i++) {
                    str += '<option value="' + list[i].id + '">' + list[i].name + '</option>';
                }
                $("#role").html(str);
            },
            error: function () {
                console.log("获取角色列表失败！");
            }
        });
        formSelects.render('role');
        form.render();

        // //下拉框选中事件
        // form.on('select(role)', function(data){
        //     var id = data.value; //得到被选中的值
        //     if(id!=null&&id!=""){
        //
        //         var str = $("#role").next().find("input").val();
        //         if(equal("#demo",id)){
        //             layer.msg("已经存在该角色！")
        //         }else{
        //             $("#tabDiv").css("display", "");
        //             element.tabAdd('demo', {
        //                 title: str //显示的文本
        //                 ,id: id
        //             })
        //         }
        //     }
        //
        //
        // });
        //
        // //tab选项卡关闭完之后隐藏整个tab的div
        // $(".layui-tab").on("click",function(e){
        //     if($(e.target).is(".layui-tab-close")){
        //         if($(".layui-tab-title").find("li").length==0){
        //             $("#tabDiv").css("display", "none");
        //         }
        //     }
        // })
        //
        // //遍历现在tab对比是否存在同样的值
        // var equal = function(tabId,id){
        //     var x = false;
        //     $(tabId).find("li").each(function(){
        //         var str = $(this).attr("lay-id");
        //         if(str==id){
        //             x = true;
        //             return false;
        //         }
        //     })
        //     return x;
        // }

        //监听搜索按钮
        form.on('submit(demo1)', function (data) {
            var arr = formSelects.value('role', 'val');       //取值val数组
            if (arr.length == 0) {
                layer.msg("请选择权限！")
            } else {
                var index = parent.layer.getFrameIndex(window.name);
                var obj = new Array();
                for (var i = 0; i < arr.length; i++) {
                    obj.push(arr[i]);
                }
                data.field.roles=obj;
                var json = JSON.stringify(data.field);
                $.ajax({
                    type: "POST",
                    url: "/user/add",
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