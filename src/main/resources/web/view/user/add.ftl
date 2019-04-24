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

    <div class="layui-col-md11" style="padding-left: 20%;padding-top: 10px;">
        <!-- 表单选项 -->
        <form class="layui-form">
            <div class="layui-form-item" hidden="hidden">
                <!-- id -->
                <label class="layui-form-label">id</label>
                <div class="layui-input-inline">
                    <input type="text"  name="userId" autocomplete="off" class="layui-input" <#if info?has_content>value="${info.userId}"</#if>>
                </div>
            </div>
            <div class="layui-form-item">
                <!-- 用户名 -->
                <label class="layui-form-label">用户名</label>
                <div class="layui-input-inline">
                    <input type="text" id="user" name="userAccount" required  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input" <#if info?has_content>value="${info.userAccount}"</#if>>
                </div>
                <!-- 对号 -->
                <div class="layui-inline">
                    <i class="layui-icon" id="ri" style="color: green;font-weight: bolder;" hidden></i>
                </div>
                <!-- 错号 -->
                <div class="layui-inline">
                    <i class="layui-icon" id="wr" style="color: red; font-weight: bolder;" hidden>ဆ</i>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 密码 -->
                <label class="layui-form-label">密码</label>
                <div class="layui-input-inline">
                    <input type="text" id="password" name="userPassword" autocomplete="off" class="layui-input" <#if info?has_content>placeholder="输入新密码,不填则不修改"<#else>placeholder="未填默认密码为123456"</#if>>
                </div>
            </div>

            <div class="layui-form-item">
                <!-- 用户名 -->
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" id="username" name="userName" required  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input" <#if info?has_content><#if info.userName?has_content>value="${info.userName}"</#if></#if>>
                </div>
            </div>

            <#if !isUser?has_content>
                <div class="layui-form-item">
                    <!-- 角色-->
                    <label class="layui-form-label">角色</label>
                    <div class="layui-input-inline">
                        <select name="userRole">
                            <option value="">请选择角色</option>
                            <#if roles?has_content>
                                <#list roles as role>
                                    <option value="${role.roleId}" <#if info?has_content><#if info.userRole?has_content&&info.userRole==role.roleId>selected="selected"</#if></#if>>${role.roleName}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                </div>
            </#if>

            <div class="layui-form-item">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <select name="userSex">
                        <option value="">请选择性别</option>
                        <option value="男" <#if info?has_content><#if info.userSex?has_content&&info.userSex=="男">selected="selected"</#if></#if>>男</option>
                        <option value="女" <#if info?has_content><#if info.userSex?has_content&&info.userSex=="女">selected="selected"</#if></#if>>女</option>
                    </select>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">手机</label>
                <div class="layui-input-inline">
                    <input type="text" name="userMobilePhone" required lay-verify="phone" placeholder="请输入" autocomplete="off" class="layui-input" <#if info?has_content>value="${info.userMobilePhone}"</#if>>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">所属部门</label>
                    <div class="layui-input-block">
                        <select name="userApartment">

                        </select>
                    </div>
                </div>
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
                url:'/sys/user/add',
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