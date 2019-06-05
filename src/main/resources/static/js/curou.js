layui.define(['jquery', 'layer'], function (exports) {
    var MOD_NAME = 'curou',
        $ = layui.jquery,
        layer = layui.layer,
        tree = function () {
        };
    tree.prototype.config = function () {
        return {
            isOpen: false,
            drag: false
        };
    }
    var moveTool = function (data) {
        var str = '';
        // str += '<i style="padding-right:15px;font-size: 25px;" class="tr-up layui-icon layui-icon-upload-circle"></i>';
        // str += '<i style="font-size: 25px;display: inline-block;transform: rotate(180deg);" class="tr-down layui-icon layui-icon-upload-circle"></i>';
        // str += '<i style="padding-right:15px;font-size: 25px;" class="tr-up layui-icon layui-icon-up"></i>';
        // str += '<i style="font-size: 25px;" class="tr-down layui-icon layui-icon-down"></i>';
        str += '<button type="button" class="layui-btn layui-btn-sm layui-btn-primary tr-up"><i class="layui-icon layui-icon-up"></i></button>';
        str += '<button type="button" class="layui-btn layui-btn-sm layui-btn-primary tr-down"><i class="layui-icon layui-icon-down"></i></button>';
        return str;
    };
    var reloadData = null;
    //记录已展开的节点
    var openNodes = new Array();
    //节点关闭后移除
    var removeNode = function (arr, str) {
        var index = 0;
        for (var i = 0; i < arr.length; i++) {
            if (arr[i] == str) {
                index == i;
                break;
            }
        }
        arr.splice(index, 1);
    }
    var addNode = function (arr, str) {
        var b = true;
        for (var i = 0; i < arr.length; i++) {
            if (arr[i] == str) {
                b = false;
                break;
            }
        }
        if (b) {
            arr.push(str);
        }
    }
    tree.prototype.template = function (list, template) {
        //给表格设置属性，当内容过多时出现横向滚动条
        var target = $(template.elem);
        target.css("overflow", "auto");
        target.attr("width", "100%");
        var html = '<table class="layui-table">';
        html += '<colgroup>';
        var cols = template.cols;
        //设置宽度
        for (var i = 0; i < cols.length; i++) {
            var filed = cols[i].filed;
            var type = cols[i].type;
            if (filed == null && type == "moveTool") {
                cols[i].filed = "moveTool";
                cols[i].templet = moveTool;
            }
            if (cols[i].width == null) {
                html += '<col>';
            } else {
                html += '<col width="' + cols[i].width + 'px">';
            }
        }
        html += '</colgroup>';
        html += '<thead>';
        //设置标题
        html += '<tr>';
        for (var i = 0; i < cols.length; i++) {
            html += '<th style="white-space:nowrap;text-align: ' + cols[i].align + '">' + cols[i].title + '</th>';
        }
        html += '</tr>';
        html += '</thead>';
        html += '<tbody>';
        html += '</tbody>';
        html += '</table>';
        target.html(html);
        template.tbody = '';
        template.index = 0;
        loadTableTbody(list, template);
        target.find('tbody').html(template.tbody);
    };

    var loadTableTbody = function (list, template) {
        var cols = template.cols;
        var title = template.treeTitle;
        var index = template.index;


        //需要做树形的字段名
        for (var i = 0; i < list.length; i++) {
            if (template.drag) {
                template.tbody += '<tr draggable="true" class="curou" nodeId = ' + list[i].id + '  nodePid = ' + list[i].pid + ' sort = ' + i + ' treeLevel = ' + index + ' >';
            } else {
                template.tbody += '<tr class="curou" nodeId = ' + list[i].id + '  nodePid = ' + list[i].pid + ' sort = ' + i + ' treeLevel = ' + index + ' >';
            }
            //遍历属性
            for (var j = 0; j < cols.length; j++) {
                var filed = cols[j].filed;
                if (filed == title) {
                    if (list[i].list != null) {
                        if (!template.isOpen) {
                            template.tbody += '<td style="white-space:nowrap;padding-left:' + (15 + index * 15) + 'px"><i class="layui-icon layui-icon-triangle-r openNodes"></i><span class="' + filed + '">' + list[i][filed] + '</span></td>';
                        } else {
                            template.tbody += '<td style="white-space:nowrap;padding-left:' + (15 + index * 15) + 'px"><i class="layui-icon layui-icon-triangle-d closeNodes"></i><span class="' + filed + '">' + list[i][filed] + '</span></td>';
                        }

                    } else {
                        if (index == 0) {
                            template.tbody += '<td style="white-space:nowrap;padding-left: ' + (15 + index * 15) + 'px"><i class="layui-icon layui-icon-file"></i><span class="' + filed + '">' + list[i][filed] + '</span></td>';
                        } else {
                            template.tbody += '<td style="white-space:nowrap;padding-left: ' + (15 + index * 15) + 'px"><i class="layui-icon layui-icon-file"></i><span class="' + filed + '">' + list[i][filed] + '</span></td>';
                        }

                    }
                } else {
                    var style = cols[j].align ? 'style="white-space:nowrap;text-align: ' + cols[j].align + '"' : 'style="white-space:nowrap;"';
                    if (typeof cols[j].templet === 'function') {
                        template.tbody += '<td ' + style + '>' + cols[j].templet(list[i]) + '</td>';
                    } else {
                        var html = list[i][filed] ? list[i][filed] : "/";
                        template.tbody += '<td ' + style + '><span class="' + filed + '">' + html + '</span></td>';
                    }
                }
            }
            template.tbody += '</tr>';
            if (list[i].list != null) {
                template.index = index + 1;
                loadTableTbody(list[i].list, template);
            }
        }
    }

    tree.prototype.render = function (e) {
        var t = this;
        e = $.extend(t.config(), e);
        reloadData = e;
        if (e.url) {
            e.url += '?&_=' + $.now();
            $.ajax({
                type: "POST",
                url: e.url,
                async: false,
                dataType: "json",
                contentType: "application/json",
                success: function (res) {
                    t.template(res, e);
                    treeTableEvent(e);
                },
                error: function () {
                    console.log("调用删除方法失败！");
                }
            });
        } else {
            layer.msg('没有填写url');
        }
        return true;
    };

    tree.prototype.reload = function () {
        this.render(reloadData);
        for (var i = 0; i < openNodes.length; i++) {
            var tr = $('tr[nodeId=' + openNodes[i] + ']');
            var target = tr.find('td').eq(0).find('i').eq(0);
            target.trigger("click");
        }
        ;
    };

    var treeTableEvent = function (e) {
        if (!reloadData.isOpen) {
            $("tr[treeLevel]").each(function () {
                var val = $(this).attr("treeLevel");
                if (val != 0) {
                    $(this).css("display", "none");
                }
            })
        }
        // $("i[class^='tr-']").on("mouseover mouseout",function(event){
        //     if(event.type == "mouseover"){
        //         $(this).css("color","red");
        //     }else if(event.type == "mouseout"){
        //         $(this).css("color","#666");
        //     }
        // });

        //被拖拽的行
        var dragTr = null;

        $(document).off('drop', '.curou').on('drop', '.curou', function () {
            if (e.dragUrl) {
                var self = this;
                $(".curou").css("color", "");
                if (dragTr != this) {
                    var id = $(dragTr).attr("nodeid");
                    var currPid = $(dragTr).attr("nodePid");
                    var pid = $(this).attr("nodeid");
                    if (currPid != pid) {
                        var obj = {};
                        obj.id = id;
                        obj.pid = pid;
                        var json = JSON.stringify(obj);

                        $.ajax({
                            type: "POST",
                            url: e.dragUrl,
                            async: false,
                            dataType: "json",
                            contentType: "application/json",
                            data: json,
                            success: function (res) {
                                //将被放置节点的id添加到已打开的节点集合，以便reload之后打开该节点
                                addNode(openNodes, $(self).attr("nodeId"));
                                tree.reload();
                            },
                            error: function () {
                                console.log("调用删除方法失败！");
                            }
                        });
                    }
                }
            }
        })


        $(document).off('dragstart', '.curou').on('dragstart', '.curou', function (e) {
            dragTr = this;
        })

        $(document).off('dragover', '.curou').on('dragover', '.curou', function (e) {
            e.preventDefault();
            $(this).css("color", "red");
        })

        $(document).off('dragenter', '.curou').on('dragenter', '.curou', function (e) {
        })

        $(document).off('dragleave', '.curou').on('dragleave', '.curou', function (e) {
            $(this).css("color", "");
        })

        $(document).off('dragend', '.curou').on('dragend', '.curou', function (e) {
            $(this).css("color", "");
        })
    }

    //绑定打开节点事件
    $(document).off('click', '.openNodes').on('click', '.openNodes', function (data) {
        var tr = $(this).parents("tr:first");
        addNode(openNodes, tr.attr("nodeId"));
        //更换节点开关为打开状态
        $(this).attr('class', 'layui-icon layui-icon-triangle-d closeNodes');
        openChildren(tr);

    })

    var openChildren = function (nodes) {
        if (nodes.length != 0) {
            for (var i = 0; i < nodes.length; i++) {
                //当前节点的所有直接子节点集合
                var children = new Array();
                //开关为打开状态的直接子节点集合
                var openedChildren = new Array();
                //当前行
                var tr = $(nodes[i]);
                //当前行id
                var id = tr.attr("nodeId");
                //当前行的层级
                var treeLevel = tr.attr("treeLevel");
                //往下寻找层级数小于或者等于当前节点层级的节点（即所有子孙节点）
                //pid与id相等（即直接子节点）放入集合
                while (true) {
                    var nextNode = tr.next();
                    if (nextNode.length == 0) {
                        break;
                    }
                    var nextTreeLevel = nextNode.attr("treeLevel");
                    if (treeLevel >= nextTreeLevel) {
                        break;
                    } else {
                        var pid = nextNode.attr("nodePid");
                        if (id == pid) {
                            children.push(nextNode);
                        }
                        tr = nextNode;
                    }
                }
                ;
                $.each(children, function (index, value) {
                    var pid = $(this).attr("nodePid");
                    if (id == pid) {
                        $(this).css('display', "");
                        var val = $(this).find('i').eq(0).attr('class');
                        var str = 'layui-icon layui-icon-triangle-d closeNodes';
                        if (val == str) {
                            openedChildren.push(this);
                        }
                    }
                })
                openChildren(openedChildren);
            }
        }
    }

    //绑定关闭子孙节点事件
    $(document).off('click', '.closeNodes').on('click', '.closeNodes', function (data) {
        removeNode(openNodes, $(this).parents("tr:first").attr("nodeId"));
        $(this).attr('class', 'layui-icon layui-icon-triangle-r openNodes');
        //当前节点的所有子节点集合
        var children = new Array();
        //当前行
        var tr = $($(this).parents("tr:first"));
        //当前行的层级
        var treeLevel = tr.attr("treeLevel");
        //往下寻找层级数小于或者等于当前节点层级的节点（即所有子孙节点）
        while (true) {
            var nextNode = tr.next();
            if (nextNode.length == 0) {
                break;
            }
            var nextTreeLevel = nextNode.attr("treeLevel");
            if (treeLevel >= nextTreeLevel) {
                break;
            } else {
                children.push(nextNode);
                tr = nextNode;
            }
        }
        ;
        $.each(children, function (index, value) {
            $(this).css('display', "none");
        })
    })


    $(document).off('click', '.tr-up').on('click', '.tr-up', function () {
        exit:{
            var arr = new Array();
            var current = new Object();
            var target = new Object();
            //当前节点
            var tr = $(this).parents("tr:first");
            current.id = tr.attr("nodeId");
            //当前行的层级
            var treeLevel = tr.attr("treeLevel");
            //当前节点的及所有直接子节点集合
            var withChildren = new Array();
            withChildren.push(tr);

            //上一个同层级节点的最后一行，即将当前节点及其子孙节点插入其前面
            var insertTr = null;

            var prevNode = tr.prev();
            if (prevNode.length == 0) {
                layer.msg("已经到顶了，大佬！");
                break exit;
            }
            var prevTreeLevel = prevNode.attr("treeLevel");
            if (treeLevel > prevTreeLevel) {
                layer.msg("只能在同级菜单中移动！");
                break exit;
            }

            //往上寻找层级一样的最近节点
            while (true) {
                prevNode = tr.prev();
                var prevTreeLevel = prevNode.attr("treeLevel");
                if (treeLevel == prevTreeLevel) {
                    insertTr = prevNode;
                    break;
                } else {
                    tr = prevNode;
                }
            }
            ;

            //重新指向当前节点
            tr = $(this).parents("tr:first");
            //往下寻找层级数小于或者等于当前节点层级的节点（即所有子孙节点）
            while (true) {
                var nextNode = tr.next();
                if (nextNode.length == 0) {
                    break;
                }
                var nextTreeLevel = nextNode.attr("treeLevel");
                if (treeLevel >= nextTreeLevel) {
                    break;
                } else {
                    withChildren.push(nextNode);
                    tr = nextNode;
                }
            };
            var sort = $(this).parents("tr:first").attr("sort");
            target.id = insertTr.attr("nodeId");
            arr.push(current);
            arr.push(target);
            $(this).parents("tr:first").attr("sort", insertTr.attr("sort"));
            insertTr.attr("sort", sort);
            $.each(withChildren, function (index, value) {
                $(this).insertBefore(insertTr);
            });
            var json = JSON.stringify(arr);
            $.ajax({
                type: "POST",
                url: reloadData.moveUrl,
                async: false,
                dataType: "json",
                contentType: "application/json",
                data: json,
                success: function (res) {
                    // tree.reload();
                },
                error: function () {
                    console.log("调用删除方法失败！");
                }
            });

        }
    });

    $(document).off('click', '.tr-down').on('click', '.tr-down', function () {
        exit:{
            var arr = new Array();
            var current = new Object();
            var target = new Object();
            //当前节点
            var tr = $(this).parents("tr:first");
            current.id = tr.attr("nodeId");

            //当前节点的及所有直接子节点集合
            var withChildren = new Array();
            withChildren.push(tr);
            //当前行的层级
            var treeLevel = tr.attr("treeLevel");
            //var lastTr = null;
            //下一个同层级节点的第一行
            var nextTr = null;
            //下一个同层级节点的最后一行，即将当前节点及其子孙节点插入其后
            var insertTr = null;

            //往下寻找层级数小于或者等于当前节点层级的节点（即所有子孙节点）
            while (true) {
                var nextNode = tr.next();
                if (nextNode.length == 0) {
                    layer.msg("已经到底了，大佬！");
                    break exit;
                }
                var nextTreeLevel = nextNode.attr("treeLevel");
                //层级数字大于当前节点的即为子孙节点
                if (treeLevel < nextTreeLevel) {
                    withChildren.push(nextNode);
                    tr = nextNode;
                } else if (treeLevel > nextTreeLevel) {//层级数字小于当前节点，即下一节点层级高于当前节点，也即当前节点下面没有同层级节点可以交换位置
                    layer.msg('只能在同级菜单中移动');
                    break exit;
                } else {
                    //层级与当前节点相同，即为要交换位置的节点
                    nextTr = nextNode;
                    break;
                }
            };
            var nextSort = nextTr.attr("sort");
            var currSort = $(this).parents("tr:first").attr("sort");
            $(this).parents("tr:first").attr("sort", nextSort);
            nextTr.attr("sort", currSort);

            target.id = nextTr.attr("nodeId");
            arr.push(current);
            arr.push(target);
            //往下遍历查出要交换节点的最后一层子孙节点，即要插入的位置
            while (true) {
                var nextNode = nextTr.next();
                if (nextNode.length == 0) {
                    insertTr = nextTr;
                    break;
                }
                var nextTreeLevel = nextNode.attr("treeLevel");
                if (treeLevel >= nextTreeLevel) {
                    insertTr = nextTr;
                    break;
                } else {
                    nextTr = nextNode;
                }
            };

            $.each(withChildren, function (index, value) {
                $(this).insertAfter(insertTr);
                insertTr = $(this);
            });

            var json = JSON.stringify(arr);
            $.ajax({
                type: "POST",
                url: reloadData.moveUrl,
                async: false,
                dataType: "json",
                contentType: "application/json",
                data: json,
                success: function (res) {
                    //tree.reload();
                },
                error: function () {
                    console.log("调用删除方法失败！");
                }
            });
        }
    });


    // 全部展开
    tree.prototype.openAll = function (e) {

    }
    // 全部关闭
    tree.prototype.closeAll = function (e) {
    }
    var tree = new tree();
    exports(MOD_NAME, tree)
});