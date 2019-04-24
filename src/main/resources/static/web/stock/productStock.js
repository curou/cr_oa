layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element;


    //遍历仓库列表
    $.ajax({
        type: "POST",
        url: "/getAllStock",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            var str = '<option value=""></option>';
            for (var i = 0; i < list.length; i++) {
                str += '<option value="' + list[i].stockId + '">' + list[i].stockName + '</option>';
            }
            $("#stockId").html(str);
        },
        error: function () {
            console.log("获取仓库列表失败！");
        }
    });
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
            , id: "layuiTable"
            , url: '/stockOut/getStockPro' //数据接口
            , title: '库存明细表'
            , page: true //开启分页
            //, toolbar: '#default1'
            , limit: 10
            , limits: [10, 20, 30]
            , cols: [[ //表头
                {type: 'numbers', align: 'center', title: '序号'}
                , {field: 'proName', align: 'center', title: '产品名称', width: 130}
                , {field: 'stockName', align: 'center', title: '仓库名称', width: 130}
                , {field: 'productSpec', align: 'center', title: '产品规格', width: 250}
                , {field: 'count', align: 'center', title: '数量', width: 70}
                , {field: 'unit', align: 'center', title: '单位', width: 70}
                , {field: 'modifyTimeUtc', align: 'center', title: '最近入库时间', width: 200}


            ]]
        });
    }

    //初始化表格
    tableRender();

    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var productName = data.field.productName;
        var stockId = data.field.stockId;
        var begin = data.field.beginDate;
        var end = data.field.endDate;
        table.reload('layuiTable', {
            where: {"productName": productName, "beginStr": begin, "endStr": end, "stockId": stockId}
        });
    });

})
