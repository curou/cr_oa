var stockOut = function(){

    layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
        var table = layui.table
            , form = layui.form
            , $ = layui.jquery
            , laydate = layui.laydate
            , element = layui.element;
        $("#mainbody").html($("#stockOutHtml").html());
        form.render();
        //日期
        laydate.render({
            elem: '#date1'
            , type: 'datetime'
        });
        laydate.render({
            elem: '#date2'
            , type: 'datetime'
        });

        var tableRender = function () {
            //执行一个 table 实例

            table.render({
                elem: '#demo'
                , height: 420
                , id:"stockOutDetail"
                , url: '/stockOut/getList' //数据接口
                , title: '出库明细表'
                , page: true //开启分页
                , toolbar: '#stockIn-toolbarDemo'
                , limit: 10
                , where:{"type":"1"}
                , limits: [10, 20, 30]
                ,done: function () {
                    mergeCell();
                    $("table[class=layui-table]").addClass("mytable-class");
                }
                , cols: [[ //表头
                    {type: 'numbers'}
                    , {field: 'orderId', align: 'center', title: '单号', width: 170}
                    , {field: 'productName', align: 'center', title: '产品名称', width: 150}
                    , {field: 'stockName', align: 'center', title: '仓库', width: 130}
                    , {field: 'specDetail', align: 'center', title: '规格详情', width: 250}
                    , {field: 'unit', align: 'center', title: '单位', width: 70}
                    , {field: 'count', align: 'center', title: '出库数量', width: 100}
                    , {field: 'createUser', align: 'center', title: '出库人', width: 150}
                    , {field: 'createTimeUtc', align: 'center', title: '出库时间', width: 200}
                ]]
            });
        }

        //初始化表格
        tableRender();



        var openAddProduct = function () {
            layer.open({
                title: ['出库', 'font-size:18px;']
                , shade: 0.6 //遮罩透明度
                , area: ['630px','500px']//宽度
                , type: 2
                , anim: 1 //0-6的动画形式，-1不开启
                , content: '/stockOut/addButton'
                , success: function (layero, index) {
                    //layer高度自适应
                    layer.iframeAuto(index);
                }
                , end: function () {
                    var addProductHidden = $("#addProductHidden").val();
                    if (addProductHidden == "success") {

                        $("#addProductHidden").val("");
                        tableRender();
                        layer.msg('添加成功', {
                            icon: 1,
                            time: 500 //2秒关闭（如果不配置，默认是3秒）
                        });
                    } else if (addProductHidden == 2) {
                        layer.msg('添加失败',
                            {icon: 2, time: 500}
                        )
                    } else if(addProductHidden=="repeatName"){
                        layer.msg('仓库名重复',
                            {icon: 2, time: 800}
                        )
                    }
                }
            })
        }

        //合并单元格
        var mergeCell = function(){
            var trs = $("#mainbody").find("tbody").find("tr");
            var trsLength = trs.length;
            var arr = new Array();
            var index = 1;
            for (var i = 0; i < trsLength; i++) {
                var a = $(trs[i]).find("td[data-field=orderId]").find("div").html();
                var x = 1 ;
                for (var j = i+1; j < trsLength; j++) {
                    var b = $(trs[j]).find("td[data-field=orderId]").find("div").html();
                    if(a==b){
                        $(trs[j]).find("td[data-field=orderId]").attr("hidden","hidden");
                        x++;
                    }else{
                        break;
                    }
                }
                if(x>1){
                    $(trs[i]).find("td[data-field=orderId]").attr("rowspan",x);
                    for (var j = 0; j < x; j++) {
                        arr.push(index);
                    }
                }else{
                    arr.push(index);
                }
                i=i+x-1;
                index++;
            }
            for (var i = 0; i < arr.length; i++) {
                $(trs[i]).find("td").eq(0).find("div").html(arr[i]);
            }
            for (var i = 0; i < trsLength; i++) {
                var a = $(trs[i]).find("td").eq(0).find("div").html();
                var x = 1 ;
                for (var j = i+1; j < trsLength; j++) {
                    var b = $(trs[j]).find("td").eq(0).find("div").html();
                    if(a==b){
                        $(trs[j]).find("td").eq(0).attr("hidden","hidden");
                        x++;
                    }else{
                        break;
                    }
                }
                if(x>1){
                    $(trs[i]).find("td").eq(0).attr("rowspan",x);
                }
                i=i+x-1;
            }
        }

        //监听头工具栏事件
/*        table.on('toolbar(test)', function(obj){
            var checkStatus = table.checkStatus(obj.config.id)
                ,data = checkStatus.data; //获取选中的数据
            switch(obj.event){
                case 'add':
                    openAddProduct();
                    break;
                case 'update':
                    var data = checkStatus.data;
                    if(data.length<1){
                        layer.msg('未选择数据！',
                            {icon: 2, time: 500}
                        )
                    }else{
                        openUpdateProduct(data);
                    }
                    break;
                case 'delete':
                    var data = checkStatus.data;
                    openDeleteProduct(data);
                    break;
            };
        });*/


        //监听单元格编辑
/*        table.on('edit(test)', function (obj) {
            var value = obj.value //得到修改后的值
                , data = obj.data //得到所在行所有键值
                , field = obj.field; //得到字段
            //修改后颜色变红
            $(obj.tr).find('td[data-field=' + field + ']').find('div').css("color", "red");
        });*/


        //监听指定开关
/*        form.on('switch(test1)', function (obj) {
            //开关颜色变红
            $(obj.othis).css("border-color","red");
            $(obj.othis).css("background-color","red");
        });*/


        //监听搜索按钮
        form.on('submit(stockOut-search)', function (data) {
            var type = "1";
            //layer.msg(data);
            var stockId = $("#out-stockId").val();
            var orderId = $("#out-orderId").val();
            $.ajax({
                type: "GET",
                url: "/stockOut/getList",
                data: {
                    stockId: stockId,
                    orderId: orderId,
                    type:type
                },
                dataType: "json",
                contentType: "application/json",
                traditional: true,
                sync: false,
                success: function (data) {
                    table.reload('stockOutDetail', {
                        where: {"stockId": stockId, "orderId": orderId, "type": type}
                    });
                },
                error: function () {
                    console.log("调用搜索方法失败！");
                }
            });
        });

    })
}