<!DOCTYPE html>
<meta/>
<link/>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
<title>layout 后台大布局 - Layui</title>
<link rel="stylesheet" href="/layui/css/layui.css"/>
<link rel="stylesheet" href="/css/global.css"/>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <#--<div class="layui-logo" id="logo"><span>马哥授权码管理平台</span></div>-->
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" lay-filter="leftmenu" id="leftmenu">
            <li class="layui-nav-item">
                <a href="javascript:;" class="hidetab" title="隐藏左侧菜单" id="menu-button"><i class="layui-icon layui-icon-shrink-right"></i></a>
            </li>
            <#--<li class="layui-nav-item">-->
                <#--<a href="./index.html" title="主页"><i class="layui-icon layui-icon-home"></i></a>-->
            <#--</li>-->
            <li class="layui-nav-item">
                <a href="javascript:window.location.reload();" title="刷新"><i
                            class="layui-icon layui-icon-refresh-3"></i></a>
            </li>
            <#--<li class="layui-nav-item layui-hide-xs">-->
            <#--<input class="layui-input layui-input-search" type="text" placeholder="搜索" autocomplete="off"/>-->
            <#--</li>-->
        </ul>
        <ul class="layui-nav layui-layout-right" id="rightmenu">
            <li class="layui-nav-item">
                <#if userInfo?has_content>
                    <a href="javascript:;">
                        ${userInfo.name}
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a id="user-edit">修改资料</a></dd>
                        <#--<dd><a href="">安全设置</a></dd>-->
                    </dl>
                <#else>
                    <a href="/login">请登录</a>
                </#if>
            </li>
            <#if userInfo?has_content>
                <li class="layui-nav-item"><a href="/loginOut">退出</a></li>
            </#if>
        </ul>
    </div>

    <div class="layui-side layui-bg-black layui-side-menu" style="top:0px;z-index: 1001;">
        <div class="layui-logo" id="logo" style="height:49px;color:rgba(255,255,255,.8);line-height: 50px;"><span style="position: absolute;margin-left: 16px;font-size: 20px;display:none " id="companyName">CR</span><span id="osName">企业管理平台</span></div>
        <div class="layui-side-scroll">

            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="navtree" id="navtree" style="margin-top: 50px">
                <#list lists as menus>
                    <#if menus[0].permissionKey?has_content>
                        <@shiro.hasPermission name="${menus[0].permissionKey}">
                            <#list menus as menu>
                            <#if menu_index == 0>
                                <li class="layui-nav-item">
                                <a href="javascript:;" url="${menu.url}" title="${menu.title}"><i class="${menu.icon}"></i><cite class="menu">${menu.title}</cite></a>
                            </#if>
                            <#if menu_index != 0>
                                <#if menu_index==1&&menu_index==(menus?size-1)>
                                    <dl class="layui-nav-child">
                                    <#if menu.permissionKey?has_content>
                                        <@shiro.hasPermission name="${menu.permissionKey}">
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                        </@shiro.hasPermission>
                                        </dl></li>
                                    <#else>
                                        <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd></dl></li>
                                    </#if>
                                </#if>
                                <#if menu_index==1&&menu_index!=(menus?size-1)>
                                    <dl class="layui-nav-child">
                                    <#if menu.permissionKey?has_content>
                                        <@shiro.hasPermission name="${menu.permissionKey}">
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                        </@shiro.hasPermission>
                                    <#else>
                                        <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                    </#if>
                                </#if>
                                <#if menu_index!=1>
                                    <#if menu_index==(menus?size-1)>
                                        <#if menu.permissionKey?has_content>
                                            <@shiro.hasPermission name="${menu.permissionKey}">
                                                <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                            </@shiro.hasPermission>
                                            </dl></li>
                                        <#else>
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd></dl></li>
                                        </#if>
                                    <#else>
                                        <#if menu.permissionKey?has_content>
                                            <@shiro.hasPermission name="${menu.permissionKey}">
                                                <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                            </@shiro.hasPermission>
                                        <#else>
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                        </#if>
                                    </#if>
                                </#if>
                            </#if>
                        </#list>
                        </@shiro.hasPermission>
                    <#else>
                            <#list menus as menu>
                            <#if menu_index == 0>
                                <li class="layui-nav-item">
                                <a href="javascript:;" url="${menu.url}" title="${menu.title}"><i class="${menu.icon}"></i><cite class="menu">${menu.title}</cite></a>
                            </#if>
                            <#if menu_index != 0>
                                <#if menu_index==1&&menu_index==(menus?size-1)>
                                    <dl class="layui-nav-child">
                                    <#if menu.permissionKey?has_content>
                                        <@shiro.hasPermission name="${menu.permissionKey}">
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                        </@shiro.hasPermission>
                                        </dl></li>
                                    <#else>
                                        <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd></dl></li>
                                    </#if>
                                </#if>
                                <#if menu_index==1&&menu_index!=(menus?size-1)>
                                    <dl class="layui-nav-child">
                                    <#if menu.permissionKey?has_content>
                                        <@shiro.hasPermission name="${menu.permissionKey}">
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                        </@shiro.hasPermission>
                                    <#else>
                                        <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                    </#if>
                                </#if>
                                <#if menu_index!=1>
                                    <#if menu_index==(menus?size-1)>
                                        <#if menu.permissionKey?has_content>
                                            <@shiro.hasPermission name="${menu.permissionKey}">
                                                <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                            </@shiro.hasPermission>
                                            </dl></li>
                                        <#else>
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd></dl></li>
                                        </#if>
                                    <#else>
                                        <#if menu.permissionKey?has_content>
                                            <@shiro.hasPermission name="${menu.permissionKey}">
                                                <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                            </@shiro.hasPermission>
                                        <#else>
                                            <dd><a style="padding-left: 45px;" href="javascript:;" path="${menu.path}" url="${menu.url}">${menu.title}</a></dd>
                                        </#if>
                                    </#if>
                                </#if>
                            </#if>
                        </#list>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>

    <div class="layui-body" id="mainbody">

        <!-- 内容主体区域 -->
        <table class="layui-hide" id="test" lay-filter="test"></table>
    </div>
    <input id="handle_status" value="" hidden="hidden">

    <input id="flexStatus" value="1" hidden="hidden">
    <input id="logoStatus" value="" hidden="hidden">
    <input id="menuStatus" value="auto" hidden="hidden"/>
    <#--<div class="layui-footer">-->
        <#--&lt;!&ndash; 底部固定区域 &ndash;&gt;-->
        <#--© layui.com - 底部固定区域-->
    <#--</div>-->
</div>

     

</body>


<script src="/js/jquery.min.js"></script>
<script src="/layui/layui.js" type="text/javascript"></script>
<script src="/web/index.js" type="text/javascript"></script>
<#--<script src="/js/stock.js" type="text/javascript"></script>-->
<#--<script src="/js/role.js" type="text/javascript"></script>-->
<#--<script src="/js/product.js" type="text/javascript"></script>-->
<#--<script src="/js/permission.js" type="text/javascript"></script>-->
<#--<script src="/js/specificationDetail.js" type="text/javascript"></script>-->
<#--<script src="/js/reimburse.js" type="text/javascript"></script>-->
<#--<script src="/js/reimburseAudit.js" type="text/javascript"></script>-->
<#--<script src="/js/stockIn.js" type="text/javascript"></script>-->
<#--<script src="/js/addStockIn.js" type="text/javascript"></script>-->
<#--<script src="/js/stockOut.js" type="text/javascript"></script>-->
<#--<#include "stock/stockOut/stockOut.ftl">-->
<#--<script src="/js/addStockOut.js" type="text/javascript"></script>-->
<#--<#include "stock/stockOut/stockOutAdd.ftl">-->
<#--<script src="/js/productStock.js" type="text/javascript"></script>-->
<#--<script src="/js/searchPhone.js" type="text/javascript"></script>-->
<#--<script src="/js/user.js" type="text/javascript"></script>-->
<#--<script src="/js/addMenu.js" type="text/javascript"></script>-->
<#--<script src="/js/batchSearch.js" type="text/javascript"></script>-->
<#--<script src="/js/regNo.js" type="text/javascript"></script>-->
<#--<script src="/js/menu.js" type="text/javascript"></script>-->
<script>
</html>