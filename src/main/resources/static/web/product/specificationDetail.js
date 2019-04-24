// var spec = '<option value=""></option>';
// var hiddenInput = '<div id="hiddenDiv" hidden="hidden">';
// layui.use(['jquery'], function () {
//
//     var $ = layui.jquery;
//     $.ajax({
//         type: "POST",
//         url: "/getSpecification",
//         traditional: true,
//         dataType: "json",
//         async: false,
//         contentType: "application/json",
//         success: function (data) {
//             var list = data.data;
//             for (var i = 0; i < list.length; i++) {
//                 spec += '<option value="' + list[i].specId + '">' + list[i].specName + '</option>';
//                 hiddenInput += '<input type="radio" name="specId" value="' + list[i].specId + '" title="' + list[i].specName + '">'
//             }
//         },
//         error: function () {
//             console.log("请求规格失败！");
//         }
//     });
//
//
// });
// hiddenInput += "</div>";
//
// var html = '<div style="margin: 10px">\n' +
//     '<div style="margin-top: 10px;margin-right: 20px">\n' +
//     '    <form class="layui-form" action="javascript:;" id="layuiForm">\n' +
//     '        <div class="layui-form-item">\n' +
//     '            <div class="layui-inline">\n' +
//     '                <label class="layui-form-label">所属类型</label>\n' +
//     '                <div class="layui-input-inline">\n' +
//     '                    <select name="specId" id="specId"  lay-filter="specId" id="specId">\n' +
//     '                    ' + spec + '\n' +
//     '                    </select>\n' +
//     '                </div>\n' +
//     '            </div>\n' +
//     '            <div class="layui-inline">\n' +
//     '                <label class="layui-form-label">规格值名称</label>\n' +
//     '                <div class="layui-input-inline">\n' +
//     '                    <input type="text" name="value" id="value" autocomplete="off" placeholder="请输入规格值"\n' +
//     '                           class="layui-input">\n' +
//     '                </div>\n' +
//     '            </div>\n' +
//     '            <div class="layui-inline">\n' +
//     '                <div class="layui-input-block">\n' +
//     '                    <button class="layui-btn" lay-submit="" lay-filter="demo2">立即搜索</button>\n' +
//     '                </div>\n' +
//     '            </div>\n' +
//     '        </div>\n' +
//     '    </form>\n' +
//     '</div>\n' +
//     '    <hr style="margin-bottom: 20px">\n' +
//     '    <div style="margin-left: 10px;margin-right: 10px">\n' +
//     '        <table class="layui-hide" id="demo" lay-filter="test"></table>\n' +
//     '    </div>\n' +
//     '    <input id="addSpecificationDetailHidden" value="" hidden="hidden">\n' +
//     '</div>' + hiddenInput;

layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element;
    // debugger;
    // $("#mainbody").html(html);

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
                var str = list[i].specId;
                specId += '<option value="' + str + '">' + list[i].specName + '</option>';
            }
        },
        error: function () {
            console.log("请求规格失败！");
        }
    });
    $("#specId").html(specId);
    form.render();

    var tableRender = function () {
        //执行一个 table 实例

        table.render({
            elem: '#demo'
            , id: "layuiTable"
            , url: 'getSpecificationDetail' //数据接口
            , title: '产品明细表'
            , page: true //开启分页
            , toolbar: 'default'
            , limit: 10
            , limits: [10, 20, 30]
            , cols: [[ //表头
                {type: 'checkbox'}
                , {field: 'value', align: 'center', title: '规格值名称', width: 130, edit: 'text'}
                , {field: 'createTimeUtc', align: 'center', title: '创建时间', width: 300}
            ]]
        });
    }

    //初始化表格
    tableRender();


    var openUpdateSpecificationDetail = function (json) {
        layer.confirm('确定提交编辑吗？', {icon: 3, title: '提示'}, function (index) {
            $.ajax({
                type: "POST",
                url: "/updateSpecificationDetail",
                traditional: true,
                data: JSON.stringify(json),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    table.reload("layuiTable");
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

    var openAddSpecificationDetail = function () {

        layer.open({
            title: ['添加规格值', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            , area: '400px'//宽度
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=product/addSpecificationDetail'
            // , success: function (layero, index) {
            //     //layer高度自适应
            //     layer.iframeAuto(index);
            // }
            , end: function () {
                var addSpecificationDetailHidden = $("#addSpecificationDetailHidden").val();
                if (addSpecificationDetailHidden == "success") {

                    $("#addSpecificationDetailHidden").val("");
                    tableRender();
                    layer.msg('添加成功', {
                        icon: 1,
                        time: 500 //2秒关闭（如果不配置，默认是3秒）
                    });
                } else if (addSpecificationDetailHidden == 2) {
                    layer.msg('添加失败',
                        {icon: 2, time: 500}
                    )
                } else if (addSpecificationDetailHidden == "repeatName") {
                    layer.msg('规格值重复',
                        {icon: 2, time: 800}
                    )
                }
            }
        })
    }

    var openDeleteSpecificationDetail = function (json) {
        layer.confirm('确定删除勾选数据吗？', {icon: 3, title: '提示'}, function (index) {
            var arr = new Array();
            debugger;
            for (var i = 0; i < json.length; i++) {
                arr.push(json[i].id);
            }
            $.ajax({
                type: "POST",
                url: "/deleteSpecificationDetail",
                traditional: true,
                data: JSON.stringify(arr),
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    table.reload("layuiTable");
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
                openAddSpecificationDetail();
                break;
            case 'update':
                var data = checkStatus.data;
                if (data.length < 1) {
                    layer.msg('未选择数据！',
                        {icon: 2, time: 500}
                    )
                } else {
                    openUpdateSpecificationDetail(data);
                }
                break;
            case 'delete':
                var data = checkStatus.data;
                openDeleteSpecificationDetail(data);
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


    // //监听指定开关
    // form.on('switch(test1)', function (obj) {
    //     //开关颜色变红
    //     $(obj.othis).css("border-color", "red");
    //     $(obj.othis).css("background-color", "red");
    // });


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        var keyword = data.field.value;
        var specId = data.field.specId;

        table.reload('layuiTable', {
            where: {
                "keyword": keyword,
                "specId": specId
            }
        });
    });


})


