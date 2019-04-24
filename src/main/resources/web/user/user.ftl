<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
    <form class="layui-form" action="javascript:;" id="selectStockForm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">姓名</label>
                <div class="layui-input-inline">
                    <input type="text" name="userName" id="userName" autocomplete="off" placeholder="请输入姓名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">性别</label>
                <div class="layui-input-inline">
                    <select name="userSex" lay-search="">
                        <option value=""></option>
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">手机</label>
                <div class="layui-input-inline">
                    <input type="text" name="userMobilePhone" id="phone" lay-verify="datetime" placeholder="请输入手机"
                           autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">部门</label>
                <div class="layui-input-inline">
                    <select id="department" name="department" lay-verify="" lay-search></select>
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2" id="user-search">立即搜索</button>
                </div>
            </div>
        </div>

    </form>
</div>
<hr style="margin-bottom: 20px">
<div style="margin-left: 10px;margin-right: 10px">
    <table class="layui-hide" id="test" lay-filter="test">
        <input hidden="hidden" id="resultHidden">
        <input id="editUserHidden" value="" hidden="hidden">
        <#--<input id="editUserIdHidden" value="" hidden="hidden">-->
        <#--<input id="editUserRoleHidden" value="" hidden="hidden">-->
        <#--<input id="editUserRoleIdHidden" value="" hidden="hidden">-->
        <#--<input id="editUserSexHidden" value="" hidden="hidden">-->
        <#--<input id="editUserAccountHidden" value="" hidden="hidden">-->
        <#--<input id="editUserMobilePhoneHidden" value="" hidden="hidden">-->
        <#--<input id="editUserDepartmentIdHidden" value="" hidden="hidden">-->
        <#--<input id="editUserDepartmentHidden" value="" hidden="hidden">-->

    </table>
</div>
</div>