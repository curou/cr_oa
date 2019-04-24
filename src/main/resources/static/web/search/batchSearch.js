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
        url: "/getFtl?path=search/batchSearch.ftl",
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
        , toolbar: '#toolbarDemo'
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

    //监听搜索按钮
    form.on('submit(demo2)', function (data) {
        // console.log(data);
        table.reload('layuiTable', {
            where: {"beginStr": data.field.beginDate, "endStr": data.field.endDate}
        });
    });


    var uploadObj = {};
    uploadObj.elem = '#uploadDemo';
    uploadObj.url = 'upload';
    uploadObj.accept = 'file';
    uploadObj.size = 0;
    uploadObj.before = function (obj) { //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
        layer.msg('加载中,请耐心等待.....', {
            icon: 16
            , shade: ['0.3', 'black']
            , time: 0
        });
    };
    uploadObj.done = function (res, index, upload) {
        layer.closeAll(); //关闭
        if (res.result == "" || res.result == null) {
            layer.open({
                title: "错误信息"
                , content: res.error
                , btn: ['知道了']
                , yes: function (index, layero) {
                    layer.close(index);
                }
            });
        } else {
            layer.msg("加载完成，点击导出按钮导出EXCEL！", {
                icon: 1, time: 2000
            });
            table.reload('layuiTable');
            //不可以直接用upload对象
            layui.upload.render(uploadObj);
        }
    };
    upload.render(uploadObj);

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
