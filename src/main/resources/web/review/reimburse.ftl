<div style="margin: 10px">
        <div style="margin-top: 10px;margin-right: 20px">
            <form class="layui-form" action="javascript:;" id="selectSpecificationDetailForm">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">申请单状态</label>
                        <div class="layui-input-inline">
                            <select name="status" lay-verify="required" lay-filter="status" id="status">
                                <option value="0">在途</option>
                                <option value="2">完成</option>
                            </select>
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
        <input id="addReimburseHidden" value="" hidden="hidden">
        <input id="editReimburseHidden" value="" hidden="hidden">
        <input id="reimburse-taskId" value="" hidden="hidden">
        <input type="text" hidden="hidden" id="parentId">
    </div>
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button class="layui-btn layui-btn-sm" lay-event="addReimburse">填写报销单</button>
    </div>
</script>