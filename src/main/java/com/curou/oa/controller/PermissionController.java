package com.curou.oa.controller;//package com.yili.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Permission;
import com.curou.oa.service.PermissionService;
import com.curou.oa.utils.Exception.AjaxException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class PermissionController {

    @Autowired
    private PermissionService service;


    @RequestMapping("/getPerms")
    @ResponseBody
    public TableBase list(SearchBase search){
        if (search==null){
            search = new SearchBase();
        }
        PageHelper.startPage(search.getPage(),search.getLimit());
        List<Permission> list = service.getList(search);
        PageInfo pageInfo = new PageInfo<>(list,search.getLimit());
        TableBase tableBase  = new TableBase();
        tableBase.setData(list);
        tableBase.setCode(0);
        tableBase.setMsg("");
        tableBase.setCount(pageInfo.getTotal());
        return tableBase;
    }

    @RequestMapping("/getAllPerms")
    @ResponseBody
    public List<Permission> getAllPerms(){
        List<Permission> list = service.getAll();
        return list;
    }

    /**
     * 添加权限
     * @return
     */
    @PostMapping("permissionAOU")
    @ResponseBody
    public Map<String,String> permissionAOU(@RequestBody Permission permission){
        Map<String, String> map = new HashMap<>();
        Boolean result = service.checkName(permission);
        if (!result){
            throw new AjaxException("该权限已存在");
        }
        result = service.checkFlag(permission);
        if (!result){
            throw new AjaxException("该权限标志已存在");
        }
        if (StringUtils.isBlank(permission.getId())) {
            service.add(permission);
        }else {
            service.update(permission);
        }
        map.put("result", "success");
        return map;

    }

    @PostMapping("/deletePerm")
    @ResponseBody
    public Map<String,String> deletePerm(@RequestBody List<String> list) {
        Map<String, String> map = new HashMap<>();
        service.del(list);
        map.put("result", "success");
        return map;
    }
}
