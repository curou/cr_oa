layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element;

    // $("#mainbody").html($("#stockInHtml").html());

    //加载仓库列表
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
            , url: 'getStockIn' //数据接口
            , title: '产品明细表'
            , page: true //开启分页
            // , toolbar: '#stockIn-toolbarDemo'
            , limit: 10
            , where: {"type": "0"}
            , limits: [10, 20, 30]
            , done: function () {
                mergeCell();
                $("table[class=layui-table]").addClass("mytable-class");
                // $("div[class=layui-table-tool-temp]").css("display", "none");
            }
            , cols: [[ //表头
                {type: 'numbers', title: '序号',}
                , {field: 'orderId', align: 'center', title: '单号', width: 170}
                , {field: 'productName', align: 'center', title: '产品名称', width: 150}
                , {field: 'stockName', align: 'center', title: '入库仓库', width: 130}
                , {field: 'specDetail', align: 'center', title: '规格详情', width: 250}
                , {field: 'createTimeUtc', align: 'center', title: '创建时间', width: 200}
                , {field: 'createEmployeeId', align: 'center', title: '创建人', width: 200}
            ]]
        })
    };


    //初始化表格
    tableRender();


    var openUpdateProduct = function (json) {
        layer.confirm('确定提交编辑吗？', {icon: 3, title: '提示'}, function (index) {
            //checkbox选中是的class
            var checked = "layui-unselect layui-form-checkbox layui-form-checked";
            //获得选中的checkbox集合
            var list = $('div[class="' + checked + '"]');
            $.each(list, function (i, item) {
                //获取到当前switch开关的值并赋值给选中的值的对象集合
                var status = $(this).parents("tr").find('td[data-field="switch"]').find('em').html();
                if (status == "OFF") {
                    json[i].productStatus = 1
                } else {
                    json[i].productStatus = 0
                }
            });
            $.ajax({
                type: "POST",
                url: "/updateProduct",
                traditional: true,
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    table.reload("productList");
                    layer.msg('编辑成功！', {
                        icon: 1,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    });
                },
                error: function () {
                    console.log("调用编辑方法失败！");
                }
            });

        });
    }

    var openAddProduct = function () {
        layer.open({
            title: ['添加产品', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: '700px'//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=product/addProduct'
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
                } else if (addProductHidden == "repeatName") {
                    layer.msg('仓库名重复',
                        {icon: 2, time: 800}
                    )
                }
            }
        })
    }

    var openDeleteProduct = function (json) {
        layer.confirm('确定删除勾选数据吗？', {icon: 3, title: '提示'}, function (index) {
            var arr = new Array();
            debugger;
            for (var i = 0; i < json.length; i++) {
                arr.push(json[i].productId);
            }
            $.ajax({
                type: "POST",
                url: "/deleteProduct",
                traditional: true,
                data: JSON.stringify(arr),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    table.reload("productList");
                    layer.msg('删除成功！', {
                        icon: 1,
                        time: 1000 //2秒关闭（如果不配置，默认是3秒）
                    });
                },
                error: function () {
                    console.log("调用删除方法失败！");
                }
            });
        });
    }


    //头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;
        }
        ;
    });

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                openAddProduct();
                break;
            case 'update':
                var data = checkStatus.data;
                if (data.length < 1) {
                    layer.msg('未选择数据！',
                        {icon: 2, time: 500}
                    )
                } else {
                    openUpdateProduct(data);
                }
                break;
            case 'delete':
                var data = checkStatus.data;
                openDeleteProduct(data);
                break;
        }
        ;
    });


    //合并单元格
    var mergeCell = function () {
        var trs = $("#mainbody").find("tbody").find("tr");
        var trsLength = trs.length;
        var arr = new Array();
        var index = 1;
        for (var i = 0; i < trsLength; i++) {
            var a = $(trs[i]).find("td[data-field=orderId]").find("div").html();
            var x = 1;
            for (var j = i + 1; j < trsLength; j++) {
                var b = $(trs[j]).find("td[data-field=orderId]").find("div").html();
                if (a == b) {
                    $(trs[j]).find("td[data-field=orderId]").attr("hidden", "hidden");
                    x++;
                } else {
                    break;
                }
            }
            if (x > 1) {
                $(trs[i]).find("td[data-field=orderId]").attr("rowspan", x);
                for (var j = 0; j < x; j++) {
                    arr.push(index);
                }
            } else {
                arr.push(index);
            }
            i = i + x - 1;
            index++;
        }
        for (var i = 0; i < arr.length; i++) {
            $(trs[i]).find("td").eq(0).find("div").html(arr[i]);
        }
        for (var i = 0; i < trsLength; i++) {
            var a = $(trs[i]).find("td").eq(0).find("div").html();
            var x = 1;
            for (var j = i + 1; j < trsLength; j++) {
                var b = $(trs[j]).find("td").eq(0).find("div").html();
                if (a == b) {
                    $(trs[j]).find("td").eq(0).attr("hidden", "hidden");
                    x++;
                } else {
                    break;
                }
            }
            if (x > 1) {
                $(trs[i]).find("td").eq(0).attr("rowspan", x);
            }
            i = i + x - 1;
        }
    }


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var orderId = data.field.orderId;
        var stockId = data.field.stockId;
        var begin = data.field.beginDate;
        var end = data.field.endDate;
        // console.log(orderId);
        // console.log(stockId);
        // console.log(begin);
        // console.log(end);
        table.reload('layuiTable', {
            where: {"beginStr": begin, "endStr": end, "orderId": orderId, "stockId": stockId}
        });

    });

})
