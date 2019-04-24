<script type="text/html" id="stockOutHtml">
<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
        <form class="layui-form" action="javascript:;" id="selectStockForm">
            <div class="layui-form">
                <div class="layui-form-item">
                    <label class="layui-form-label">出库单号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="orderId" id="out-orderId" autocomplete="off" placeholder="请输入出库单号"
                               class="layui-input">
                    </div>
                    <label class="layui-form-label">仓库</label>
                    <div class="layui-inline">
                        <select name="outStockId" id="out-stockId">
                            <option value="">请选择仓库</option>
                            <#if stocks?has_content>
                                <#list stocks as stock>
                                    <option value="${stock.stockId}">${stock.stockName}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-block">
                            <button class="layui-btn" lay-submit="" lay-filter="stockOut-search">立即搜索</button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
    <hr style="margin-bottom: 20px">
    <div style="margin-left: 10px;margin-right: 10px">
        <table class="layui-hide" id="demo" lay-filter="test"></table>
    </div>
    <input id="addStockInHidden" value="" hidden="hidden">
</div>
</script>
<#--<script type="text/html" id="toolbarDemo">-->
    <#--<div class="layui-btn-container">-->
        <#--<button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>-->
        <#--<button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>-->
        <#--<button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>-->
    <#--</div>-->
<#--</script>-->