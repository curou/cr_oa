package com.curou.oa.controller;//package com.yili.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Role;
import com.curou.oa.service.RoleService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.vo.request.RoleDataReq;
import com.curou.oa.vo.response.RoleDataRes;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class RoleController {


    @Autowired
    private RoleService service;

    @RequestMapping("getAllRoles")
    @ResponseBody
    public List<Role> getAllRoles(SearchBase searchBase) {
        return service.getAll(searchBase);
    }

    @RequestMapping("getRoles")
    @ResponseBody
    public TableBase<RoleDataRes> getRoles(SearchBase searchBase) {
        PageHelper.startPage(searchBase.getPage(), searchBase.getLimit());
        List<RoleDataRes> list = service.getAllWithPerm(searchBase);
        PageInfo pageInfo = new PageInfo<>(list, searchBase.getLimit());
        TableBase<RoleDataRes> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("roleAOU")
    @ResponseBody
    public Map<String, String> roleAOU(@RequestBody RoleDataReq dataRes) {
        Map<String, String> map = new HashMap<>();
        Boolean result = service.checkName(dataRes);
        if (!result){
            throw new AjaxException("该角色已存在");
        }
        if (StringUtils.isBlank(dataRes.getId())) {
            service.add(dataRes);
        }else {
            service.update(dataRes);
        }
        map.put("result", "success");
        return map;
    }

    @PostMapping("/deleteRole")
    @ResponseBody
    public Map<String,String> deleteRole(@RequestBody List<String> list) {
        Map<String, String> map = new HashMap<>();
        service.del(list);
        map.put("result", "success");
        return map;
    }
}
