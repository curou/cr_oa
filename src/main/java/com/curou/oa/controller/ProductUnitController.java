package com.curou.oa.controller;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.ProductUnit;
import com.curou.oa.service.ProductUnitService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ProductUnitController {

    @Autowired
    ProductUnitService service;

    @RequestMapping("addProductUnit")
    @ResponseBody
    public Map<String,Object> add(@RequestBody ProductUnit productUnit){
        Map<String, Object> map = new HashMap<>();
        int result = service.add(productUnit);
        if(result==1){
            map.put("result", "success");
        }
        if(result==0){
            map.put("result", "repeatName");
        }
        return map;

    }


    @RequestMapping("getProductUnit")
    @ResponseBody
    public TableBase<ProductUnit> get(SearchBase searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<ProductUnit> list = service.get(searchBase);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<ProductUnit> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("getAllProductUnit")
    @ResponseBody
    public List<ProductUnit> getAll(SearchBase searchBase){
        return service.getAll(searchBase);
    }





}
