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
<div style="margin-right: 20px;margin-top: 10px">
<form class="layui-form" action="javascript:;" id="selectStockForm">
    <div class="layui-form-item">
        <label class="layui-form-label">规格类型</label>
        <div class="layui-input-block" id="specId">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">规格值</label>
        <div class="layui-input-inline">
            <input type="text" name="value" id="specificationDetailVal" autocomplete="off" class="layui-input">
        </div>
        <#--<div class="layui-form-mid layui-word-aux" style="padding:0px">-->
            <#--<button class="layui-btn layui-btn-normal site-demo-active" data-type="tabAdd">-->
                <#--<i class="layui-icon">&#xe608;</i> 添加-->
            <#--</button>-->
        <#--</div>-->
        </div>
        <#--<div class="layui-inline">-->
            <#--<div class="layui-input-block">-->
            <#--<button class="layui-btn layui-btn-warm site-demo-active" data-type="tabAdd">添加规格</button>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
    <div class="layui-form-item"  id="tabDiv" style="margin-left: 30px;display: none">
        <div class="layui-tab layui-tab-brief" lay-filter="demo" lay-allowclose="true" id="demo">
            <ul class="layui-tab-title" >
            </ul>
            <div class="layui-tab-content">
            </div>
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>
</div>
<input hidden="hidden" id="specificationDetailHidden" type="text"/>
<style>
    .layui-form-mid {
        padding: 0px 0!important;
    }
</style>
<script src="/layui/layui.js" charset="utf-8"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
    layui.use(['element','form','layer'], function(){
        var $ = layui.jquery
            ,layer = layui.layer
            ,form = layui.form
            ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
        $("#specId").html(parent.layui.$("#hiddenDiv").html());
        form.render();
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.iframeAuto(index);
        //触发事件
        var active = {
            tabAdd: function(){
                var val = $("#specificationDetailVal").val();
                if(equal(val)){
                    layer.msg("已经存在该规格值！")
                    element.tabChange('demo', val);
                }else if(val==""){
                    layer.msg("请填写规格值！");
                }else{

                    $("#tabDiv").css("display", "");
                    //新增一个Tab项
                    element.tabAdd('demo', {
                        title: val //用于演示
                        ,id: val //实际使用一般是规定好的id，这里以时间戳模拟下
                    })
                    var index = parent.layer.getFrameIndex(window.name);
                    parent.layer.iframeAuto(index);
                }

            }
        };

        //tab关闭事件
        $(".layui-tab").on("click",function(e){
            if($(e.target).is(".layui-tab-close")){

                if($(".layui-tab-title").find("li").length==0){
                    $("#tabDiv").css("display", "none");
                }
            }
        })






        $('.site-demo-active').on('click', function(){
            var othis = $(this), type = othis.data('type');
            active[type] ? active[type].call(this, othis) : '';
        });

        var equal = function(id){
            console.log(id);
            var x = false;
            $("#demo").find("li").each(function(){
                var lid = $(this).attr("lay-id");
                if(lid==id){
                    x = true;
                    return false;
                }
            })
            return x;
        }


        // //下拉框选中事件
        // form.on('select(specification)', function(data){
        //     console.log(data.elem); //得到select原始DOM对象
        //     console.log(data.value); //得到被选中的值]
        //     console.log(data.othis); //得到美化后的DOM对象
        //     // var index = parent.layer.getFrameIndex(window.name);
        //     // parent.layer.iframeAuto(index);
        // });

        //监听提交
        form.on('submit(demo1)', function (data) {
            var json = JSON.stringify(data.field);
            var index = parent.layer.getFrameIndex(window.name);
            $.ajax({
                type: "POST",
                url: "/addSpecificationDetail",
                data: json,
                dataType: "json",
                contentType: "application/json",
                success: function (data) {
                    parent.layui.$("#addSpecificationDetailHidden").val(data.result);
                    parent.layer.close(index);
                },
                error: function (data) {
                    parent.layui.$("#addSpecificationDetailHidden").val(2);
                    parent.layer.close(index);
                }
            });
        });



    });
</script>

</body>
</html>