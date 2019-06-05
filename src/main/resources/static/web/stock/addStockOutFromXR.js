var addStockOut = function(){


    layui.use(['table', 'form', 'jquery', 'element', 'laydate'], function () {
        var table = layui.table
            , form = layui.form
            , $ = layui.jquery
            , laydate = layui.laydate
            , element = layui.element;
        $("#mainbody").html($("#addStockOutHtml").html());
        form.render();
    })
}