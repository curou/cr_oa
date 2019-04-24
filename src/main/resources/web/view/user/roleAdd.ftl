<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加用户</title>
    <link rel="stylesheet" href="/layui/css/layui.css"/>
    <#--<link rel="stylesheet" href="/css/longinStyle.css">-->
</head>
<body>


<div class="layui-row" style="width:500px">
    <#--<header class="layui-elip" style="width: 82%">注册页</header>-->

    <div class="layui-col-md11" style="padding-left: 20%;padding-top: 10px;">
        <!-- 表单选项 -->
        <form class="layui-form">
            <div class="layui-form-item" hidden="hidden">
                <!-- id -->
                <label class="layui-form-label">id</label>
                <div class="layui-input-inline">
                    <input type="text"  id="roleId" name="roleId" autocomplete="off" class="layui-input" <#if info?has_content>value="${info.roleId}"</#if>>
                </div>
            </div>
            <div class="layui-form-item">
                <!-- 角色名-->
                <label class="layui-form-label">角色名</label>
                <div class="layui-input-inline">
                    <input type="text" id="roleName" name="roleName" required  lay-verify="required" placeholder="请输入角色名" autocomplete="off" class="layui-input" <#if info?has_content>value="${info.roleName}"</#if>>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 权限范围 -->
                <label class="layui-form-label">权限范围</label>
                <div class="layui-input-inline" id="permission-div">
                    <#if permission?has_content>
                        <#list permission as per>
                            <input type="checkbox" lay-skin="primary" name="permission" value="${per.permissionId}" hidden="hidden" title="${per.permissionName}">
                            <div class="layui-unselect layui-form-checkbox" lay-skin="primary">
                                <i class="layui-icon layui-icon-ok"></i>
                                <span>${per.permissionName}</span>
                             </div>
                            <#--<input value="${per.permissionId}">-->
                        </#list>
                        <#else>
                        <span>暂未添加权限</span>
                    </#if>
                    <#if permisIds?has_content>
                        <input id="permisIds-input" class="permisIds-class" value="${permisIds}" hidden="hidden">
                    </#if>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 角色名-->
                <label class="layui-form-label">角色code</label>
                <div class="layui-input-inline">
                    <input type="text" id="roleKey" name="roleKey" required  lay-verify="required" placeholder="请输入角色code" autocomplete="off" class="layui-input" <#if info?has_content&&info.roleKey??>value="${info.roleKey}"</#if>>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 用户名 -->
                <label class="layui-form-label">具体描述</label>
                <textarea type="text" id="roleDecription" name="roleDecription" lay-verify="required" autocomplete="off" class="layui-textarea" style="width:290px"><#if info?has_content>${info.roleDecription}</#if></textarea>
            </div>



            <div class="layui-input-inline login-btn" style="width: 85%;padding-left: 27%;">
                <button type="submit" lay-submit lay-filter="add" class="layui-btn">确定</button>
                <a id="user-cancelBtn" class="layui-btn">取消</a>
            </div>
            <hr style="width: 85%" />
        </form>
    </div>
</div>


<script src="/layui/layui.js"></script>
<script type="text/javascript">

    layui.use(['form','jquery'], function(){
        var form = layui.form;
        var $ = layui.jquery;
        form.render();
        var permisIds = $("#permisIds-input").val();
        if (permisIds!=undefined){
            var array = permisIds.split(",");
            debugger;
            $("#permission-div").find("div").each(function () {
                var permisId =  $(this).prev("input").val()
                for (let i = 0; i < array.length; i++) {
                    debugger;
                    if (array[i]==permisId) {
                        $(this).addClass("layui-form-checked");
                    }
                }
            })
        }
        form.on('submit(add)',function (data) {
            var arr = new Array();
            $("#permission-div").find("div").each(function () {
                var clazz =  $(this).attr("class");
                if (clazz=="layui-unselect layui-form-checkbox layui-form-checked") {
                    arr.push($(this).prev("input").val())
                }
            })
            var roleId = $("#roleId").val();
            var roleName = $("#roleName").val();
            var roleDecription = $("#roleDecription").val();
            var roleKey = $("#roleKey").val();
            $.ajax({
                url:'/sys/role/add',
                type:'post',
                // dataType: "json",
                // contentType: "application/json"
                data: {
                    roleId : roleId,
                    roleName : roleName,
                    roleKey : roleKey,
                    roleDecription : roleDecription,
                    rolePermission : arr.toString()
                },
                // dataType:'text',
                success:function (data) {
                    if (data == 'success'){
                        location.href = "/";
                        //得到弹出层的index关闭
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);

                    }else{
                        layer.msg('新增失败');
                    }
                },
                error: function (data) {
                    layer.msg(JSON.parse(data.responseText).message,{ icon: 1, time: 1000 });
                }
            })
            return false;
        });
        $(document).on('click','#user-cancelBtn',function(){
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });


    });
</script>
</body>
</html>