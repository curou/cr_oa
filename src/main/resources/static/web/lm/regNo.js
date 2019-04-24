layui.use(['table', 'form', 'jquery', 'element', 'laydate', 'carousel', 'upload', 'slider'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , laydate = layui.laydate
        , element = layui.element
        , upload = layui.upload;//上传

    var html = "";
    $.ajax({
        type: "GET",
        url: "/getFtl?path=lm/regNo.ftl",
        async: false,
        dataType: "json",
        success: function (data) {
            html = data.result;
        },
        error: function () {
            console.log("调用页面载入方法失败！");
        }
    });

    $("#mainbody").html(html);

    //遍历项目列表
    $.ajax({
        type: "POST",
        url: "/getAllProject",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            var str = '<option value=""></option>';
            for (var i = 0; i < list.length; i++) {
                str += '<option value="' + list[i].id + '">' + list[i].proName + '</option>';
            }
            $("#proType").html(str);
        },
        error: function () {
            console.log("获取项目列表失败！");
        }
    });

    //遍历卡类型列表
    $.ajax({
        type: "POST",
        url: "/getAllCard",
        traditional: true,
        dataType: "json",
        async: false,
        contentType: "application/json",
        success: function (list) {
            var str = '<option value=""></option>';
            for (var i = 0; i < list.length; i++) {
                str += '<option value="' + list[i].id + '">' + list[i].cardName + '</option>';
            }
            $("#cardType").html(str);
        },
        error: function () {
            console.log("获取卡类型列表失败！");
        }
    });

    //日期
    laydate.render({
        elem: '#date1'
        , type: 'datetime'
    });
    laydate.render({
        elem: '#date2'
        , type: 'datetime'
    });


    //初始化数据表格
    table.render({
        elem: '#demo'
        , id: "layuiTable"
        , url: 'uploadDetail/list' //数据接口
        , title: '查询明细表'
        , page: true //开启分页
        , toolbar: 'default'
        , limit: 10
        , limits: [10, 20, 30]
        , cols: [[ //表头
            {type: 'numbers', title: '序号'}
            , {field: 'createTimeUtc', align: 'center', title: '查询时间', width: 220}
            , {field: 'count', align: 'center', title: '查询总数', width: 130}
            , {field: 'effectiveCount', align: 'center', title: '有效数量', width: 130}
            , {
                field: 'switch', title: '操作', align: 'center', width: 150, templet: function (res) {
                    return '<a  href="exportCompanyInfo?uploadDetailId=' + res.id + '" class="layui-btn layui-btn-sm layui-btn-normal">导出EXCEL</a>';
                }
            }
        ]]
    });
    form.render();

    //监听头工具栏事件
    table.on('toolbar(test)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id)
            , data = checkStatus.data; //获取选中的数据
        switch (obj.event) {
            case 'add':
                openAddRegCode();
                break;
            case 'update':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else if (data.length > 1) {
                    layer.msg('只能同时编辑一个');
                } else {
                    layer.alert('编辑 [id]：' + checkStatus.data[0].id);
                }
                break;
            case 'delete':
                if (data.length === 0) {
                    layer.msg('请选择一行');
                } else {
                    layer.msg('删除');
                }
                break;
        }
        ;
    });

    var openAddRegCode = function () {
        layer.open({
            title: ['生成注册码', 'font-size:18px;']
            , shade: 0.6 //遮罩透明度
            //, area: ['700px','250px']//宽度
            , area: '710px'
            , type: 2
            , anim: 1 //0-6的动画形式，-1不开启
            , content: 'jump?url=lm/addRegNo'
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


    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        // console.log(data);
        table.reload('layuiTable', {
            where: {"beginStr": data.field.beginDate, "endStr": data.field.endDate}
        });
    });

    //监听按钮点击
    $(document).off('click', '.export').on('click', '.export', function (data) {
        //layer.msg($(this).prev().attr("data"));
        $.ajax({
            type: "GET",
            url: "/exportCompanyInfo?uploadDetailId=" + $(this).prev().attr("data"),
            async: false,
            dataType: "json",
            success: function (data) {

            },
            error: function () {
                console.log("调用页面载入方法失败！");
            }
        });
    });


})
