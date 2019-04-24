<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
        <form class="layui-form addStockInForm" action="">

            <div class="layui-form-item">
                <label class="layui-form-label">产品名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="productId" id="addStockIn-productName" autocomplete="off"
                           class="layui-input" disabled>
                </div>
                <div class="layui-form-mid layui-word-aux" style="padding:0px">
                    <button type="button" class="layui-btn layui-btn-normal site-demo-active"
                            data-type="openChooseProduct">
                        <i class="layui-icon">&#xe608;</i> 选择
                    </button>
                </div>
            </div>
            <div class="layui-form-item">

                <label class="layui-form-label">入库数量</label>
                <div class="layui-input-inline">
                    <input type="number" name="count" id="addStockIn-count" lay-verify="required" autocomplete="off" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <label class="layui-form-label">选择单位</label>
                <div class="layui-input-inline">
                    <select name="unit" id="addStockIn-unit" lay-filter="unit" lay-verify="required">
                    </select>
                </div>
            </div>


            <div class="layui-form-item">
                <label class="layui-form-label">选择规格</label>
                <div class="layui-input-inline">
                    <select name="specId" id="addStockIn-specId" lay-filter="specId">

                    </select>
                </div>
                <div class="layui-input-inline">
                    <select name="specsId" id="addStockIn-specsId" lay-filter="specsId">

                    </select>
                </div>
                <div class="layui-form-mid layui-word-aux" style="padding:0px">
                    <button type="button" class="layui-btn layui-btn-normal site-demo-active"
                            data-type="openChooseSpec">
                        <i class="layui-icon">&#xe608;</i> 添加
                    </button>
                </div>
            </div>
            <div class="layui-form-item" id="tabDiv" style="margin-left: 30px;display: none">
                <div class="layui-tab layui-tab-brief" lay-filter="addStockInTab1" lay-allowclose="true" id="addStockInTab1">
                    <ul class="layui-tab-title">
                    </ul>
                    <div class="layui-tab-content">
                    </div>
                </div>
            </div>


            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn layui-btn-normal" lay-submit=""  lay-filter="demo0">添加入库</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>

        <div style="display:none" id="addProductFormDiv">
            <hr style="margin-top: 20px;margin-bottom: 20px">

            <form class="layui-form addStockInFormTwo" action="">

                <div class="layui-form-item">
                    <label class="layui-form-label">入库仓库</label>
                    <div class="layui-input-inline">
                        <select name="stockId" id="addStockIn-stockId" lay-filter="stockId" lay-verify="required">

                        </select>
                    </div>
                </div>

                <div style="margin-left: 25px">

                    <div class="layui-form">
                        <table class="layui-table" style="text-align: center" id="addStockInTable">
                            <colgroup>
                                <col width="150">
                                <col width="100">
                                <col width="100">
                                <col width="150">
                                <col>
                            </colgroup>
                            <thead>
                            <tr>
                                <th style="text-align: center">产品名称</th>
                                <th style="text-align: center">数量</th>
                                <th style="text-align: center">单位</th>
                                <th style="text-align: center">产品规格</th>
                                <th style="text-align: center">操作</th>
                            </tr>
                            </thead>
                            <tbody class="stockInTbody">

                            </tbody>
                        </table>
                    </div>
                    <div class="layui-btn-group demoTable" style="margin-bottom: 10px;">
                        <button type="button" lay-submit="" class="layui-btn" lay-filter="demo1">立即提交</button>
                    </div>
                </div>
            </form>
        </div>
        <input hidden="hidden" id="addStockInHidden">
        <input hidden="hidden" class="addStockIn-productId-hidden">
        <input hidden="hidden" class="addStockIn-specId-hidden">
        <input hidden="hidden" class="addStockIn-specsId-hidden">