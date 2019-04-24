<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
        <form class="layui-form" action="javascript:;" id="stockInForm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">入库单号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="orderId" id="orderId" autocomplete="off" placeholder="请输入入库单号"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">仓库</label>
                    <div class="layui-input-inline">
                        <select name="stockId" id="stockId" lay-search="">
                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">起始时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="beginDate" id="date1" lay-verify="datetime" placeholder="起始时间"
                               autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">截至时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="endDate" id="date2" lay-verify="datetime" placeholder="结束时间"
                               autocomplete="off" class="layui-input">
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
    <div style="margin-left: 10px;margin-right: 10px" >
        <table class="layui-hide" id="demo" lay-filter="test" class="mytable-class"></table>
    </div>
    <input id="addStockInHidden" value="" hidden="hidden">
</div>


