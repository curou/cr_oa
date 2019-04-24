<div style="margin: 10px">
    <div style="margin-top: 10px;margin-right: 20px">
        <form class="layui-form" action="javascript:;" id="layuiForm">
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
                    <label class="layui-form-label">注册码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="orderId" id="orderId" autocomplete="off" placeholder="请输入入库单号"
                               class="layui-input">
                    </div>
                </div>

            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">注册码</label>
                    <div class="layui-input-inline">
                        <input type="text" name="code" id="code" autocomplete="off" placeholder="请输入入库单号"
                               class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">使用状态</label>
                    <div class="layui-input-inline">
                        <select name="status" id="status" lay-search="">
                            <option value=""></option>
                            <option value="0">未使用</option>
                            <option value="1">使用中</option>
                            <option value="2">已过期</option>
                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">卡类型</label>
                    <div class="layui-input-inline">
                        <select name="cardType" id="cardType" lay-search="">
                        </select>
                    </div>
                </div>
            </div>
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <label class="layui-form-label">项目类型</label>
                        <div class="layui-input-inline">
                            <select name="proType" id="proType" lay-search="">
                            </select>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <label class="layui-form-label">在线状态</label>
                        <div class="layui-input-inline">
                            <select name="onlineStatus" id="onlineStatus" lay-search="">
                                <option value=""></option>
                                <option value="1">在线</option>
                                <option value="0">离线</option>
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
</div>



