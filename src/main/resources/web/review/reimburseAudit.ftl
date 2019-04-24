<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
        <form class="layui-form" action="javascript:;" id="selectSpecificationDetailForm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">提交人姓名</label>
                    <div class="layui-input-inline">
                        <input type="text" name="userName" id="userName" lay-verify="required" placeholder="请输入" autocomplete="off" class="layui-input">
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
</div>

<input type="text" hidden="hidden" id="overruledHidden">
<input type="text" hidden="hidden" id="parentId">
<input type="text" hidden="hidden" id="parentUserId">
<input type="text" hidden="hidden" id="parentTaskId">

<script type="text/html" id="barDemo">

    <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="overruled">驳回</a>
    <a class="layui-btn  layui-btn-sm" lay-event="complete">通过</a>
</script>