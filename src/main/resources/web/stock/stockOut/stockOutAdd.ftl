<script type="text/html" id="addStockOutHtml">
    <div style="margin: 10px">
        <div style="margin-top: 10px;margin-right: 20px">
            <form class="layui-form" action="" id="stockOutAdd-form">
                <#--<div class="layui-form-item">-->
                    <#--<div class="layui-inline">-->
                        <#--<label class="layui-form-label">出库单号</label>-->
                        <#--<div class="layui-input-inline">-->
                            <#--<input type="text" id="stockOutOrderId" placeholder="未填默认生成单号" autocomplete="off" class="layui-input">-->
                        <#--</div>-->
                    <#--</div>-->
                <#--</div>-->
                <div class="layui-form-item">
                    <label class="layui-form-label">仓库</label>
                    <div class="layui-inline">
                        <select name="outStockId" id="outStockId">
                            <option value="">请选择仓库</option>
                            <#if stocks?has_content>
                                <#list stocks as stock>
                                    <option value="${stock.stockId}">${stock.stockName}</option>
                                </#list>
                            </#if>
                        </select>
                    </div>
                </div>

                <div id="stockProTable" class="layui-form" style="display: none;" >
                    <table class="layui-table" style="width: 700px;" id="stockProTableData">
                        <colgroup>
                            <col width="100px">
                            <col width="100px">
                            <col width="100px">
                            <col width="150px">
                            <col width="150px">
                            <col width="50px">
                            <col width="50px">
                        </colgroup>
                        <thead>
                        <tr>
                            <th hidden="hidden">id</th>
                            <#--<th style="text-align: center;">id</th>-->
                            <th style="text-align: center;">产品名称</th>
                            <th style="text-align: center;">规格</th>
                            <th style="text-align: center;">产品单位</th>
                            <th style="text-align: center;">剩余库存</th>
                            <th style="text-align: center;">数量</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="stockProTbody">
                        </tbody>
                    </table>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>
            </form>
</script>
<script type="text/javascript">
    var x = "";
    layui.use(['form','table','jquery'], function(){
        var form = layui.form;
        var $ = layui.jquery;
        var table = layui.table;
        $(document).ready(function() {
            // select下拉框选中触发事件
            form.on("select", function(data){
                var outStockId = $("#outStockId").val();
                var arr = new Array();
                $("#stockProTbody").find("tr").each(function () {
                    var son = {};
                    son.id = $(this).find("td").eq(0).html();
                    son.count = $(this).find("td").eq(5).find("input").val();
                    arr.push(son);
                });

                //alert(data.value); // 获取选中的值
                if (outStockId==undefined || outStockId==""){
                    return;
                }
                layer.open({
                    type : 1,
                    area : [ "759px", '494px' ],
                    title : "选择出库产品",
                    maxmin : false,
                    content : '    <form class="layui-form" action="javascript:;" id="selectProForm" style="padding-top:10px">\n' +
                        '        <div class="layui-form-item">\n' +
                        '            <div class="layui-inline">\n' +
                        '                <label class="layui-form-label">产品名称</label>\n' +
                        '                <div class="layui-input-inline">\n' +
                        '                    <input type="text" name="keyword" id="keyword" autocomplete="off" placeholder="请输入产品名"\n' +
                        '                           class="layui-input">\n' +
                        '                </div>\n' +
                        '            </div>\n' +
                        '                <div class="layui-inline">\n' +
                        '                    <div class="layui-input-block">\n' +
                        '                        <button class="layui-btn" lay-submit="" lay-filter="demo2"><input hidden="hidden" id="stockId-input" value="'+outStockId+'">立即搜索</button>\n' +
                        '                    </div>\n' +
                        '                </div>\n' +
                        '            </div>\n' +
                        '    </form><div><table id="templateTable"></table></div>',
                    success : function(index, layero) {
                        table.render({
                            elem: '#templateTable'
                            ,height: 300
                            ,width:'100%'
                            ,url: '/stockOut/getStockPro'    // 数据接口
                            ,where:{
                                "stockId": outStockId
                            }
                            ,id: 'stockOutProTable'
                            ,limits: [10, 20, 30]
                            ,page: true //开启分页
                            ,cols: [[ //表头
                                //表头
                                {type: 'checkbox',width: 50}
                                , {field: 'proName', align: 'center', title: '产品名称', width: 130}
                                , {field: 'productSpec', align: 'center', title: '规格', width: 200}
                                , {field: 'unit', align: 'center', title: '产品单位', width: 130}
                                , {field: 'count', align: 'center', title: '产品数量', width: 130, edit: 'text'}

                            ]]
                        });

                    },

                    btn : [ '确定', '关闭' ],
                    yes : function(index, layero) {
                        var key = true;
                        var checkStatus = table.checkStatus('stockOutProTable'); //
                        var datas = checkStatus.data;//选中的数据
                        if(datas.length<1){
                            layer.msg("未选择数据");
                            return;
                        }
                        if (x=="" || x==undefined){
                            x=outStockId;
                        }else {
                            if (x!=outStockId){
                                key = false;
                                layer.confirm('确定切换仓库吗？', {icon: 3, title:'提示'}, function(index2) {
                                    x = outStockId;
                                    $("#stockProTable").attr("style","display:none;");
                                    $("#stockProTbody").html("");
                                    // $("#stockProTbody").find("tr").each(function () {
                                    //     $(this).remove();
                                    // });
                                    //
                                    var checkStatus2 = $("#stockProTableData").html(); //
                                    var stockProIds = new Array();

                                    $("#stockProTbody").find("tr").each(function () {
                                        var stockProId = $(this).find("td").eq(0).html()
                                        stockProIds.push(stockProId);
                                    });
                                    aa :for (let i=0;i<datas.length;i++){
                                        var stockProId = datas[i].id;
                                        for (let j=0;j<stockProIds.length;j++){
                                            if (stockProId==stockProIds[j]) {
                                                continue aa;
                                            }
                                        }
                                        var proName = datas[i].proName;
                                        var proSpec = datas[i].productSpec;
                                        var unit = datas[i].unit;
                                        var count = datas[i].count;
                                        var html = '<tr style="text-align: center;"><td hidden="hidden">'+stockProId+'</td><td>'+proName+'</td><td>'+proSpec+'</td><td style="text-align: center;">'+unit+'</td><td style="text-align: center;">'+count+'</td><td><input style="width: 60px;text-align: center;" class="count-class" value="0"></td><td><button type="button" class="layui-btn layui-btn-danger layui-btn-sm delProduct">移除</button></td></tr>';
                                        $("#stockProTbody").append(html);
                                    }
                                    // var html = '<tr><td>productHtml</td><td>countHtml</td><td>unitHtml</td><td>specHtml</td><td><button type="button" class="layui-btn layui-btn-danger layui-btn-sm delProduct">移除</button></td></tr>';
                                    $("#stockProTable").attr("style","display:block;");
                                    try{
                                        layer.close(index2);//关闭对话框.
                                        layer.close(index);//关闭对话框.
                                    }catch(e){
                                        setTimeout(function(){layer.close(index)}, 100);//延时0.1秒，对应360 7.1版本bug
                                    }

                                });
                            }
                        }
                        if (key) {
                            // var array = JSON.stringify(datas);
                            var checkStatus2 = $("#stockProTableData").html(); //
                            var stockProIds = new Array();

                            $("#stockProTbody").find("tr").each(function () {
                                var stockProId = $(this).find("td").eq(0).html()
                                stockProIds.push(stockProId);
                            });
                            aa :for (let i = 0; i < datas.length; i++) {
                                var stockProId = datas[i].id;
                                for (let j = 0; j < stockProIds.length; j++) {
                                    if (stockProId == stockProIds[j]) {
                                        continue aa;
                                    }
                                }
                                var proName = datas[i].proName;
                                var proSpec = datas[i].productSpec;
                                var unit = datas[i].unit;
                                var count = datas[i].count;
                                var html = '<tr style="text-align: center;"><td hidden="hidden">' + stockProId + '</td><td>' + proName + '</td><td>' + proSpec + '</td><td style="text-align: center;">' + unit + '</td><td style="text-align: center;">' + count + '</td><td><input style="width: 60px;text-align: center;" class="count-class" value="0"></td><td><button type="button" class="layui-btn layui-btn-danger layui-btn-sm delProduct">移除</button></td></tr>';
                                $("#stockProTbody").append(html);
                            }
                            // var html = '<tr><td>productHtml</td><td>countHtml</td><td>unitHtml</td><td>specHtml</td><td><button type="button" class="layui-btn layui-btn-danger layui-btn-sm delProduct">移除</button></td></tr>';
                            $("#stockProTable").attr("style", "display:block;");
                            try {
                                layer.close(index);//关闭对话框.
                            } catch (e) {
                                setTimeout(function () {
                                    layer.close(index)
                                }, 100);//延时0.1秒，对应360 7.1版本bug
                            }
                        }

                    }
                });
            });

        });
        //监听搜索按钮
        form.on('submit(demo2)', function (data) {
            var keyword = $("#keyword").val();
            var outStockId =$("#stockId-input").val();
                $.ajax({
                    type: "GET",
                    url: "/stockOut/getStockPro",
                    data: {
                        keyword: keyword,
                        outStockId: outStockId
                    },
                    dataType: "json",
                    contentType: "application/json",
                    traditional: true,
                    sync: false,
                    success: function (data) {
                        table.reload('stockOutProTable', {
                            where: {"keyword": keyword, "outStockId": outStockId}
                        });
                    },
                    error: function () {
                        console.log("调用搜索方法失败！");
                    }
                });
            // table.reload('templateTable', {
            //     where: {"keyword": keyword}
            // });
        });
        //监听按钮点击事件移除一行
        $(document).on('click', '.delProduct', function(data) {
            $(this).parents("tr:first").remove();

            if($("#stockProTbody").find("tr").length==0){
                $("#stockProTable").css("display", "none");
                x="";
            }
        });

        //监听input框失焦事件
        $(document).on('blur', '.count-class', function(data) {
            var myCount = $(this).parent().prev().html();
            if ($(this).val()-myCount>=0){
                $(this).val(myCount);
            }else {
                if ($(this).val()==undefined || $(this).val()==""){
                    $(this).val(0);
                }
                if ($(this).val()-0< 0) {
                    $(this).val(0);
                }
            }
        });

        //监听提交按钮
        form.on('submit(demo1)', function (data) {
            var arr = new Array();
            $("#stockProTbody").find("tr").each(function () {
                var son = {};
                son.id = $(this).find("td").eq(0).html();
                son.count = $(this).find("td").eq(5).find("input").val();
                arr.push(son);
            });
            if (arr.length==0){
                layer.msg('请选择数据', {
                    icon: 1,
                    time: 1000 //2秒关闭（如果不配置，默认是3秒）
                });
                return;
            }
            layer.confirm('确定出库吗？', {icon: 3, title:'提示'}, function(index) {
                // var arr = new Array();
                // $("#stockProTbody").find("tr").each(function () {
                //     var son = {};
                //     son.id = $(this).find("td").eq(0).html();
                //     son.count = $(this).find("td").eq(5).find("input").val();
                //     arr.push(son);
                // });
                $.ajax({
                    type: "POST",
                    url: "/stockOut/add",
                    traditional: true,
                    data: JSON.stringify(arr),
                    dataType: "json",
                    contentType: "application/json",
                    success: function (data) {
                        $("#stockOutAdd-form")[0].reset();
                        $("#stockProTbody").html("");
                        $("#stockProTable").attr("style","display:none;");
                        x="";
                        layer.msg('出库成功！', {
                            icon: 1,
                            time: 1000 //2秒关闭（如果不配置，默认是3秒）
                        });
                    },
                    error: function (data) {
                        layer.msg(JSON.parse(data.responseText).message,{ icon: 1, time: 1000 });
                    }
                });
            });
        });
    });
</script>
