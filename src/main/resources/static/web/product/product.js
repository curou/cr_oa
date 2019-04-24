layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element;


    // $("#mainbody").html(html);
    // debugger;
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
            , id: "productList"
            , url: 'getProduct' //数据接口
            , title: '产品明细表'
            , page: true //开启分页
            , toolbar: 'default'
            , limit: 10
            , limits: [10, 20, 30]
            , cols: [[ //表头
                {type: 'checkbox'}
                , {field: 'productName', align: 'center', title: '产品名称', width: 130, edit: 'text'}
                , {field: 'productNumber', align: 'center', title: '产品编号', width: 130, edit: 'text'}
                , {field: 'productUnits', align: 'center', title: '产品单位', width: 130, edit: 'text'}
                , {field: 'productUpperLimit', align: 'center', title: '库存上限', width: 130, edit: 'text'}
                , {field: 'productLowerLimit', align: 'center', title: '库存下限', width: 220, edit: 'text'}
                , {
                    field: 'switch', title: '启用/禁用', align: 'center', width: 90, templet: function (res) {
                        if (res.productStatus == 1) {
                            return '<input type="checkbox"  lay-skin="switch" lay-filter=test1 lay-text="ON|OFF">';
                        } else {
                            return '<input type="checkbox"  lay-skin="switch" lay-filter=test1 lay-text="ON|OFF" checked>';
                        }
                    }
                }

            ]]
        });
    }

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
                    layer.msg('产品名重复',
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


    //监听单元格编辑
    table.on('edit(test)', function (obj) {
        var value = obj.value //得到修改后的值
            , data = obj.data //得到所在行所有键值
            , field = obj.field; //得到字段
        //修改后颜色变红
        $(obj.tr).find('td[data-field=' + field + ']').find('div').css("color", "red");
    });


    //监听指定开关
    form.on('switch(test1)', function (obj) {
        //开关颜色变红
        $(obj.othis).css("border-color", "red");
        $(obj.othis).css("background-color", "red");
    });


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var status = data.field.productStatus;
        //layer.msg(data);
        var keyword = $("#keyword").val();
        var productNumber = $("#productNumber").val();
        var begin = $("#date1").val();
        var end = $("#date2").val();
        table.reload('productList', {
            where: {
                "keyword": keyword,
                "beginStr": begin,
                "endStr": end,
                "productStatus": status,
                "productNumber": productNumber
            }
        });
    });

})
