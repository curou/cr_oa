package com.curou.oa.controller;

import com.curou.oa.entity.ProductSearch;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Product;
import com.curou.oa.service.ProductService;
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
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("addProduct")
    @ResponseBody
    public Map<String,Object> addProduct(@RequestBody Product product){
        Map<String, Object> map = new HashMap<>();
        int result = productService.addProduct(product);
        if(result==1){
            map.put("result", "success");
        }
        if(result==0){
            map.put("result", "repeatName");
        }
        return map;

    }


    @RequestMapping("getProduct")
    @ResponseBody
    public TableBase<Product> getProduct(ProductSearch searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<Product> list = productService.getProduct(searchBase);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<Product> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("updateProduct")
    @ResponseBody
    public Map<String,Object> updateProduct(@RequestBody List<Product> list){
        Map<String, Object> map = new HashMap<>();
        productService.updateProduct(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("deleteProduct")
    @ResponseBody
    public Map<String,Object> deleteProduct(@RequestBody List<String> list){
        Map<String, Object> map = new HashMap<>();
        productService.deleteProduct(list);
        map.put("result", "success");
        return map;
    }







}
