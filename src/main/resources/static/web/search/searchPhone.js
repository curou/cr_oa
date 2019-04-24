layui.use(['table', 'form', 'jquery', 'element', 'laydate', 'carousel', 'upload', 'slider'], function () {
    var table = layui.table
        , form = layui.form
        , $ = layui.jquery
        , carousel = layui.carousel //轮播
        , laypage = layui.laypage //分页
        , laydate = layui.laydate //日期
        , element = layui.element
        , slider = layui.slider //滑块
        , upload = layui.upload;//上传

    // debugger;
    // $("#mainbody").html(html);


    //监听提交
    form.on('submit(demo1)', function (data) {
        var json = JSON.stringify(data.field);

        $.ajax({
            type: "POST",
            url: "/searchPhone",
            data: {
                "regNo": data.field.regNo,
                "regName": data.field.regName
            },
            success: function (data) {
                html = '<div style="padding: 50px; line-height: 22px; background-color: #393D49; color: #fff; font-weight: 300;">' + data.success + '</div>'
                layer.open({
                    type: 1
                    , title: false //不显示标题栏
                    , closeBtn: false
                    , area: '300px;'
                    , shade: 0.8
                    , id: 'LAY_layuipro' //设定一个id，防止重复弹出
                    , btn: ['知道了']
                    , btnAlign: 'c'
                    , moveType: 1 //拖拽模式，0或者1
                    , content: html
                });

            },
            error: function (data) {

            }
        });
    });

})
