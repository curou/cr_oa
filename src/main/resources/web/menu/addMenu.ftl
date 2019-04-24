<div style="margin-top: 30px;margin-right: 20px" id="x">
    <form class="layui-form" action="javascript:;" id="menuForm">
        <div class="layui-form-item" style="margin-bottom: 25px">
            <div class="layui-inline">
                <label class="layui-form-label"><h3>标题：</h3></label>
                <div class="layui-input-inline">
                    <input type="text" name="title" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-inline" style="display: none">
                <label class="layui-form-label"><h3>URL：</h3></label>
                <div class="layui-input-inline">
                    <input type="text" name="url"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item" style="margin-bottom: 5px">
            <div class="layui-inline">
                <label class="layui-form-label"><h3>图标：</h3></label>
                <div class="layui-input-inline" style="width:75px;">
                    <i class="layui-icon layui-icon-face-smile" style="font-size: 30px; color: #ff5722;" id="icon"></i>
                </div>
            </div>
            <div class="layui-inline">
                <input type="text" style="display: none" class="layui-input" value="layui-icon layui-icon-face-smile" id="iconInput" name="icon">
            </div>
        </div>
        <div class="layui-form-item">
            <p style="color: #999;margin-left: 110px;margin-bottom: 30px">点击表情选择图标</p>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="button" class="layui-btn layui-btn-primary" id="goBack">返回主菜单管理</button>
            </div>
        </div>
    </form>
    <input hidden="hidden" id="iconHidden">
</div>