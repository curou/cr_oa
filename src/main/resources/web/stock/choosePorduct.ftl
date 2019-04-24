<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>layui</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css" media="all">
    <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>

<div style="margin-top: 10px">
    <form class="layui-form" action="javascript:;" id="selectStockForm">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">产品名称</label>
                <div class="layui-input-inline">
                    <input type="text" name="keyword" id="keyword" autocomplete="off" placeholder="请输入产品名"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">产品编码</label>
                <div class="layui-input-inline">
                    <input type="text" name="productNumber" id="productNumber" autocomplete="off" placeholder="请输入产品编码"
                           class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-block">
                    <button class="layui-btn" lay-submit="" lay-filter="demo2">立即搜索</button>
                </div>
            </div>
        </div>
        <div class="layui-form-item">

        </div>
    </form>
</div>
<div style="margin-left: 10px;margin-left: 10px;margin-right: 10px">

    <table class="layui-hide" id="chooseProduct" lay-filter="chooseProduct"></table>
</div>

<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
        var table = layui.table
            , form = layui.form
            , $ = layui.jquery
            , element = layui.element;

        var tableRender = function () {
            //执行一个 table 实例

            table.render({
                elem: '#chooseProduct'
                , id:"productList"
                , url: 'getProduct' //数据接口
                , title: '产品明细表'
                , page: true //开启分页
                , limit: 10
                , limits: [10, 20, 30]
                 ,where: { productStatus: "0" }
                , cols: [[ //表头
                    {type: 'radio'}
                    , {field: 'productName', align: 'center', title: '产品名称', width: 130}
                    , {field: 'productNumber', align: 'center', title: '产品编号', width: 130}
                    , {field: 'productUnits', align: 'center', title: '产品单位', width: 130}
                    , {field: 'productUpperLimit', align: 'center', title: '库存上限', width: 130}
                    , {field: 'productLowerLimit', align: 'center', title: '库存下限', width: 220}

                ]]
            });
        }

        //初始化表格
        tableRender();

        //监听搜索按钮
        form.on('submit(demo2)', function (data) {
            var keyword = $("#keyword").val();
            var productNumber = $("#productNumber").val();
            table.reload('productList', {
                where: {"keyword": keyword, "productNumber": productNumber}
            });
        });

        //监听radio选中事件获得整行数据
        table.on('radio', function(obj){
            var val = obj.data;
            val = JSON.stringify(val);
            parent.layui.$("#addStockInHidden").val(val);
            //对象
            //console.log(obj.data);
            //Json数据
            //console.log(val);
        });


    });
</script>

</body>
</html>