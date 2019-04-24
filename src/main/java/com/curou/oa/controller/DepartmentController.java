package com.curou.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Department;
import com.curou.oa.service.DepartmentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @RequestMapping("getDepartment")
    @ResponseBody
    public TableBase<Department> get(SearchBase searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<Department> list = service.get(searchBase);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<Department> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("getAllDepartment")
    @ResponseBody
    public  List<Department> getAllDepartment(SearchBase searchBase){
        List<Department> list = service.get(searchBase);
        return list;
    }

}
