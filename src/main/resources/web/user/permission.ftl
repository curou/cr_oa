<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
        <form class="layui-form" action="javascript:;" id="layuiForm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">权限名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="permName" id="permName" autocomplete="off" placeholder="请输入权限名称"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-submit="" lay-filter="demo2">立即搜索</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <hr style="margin-bottom: 20px">
    <div style="margin-left: 10px;margin-right: 10px">
        <table class="layui-hide" id="demo" lay-filter="test"></table>
    </div>
    <input id="addResult" value="" hidden="hidden">
    <input id="editResult" value="" hidden="hidden">
    <input id="editName" value="" hidden="hidden">
    <input id="editFlag" value="" hidden="hidden">
    <input id="editId" value="" hidden="hidden">
</div>