<div style="margin-top: 15px;">
    <form class="layui-form" action="javascript:;" id="selectStockForm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">注册号</label>
                <div class="layui-input-inline">
                    <input type="tel" name="regNo" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">注册人</label>
                <div class="layui-input-inline">
                    <input type="text" name="regName"  autocomplete="off" class="layui-input">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</div>