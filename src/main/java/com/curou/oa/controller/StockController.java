package com.curou.oa.controller;

import com.curou.oa.entity.StockSearch;
import com.curou.oa.entity.TableBase;
import com.curou.oa.models.Stock;
import com.curou.oa.service.StockService;
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
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping("addStock")
    @ResponseBody
    public Map<String,Object> addStock(@RequestBody Stock stock){
        Map<String, Object> map = new HashMap<>();
        int result = stockService.addStock(stock);
        if(result==1){
            map.put("result", "success");
        }
        if(result==0){
            map.put("result", "repeatName");
        }
        return map;

    }
    @RequestMapping("stockAddTemp")
    public String stockAddTemp(){
        return "stockAddTemp";
    }


    @RequestMapping("getStock")
    @ResponseBody
    public TableBase<Stock> getStock(StockSearch searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<Stock> list = stockService.getStock(searchBase);
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        TableBase<Stock> table = new TableBase<>();
        table.setCode(0);
        table.setData(list);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("updateStock")
    @ResponseBody
    public Map<String,Object> updateStock(@RequestBody List<Stock> list){
        Map<String, Object> map = new HashMap<>();
        stockService.updateStock(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("deleteStock")
    @ResponseBody
    public Map<String,Object> deleteStock(@RequestBody List<String> list){
        Map<String, Object> map = new HashMap<>();
        stockService.deleteStock(list);
        map.put("result", "success");
        return map;
    }

    @RequestMapping("getAllStock")
    @ResponseBody
    public List<Stock> getAllStock(){
        List<Stock> list = stockService.getAllStock();
        return list;
    }









}
