<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加角色</title>
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
                    <input type="text"  name="permissionId" autocomplete="off" class="layui-input" <#if info?has_content>value="${info.permissionId}"</#if>>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 权限范围 -->
                <label class="layui-form-label">权限名</label>
                <div class="layui-input-inline">
                    <input type="text" id="permisssion" name="permissionName"  required  lay-verify="required" placeholder="请输入权限名" autocomplete="off" class="layui-input" <#if info?has_content>value="${info.permissionName}"</#if>>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 权限范围 -->
                <label class="layui-form-label">权限code</label>
                <div class="layui-input-inline">
                    <input type="text" id="permissionKey" name="permissionKey"  required  lay-verify="required" placeholder="请输入权限code" autocomplete="off" class="layui-input" <#if info?has_content&&info.permissionKey??>value="${info.permissionKey}"</#if>>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 用户名 -->
                <label class="layui-form-label">权限描述</label>
                <textarea type="text" name="permissionDecription" required  lay-verify="required" placeholder="请输入权限描述" autocomplete="off" class="layui-textarea" style="width:290px"><#if info?has_content>${info.permissionDecription}</#if></textarea>
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

    layui.use('form', function(){
        var form = layui.form;
        var $ = layui.jquery;
        form.render();

        form.on('submit(add)',function (data) {
            // console.log(data.field);
            $.ajax({
                url:'/sys/permission/add',
                data:data.field,
                // dataType:'text',
                type:'post',
                success:function (data) {
                    console.log(data);
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