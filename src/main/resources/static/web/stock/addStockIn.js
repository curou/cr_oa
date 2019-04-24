layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element;
    // var html = '<div style="margin: 10px">\n' +
    //     '        <div style="margin-top: 10px;margin-right: 20px">\n' +
    //     '            <form class="layui-form addStockInForm" action="">\n' +
    //     '\n' +
    //     '                <div class="layui-form-item">\n' +
    //     '                    <label class="layui-form-label">产品名称</label>\n' +
    //     '                    <div class="layui-input-inline">\n' +
    //     '                        <input type="text" name="productId" id="addStockIn-productName" autocomplete="off"\n' +
    //     '                               class="layui-input" disabled>\n' +
    //     '                    </div>\n' +
    //     '                    <div class="layui-form-mid layui-word-aux" style="padding:0px">\n' +
    //     '                        <button type="button" class="layui-btn layui-btn-normal site-demo-active"\n' +
    //     '                                data-type="openChooseProduct">\n' +
    //     '                            <i class="layui-icon">&#xe608;</i> 选择\n' +
    //     '                        </button>\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '                <div class="layui-form-item">\n' +
    //     '\n' +
    //     '                    <label class="layui-form-label">入库数量</label>\n' +
    //     '                    <div class="layui-input-inline">\n' +
    //     '                        <input type="number" name="count" id="addStockIn-count" lay-verify="required" autocomplete="off" class="layui-input">\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '                <div class="layui-form-item">\n' +
    //     '                    <label class="layui-form-label">选择单位</label>\n' +
    //     '                    <div class="layui-input-inline">\n' +
    //     '                        <select name="unit" id="addStockIn-unit" lay-filter="unit" lay-verify="required">\n' +
    //     '                        </select>\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '\n' +
    //     '\n' +
    //     '                <div class="layui-form-item">\n' +
    //     '                    <label class="layui-form-label">选择规格</label>\n' +
    //     '                    <div class="layui-input-inline">\n' +
    //     '                        <select name="specId" id="addStockIn-specId" lay-filter="specId">\n' +
    //     '\n' +
    //     '                        </select>\n' +
    //     '                    </div>\n' +
    //     '                    <div class="layui-input-inline">\n' +
    //     '                        <select name="specsId" id="addStockIn-specsId" lay-filter="specsId">\n' +
    //     '\n' +
    //     '                        </select>\n' +
    //     '                    </div>\n' +
    //     '                    <div class="layui-form-mid layui-word-aux" style="padding:0px">\n' +
    //     '                        <button type="button" class="layui-btn layui-btn-normal site-demo-active"\n' +
    //     '                                data-type="openChooseSpec">\n' +
    //     '                            <i class="layui-icon">&#xe608;</i> 添加\n' +
    //     '                        </button>\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '                <div class="layui-form-item" id="tabDiv" style="margin-left: 30px;display: none">\n' +
    //     '                    <div class="layui-tab layui-tab-brief" lay-filter="addStockInTab1" lay-allowclose="true" id="addStockInTab1">\n' +
    //     '                        <ul class="layui-tab-title">\n' +
    //     '                        </ul>\n' +
    //     '                        <div class="layui-tab-content">\n' +
    //     '                        </div>\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '\n' +
    //     '\n' +
    //     '                <div class="layui-form-item">\n' +
    //     '                    <div class="layui-input-block">\n' +
    //     '                        <button type="button" class="layui-btn layui-btn-normal" lay-submit=""  lay-filter="demo0">添加入库</button>\n' +
    //     '                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '            </form>\n' +
    //     '\n' +
    //     '            <div style="display:none" id="addProductFormDiv">\n' +
    //     '            <hr style="margin-top: 20px;margin-bottom: 20px">\n' +
    //     '\n' +
    //     '            <form class="layui-form addStockInFormTwo" action="">\n' +
    //     '\n' +
    //     '                <div class="layui-form-item">\n' +
    //     '                    <label class="layui-form-label">入库仓库</label>\n' +
    //     '                    <div class="layui-input-inline">\n' +
    //     '                        <select name="stockId" id="addStockIn-stockId" lay-filter="stockId" lay-verify="required">\n' +
    //     '\n' +
    //     '                        </select>\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '\n' +
    //     '                <div style="margin-left: 25px">\n' +
    //     '\n' +
    //     '                    <div class="layui-form">\n' +
    //     '                        <table class="layui-table" style="text-align: center" id="addStockInTable">\n' +
    //     '                            <colgroup>\n' +
    //     '                                <col width="150">\n' +
    //     '                                <col width="100">\n' +
    //     '                                <col width="100">\n' +
    //     '                                <col width="150">\n' +
    //     '                                <col>\n' +
    //     '                            </colgroup>\n' +
    //     '                            <thead>\n' +
    //     '                            <tr>\n' +
    //     '                                <th style="text-align: center">产品名称</th>\n' +
    //     '                                <th style="text-align: center">数量</th>\n' +
    //     '                                <th style="text-align: center">单位</th>\n' +
    //     '                                <th style="text-align: center">产品规格</th>\n' +
    //     '                                <th style="text-align: center">操作</th>\n' +
    //     '                            </tr>\n' +
    //     '                            </thead>\n' +
    //     '                            <tbody class="stockInTbody">\n' +
    //     '\n' +
    //     '                            </tbody>\n' +
    //     '                        </table>\n' +
    //     '                    </div>\n' +
    //     '                    <div class="layui-btn-group demoTable" style="margin-bottom: 10px;">\n' +
    //     '                        <button type="button" lay-submit="" class="layui-btn" lay-filter="demo1">立即提交</button>\n' +
    //     '                    </div>\n' +
    //     '                </div>\n' +
    //     '            </form>\n' +
    //     '            </div>\n' +
    //     '            <input hidden="hidden" id="addStockInHidden">\n' +
    //     '            <input hidden="hidden" class="addStockIn-productId-hidden">\n' +
    //     '            <input hidden="hidden" class="addStockIn-specId-hidden">\n' +
    //     '            <input hidden="hidden" class="addStockIn-specsId-hidden">';
    //
    //
    // debugger;
    // $("#mainbody").html(html);

    //遍历单位列表
    $.ajax({
        type: "POST",
        url: "/getAllProductUnit",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            var str = '<option value=""></option>';
            for (var i = 0; i < list.length; i++) {
                str += '<option value="' + list[i].id + '">' + list[i].value + '</option>';
            }
            $("#addStockIn-unit").html(str);
        },
        error: function () {
            console.log("获取仓库列表失败！");
        }
    });


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
            $("#addStockIn-stockId").html(str);
        },
        error: function () {
            console.log("获取仓库列表失败！");
        }
    });

    //遍历规格类型菜单
    var specId = '<option value=""></option>';
    $.ajax({
        type: "POST",
        url: "/getAllSpecification",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            for (var i = 0; i < list.length; i++) {
                var str = list[i].specSort + "," + list[i].specId;
                specId += '<option value="' + str + '">' + list[i].specName + '</option>';
            }
        },
        error: function () {
            console.log("请求规格失败！");
        }
    });
    $("#addStockIn-specId").html(specId);
    form.render();

    //监听按钮点击事件
    $('.site-demo-active').on('click', function () {
        var othis = $(this), type = othis.data('type');
        active[type] ? active[type].call(this, othis) : '';
    });
    //监听按钮点击事件
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听按钮点击事件添加入库
    form.on('submit(demo0)', function (data) {


        //产品名
        var productName = $("#addStockIn-productName").val();

        //数量
        var count = $("#addStockIn-count").val();
        //单位
        var unti = $("#addStockIn-unit").next().find("input").val();

        //产品id
        var productId = $(".addStockIn-productId-hidden").val();

        var arr = new Array();
        $("#addStockInTab1").find("li").each(function () {
            //排序+specId+specsId
            var lid = $(this).attr("lay-id");
            var html = $(this).html();
            var index = html.indexOf("<");
            //specs value
            var val = html.substring(0, index);
            lid = lid + "," + val;
            arr.push(lid);
        })

        //根据排序调整规格展示顺序
        var newArr = sortarr(arr);
        var specArr = new Array();
        for (var i = 0; i < newArr.length; i++) {
            var index = newArr[i].indexOf(",");
            var str = newArr[i].substring(index + 1, newArr[i].length);
            index = str.lastIndexOf(",");
            str = str.substring(0, index);

            index = str.indexOf(",");
            var str1 = str.substring(0, index);
            var str2 = str.substring(index + 1, str.length);
            var json = {};
            json[str1] = str2;
            specArr.push(json);
        }
        var jsonStr = JSON.stringify(specArr);

        var x = false;
        $("#addStockInTable").find('tbody').eq(0).find("tr").each(function () {

            var productIdTemp = $(this).find("td").eq(0).find("input").eq(0).val();
            var specDetailTemp = $(this).find("td").eq(3).find("span").eq(0).html();
            if (productId == productIdTemp && jsonStr == specDetailTemp) {
                x = true;
                return false;
            }

        });

        if (x) {
            layer.msg('入库单中已经存在该产品！',
                {icon: 2, time: 500}
            )
        } else if (productName == null || productName == "") {

            layer.msg('请选择产品！',
                {icon: 2, time: 500}
            )
        } else if (count == null || count == "") {
            layer.msg('请填写入库数量！',
                {icon: 2, time: 500}
            )
        } else if (unti == null || unti == "") {
            layer.msg('请选择单位！',
                {icon: 2, time: 500}
            )
        } else if ($("#addStockInTab1").find("li").length == 0) {
            layer.msg('请选择规格！',
                {icon: 2, time: 500}
            )
        } else {

            var specDetail = "";
            for (var i = 0; i < newArr.length; i++) {
                var index = newArr[i].lastIndexOf(",");
                var val = newArr[i].substring(index + 1, newArr[i].length);
                specDetail = specDetail + val + ",";
            }
            specDetail = specDetail.substring(0, specDetail.length - 1);


            var html = '<tr><td>productHtml</td><td>countHtml</td><td>unitHtml</td><td>specHtml</td><td><button type="button" class="layui-btn layui-btn-danger layui-btn-sm delProduct">移除</button></td></tr>';
            var productHtml = '<input hidden="hidden" value="' + productId + '"><p>' + productName + '</p>';
            var unitHtml = unti;
            var countHtml = count;
            var specHtml = '<span hidden="hidden">' + jsonStr + '</span><p>' + specDetail + '</p>';
            html = html.replace("productHtml", productHtml);
            html = html.replace("unitHtml", unitHtml);
            html = html.replace("countHtml", countHtml);
            html = html.replace("specHtml", specHtml);
            $("#addStockInTable").append(html);
            $("#addProductFormDiv").css("display", "");
            //清空表格
            $("form[class$=addStockInForm]")[0].reset();
            //删除规格TAB
            $("#addStockInTab1").find("li").each(function () {
                var lid = $(this).attr("lay-id");
                element.tabDelete('addStockInTab1', lid);
            })
            //隐藏规格tab横线
            $("#tabDiv").css("display", "none");
        }


    });

    //冒泡排序
    function sortarr(arr) {
        for (i = 0; i < arr.length - 1; i++) {
            for (j = 0; j < arr.length - 1 - i; j++) {
                var index1 = arr[j].indexOf(",");
                var index2 = arr[j + 1].indexOf(",");
                var val1 = arr[j].substring(0, index1);
                var val2 = arr[j + 1].substring(0, index2);
                if (val1 > val2) {
                    var temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


    // //监听按钮点击事件移除一行
    // $(document).on('click', '.delProduct', function(data) {
    //     $(this).parents("tr:first").remove();
    //     if($("tbody[class=stockInTbody]").find("tr").length==0){
    //         $("#addProductFormDiv").css("display", "none");
    //     }
    // });

    //监听按钮点击事件
    $('.delProduct').on('click', function () {
        $(this).parents("tr:first").remove();
        if ($("tbody[class=stockInTbody]").find("tr").length == 0) {
            $("#addProductFormDiv").css("display", "none");
        }
    });

    //监听按钮点击事件提交
    form.on('submit(demo1)', function (data) {

        //校验仓库是否选择
        var stockId = $("#addStockIn-stockId").val();
        if (stockId == null || stockId == "") {
            layer.msg('请选择仓库！',
                {icon: 2, time: 500}
            )
            return false;
        }
        var base = {};
        base.stockId = stockId;

        var arr = new Array();
        $("#addStockInTable").find('tbody').eq(0).find("tr").each(function () {
            var son = {};
            son.productId = $(this).find("td").eq(0).find("input").eq(0).val();
            son.productName = $(this).find("td").eq(0).find("p").eq(0).html();
            son.count = $(this).find("td").eq(1).html();
            son.unit = $(this).find("td").eq(2).html();
            son.specDetail = $(this).find("td").eq(3).find("span").eq(0).html();
            arr.push(son);
        });
        base.list = arr;
        $.ajax({
            type: "POST",
            url: "/addStockInOrder",
            traditional: true,
            data: JSON.stringify(base),
            dataType: "json",
            contentType: "application/json",
            success: function (data) {
                //清空表格
                $("form[class$=addStockInForm]")[0].reset();
                $("form[class$=addStockInFormTwo]")[0].reset();
                $("#addStockInTable").find('tbody').eq(0).html("");
                $("#addProductFormDiv").css("display", "none");
                //删除规格TAB
                $("#addStockInTab1").find("li").each(function () {
                    var lid = $(this).attr("lay-id");
                    element.tabDelete('addStockInTab1', lid);
                })
                //隐藏规格tab横线
                $("#tabDiv").css("display", "none");
                layer.msg('添加成功！', {
                        icon: 1,
                        time: 1000
                    }//2秒关闭（如果不配置，默认是3秒）
                );
            },
            error: function () {
                console.log("添加入库单方法失败！");
            }
        });

    });


    //触发事件
    var active = {
        //弹窗产品列表
        openChooseProduct: function () {
            layer.open({
                title: ['添加产品', 'font-size:18px;']
                , shade: 0.6 //遮罩透明度
                , area: ['880px', '400px']//宽度
                , type: 2
                , anim: 1 //0-6的动画形式，-1不开启
                , content: 'jump?url=stock/choosePorduct'
                , btn: ['选择', '关闭']
                , yes: function (index, layero) {
                    //清空表格
                    $("form[class$=addStockInForm]")[0].reset();
                    //删除规格TAB
                    $("#addStockInTab1").find("li").each(function () {
                        var lid = $(this).attr("lay-id");
                        element.tabDelete('addStockInTab1', lid);
                    })
                    //隐藏规格tab横线
                    $("#tabDiv").css("display", "none");

                    var json = $("#addStockInHidden").val();
                    //json字符串转json对象
                    var obj = JSON.parse(json);
                    $("#addStockIn-productName").val(obj.productName);
                    $(".addStockIn-productId-hidden").val(obj.productId);


                    layer.close(index);
                }
            })
        }
        //生成规格Tab
        , openChooseSpec: function () {
            //排序+id
            var spec = $("#addStockIn-specId").val();
            //value
            var specVal = $("#addStockIn-specId").next().find("input").val();
            var specsVal = $("#addStockIn-specsId").next().find("input").val();
            var specs = $("#addStockIn-specsId").val();
            //规格类型排序+规格类型ID+规格值ID
            var str = spec + "," + specs;
            if (spec == null || spec == "") {
                layer.msg("请选择规格类型！")
            } else if (specs == null || specs == "") {
                layer.msg("请选择规格值！")
            } else {
                if (equal("#addStockInTab1", str)) {
                    layer.msg("已经存在该规格类型！")
                } else {
                    $("#tabDiv").css("display", "");
                    element.tabAdd('addStockInTab1', {
                        title: specsVal //显示的文本
                        , id: str
                    })
                }
            }
        }

    };

    //下拉框选中事件
    form.on('select(specId)', function (data) {
        var id = data.value; //得到被选中的值
        id = id.split(",")[1];
        //遍历规格值菜单
        var specsId = '<option value=""></option>';
        $.ajax({
            type: "POST",
            url: "/getAllSpecificationDetail",
            traditional: true,
            dataType: "json",
            async: false,
            data: {
                "specId": id
            },
            success: function (list) {

                for (var i = 0; i < list.length; i++) {
                    specsId += '<option value="' + list[i].id + '">' + list[i].value + '</option>';
                }
            },
            error: function () {
                console.log("请求规格失败！");
            }
        });
        $("#addStockIn-specsId").html(specsId);

        form.render();

    });


    //遍历现在tab对比是否存在同样的值
    var equal = function (tabId, id) {
        var x = false;
        $(tabId).find("li").each(function () {
            var lid = $(this).attr("lay-id");
            var index1 = lid.indexOf(",");
            var index2 = lid.lastIndexOf(",");
            var str1 = lid.substring(index1 + 1, index2);
            index1 = id.indexOf(",");
            index2 = id.lastIndexOf(",");
            var str2 = id.substring(index1 + 1, index2);
            if (str1 == str2) {
                x = true;
                return false;
            }
        })
        return x;
    }

    //tab选项卡关闭完之后隐藏整个tab的div
    $(".layui-tab").on("click", function (e) {
        if ($(e.target).is(".layui-tab-close")) {
            if ($(".layui-tab-title").find("li").length == 0) {
                $("#tabDiv").css("display", "none");
            }
        }
    })


})
