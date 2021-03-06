function del(nodeId) {
    alert(nodeId)
}
//添加事件
$("#addData").on("click",function(){
    $(".show-add-data").find("input[name='name']").val("");
    layer.open({
        type:1,
        title:'添加',
        content:$(".show-add-data"),
        success:function(layero, index){
            //关闭窗口
            $(layero).find(".close-btn").on("click", function () {
                layer.close(index);
            });
            //ajax请求


        }
    });
});
function edit(id){
    //console.log(id)
    var index=layer.prompt({
        title:"请输入名称",
        formType:0,
    },function(value,index,elem){

    });
}

var layout = [
    {name: 'id', field: 'id', headerClass: 'value_col', colClass: 'value_col'},
    {name: '菜单名称', treeNodes: true, headerClass: 'value_col', colClass: 'value_col',edit:'text'},
    {
        name: '链接', field: 'id', headerClass: 'value_col', colClass: 'value_col', render: function (row) {
            if (row.link === null) {
                return '<div data-pid="' + row.id + '">no</div>';
            } else {
                return "<div data-pid='" + row.id + "' ><span><a href='" + row.link + "'target='_blank' class='layui-blue'>" + row.link + "</span></div>";
            }
        }
    },
    {
        name: '图标', treeNodes: false, headerClass: 'value_col', colClass: 'value_col', render: function (d) {
            return "<div><i class='layui-icon '>" + d.icon + "</i></div>";
        }
    },
    {
        name: '创建时间', treeNodes: false, headerClass: 'value_col', colClass: 'value_col',
        render: function (row) {
            return new Date(row.cTime).format("yyyy-MM-d hh:mm:ss");
        }
    },
    {
        name: '操作',
        headerClass: 'value_col',
        colClass: 'value_col',
        style: 'width: 20%',
        render: function (row) {
            return [
                '<a class="layui-btn layui-btn-green layui-btn-xs" lay-event="add" title="添加子菜单"> <i class="layui-icon">&#xe654;</i> </a>',
                '<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="edit" onclick="edit(' + row.id+ ')" title="编辑"> <i class="layui-icon">&#xe642;</i> </a>',
                '<a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del"   onclick="del(' + row.id + ')" title="删除"> <i class="layui-icon ">&#xe640;</i> </a>',
                '<a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="drop" title="单击拖拽，开启排序功能"> 拖拽 ↑↓ </a>',
            ].join('');


        }
    }];


var initTable = function (nodesData) {
    layui.use(['form', 'tree', 'layer'], function () {
        var layer = layui.layer, form = layui.form, $ = layui.jquery;

        var tree1 = layui.treeGird({
            elem: '#demo', //传入元素选择器
            spreadable: false, //设置是否全展开，默认不展开
            checkbox: true,
            nodes: nodesData,
            layout: layout
        });

        form.render();

        $('#collapse').on('click', function () {
            layui.collapse(tree1);
        });

        $('#deleteAll').on('click', function () {
            var arr = layui.getSelected(tree1);
            //console.log(arr);
        });

        $('#expand').on('click', function () {
            layui.expand(tree1);
        });

    });
}
$.ajax({
    url: "json/treeGirdData.json",
    data: "",
    success: function (response) {
        console.log(response);
        var data = response.treeGirdData;
        initTable(data);
    }
});