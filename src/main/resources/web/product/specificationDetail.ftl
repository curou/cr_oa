<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
        <form class="layui-form" action="javascript:;" id="layuiForm">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">所属类型</label>
                    <div class="layui-input-inline">
                        <select name="specId" id="specId"  lay-filter="specId" id="specId">
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">规格值名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="value" id="value" autocomplete="off" placeholder="请输入规格值"
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
    <input id="addSpecificationDetailHidden" value="" hidden="hidden">
</div>
<#--<div id="hiddenDiv" hidden="hidden">-->
    <#--<input type="radio" name="specId" value="3" title="型号">-->
    <#--<input type="radio" name="specId" value="2" title="尺码">-->
    <#--<input type="radio" name="specId" value="1" title="颜色">-->
<#--</div>-->