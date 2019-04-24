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


<#--<div style="margin: 15px;" hidden="hidden">-->
        <#--<div class="layui-form-item">-->
                  <#--<div class="layui-upload-drag" id="uploadDemo">-->
                        <#--<i class="layui-icon"></i>-->
                        <#--<p>点击上传，或将文件拖拽到此处</p>-->
                      <#--</div>-->
           <#--</div><a class="layui-btn" style="display: none"  id="exportCompanyInfo">导出EXCEL</a>-->
<#--</div>-->
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-container">
        <button type="button" class="layui-btn layui-btn-sm" id="uploadDemo">
            <i class="layui-icon">&#xe67c;</i>批量查询
        </button>

    </div>
</script>