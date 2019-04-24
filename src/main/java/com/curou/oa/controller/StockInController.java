package com.curou.oa.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.curou.oa.entity.*;
import com.curou.oa.models.*;
import com.curou.oa.service.*;
import com.curou.oa.vo.response.StockOrderRes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class StockInController {

    @Autowired
    StockInService service;

    @Autowired
    ProductService productService;

    @Autowired
    StockService stockService;

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private SpecificationDetailService specificationDetailService;



//    @RequestMapping("addStockIn")
//    @ResponseBody
//    public Map<String,Object> addStockIn(@RequestBody StockIn stockIn){
//        Map<String, Object> map = new HashMap<>();
//        int result = service.add(stockIn);
//        if(result==1){
//            map.put("result", "success");
//        }
//        if(result==0){
//            map.put("result", "repeatName");
//        }
//        return map;
//
//    }


    @RequestMapping("getStockIn")
    @ResponseBody
    public TableBase<StockOrderRes> getStockIn(StockOrderSearch searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<StockOrderWithDetail> list = service.get(searchBase);
        List<StockOrderRes> resList = new ArrayList<>();
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        for (com.curou.oa.entity.StockOrderWithDetail StockOrderWithDetail : list) {
            List<StockOrderDetail> temp = StockOrderWithDetail.getList();
            for (StockOrderDetail stockOrderDetail : temp) {
                StockOrderRes stockOrderRes = new StockOrderRes();
                stockOrderRes.setProductId(stockOrderDetail.getProductId());
                //通过产品id查产品名
                ProductSearch productSearch = new ProductSearch();
                productSearch.setId(stockOrderDetail.getProductId());
                List<Product> product = productService.getProduct(productSearch);
                stockOrderRes.setProductName(product.get(0).getProductName());

                //查询规格
                JSONArray jsonArray = JSONArray.parseArray(stockOrderDetail.getSpecDetail());
                StringBuffer sb = new StringBuffer();
                for (int i = 0; i <jsonArray.size() ; i++) {
                    JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                    Iterator<String> sIterator = jsonObject.keySet().iterator();
                    while (sIterator.hasNext()) {
                        // 获得key
                        String key = sIterator.next();
                        Specification specification= specificationService.getById(key);
                        if (specification!=null){
                            if (StringUtils.isNotBlank(sb.toString())){
                                sb.append(","+specification.getSpecName());
                            }else {
                                sb.append(specification.getSpecName());
                            }
                        }
                        String specDetailId= jsonObject.getString(key);
                        SpecificationDetail specificationDetail = specificationDetailService.getById(specDetailId);
                        if (specificationDetail!=null){
                            if (StringUtils.isNotBlank(sb.toString())){
                                sb.append(":"+specificationDetail.getValue());
                            }else{
                                sb.append(specificationDetail.getValue());
                            }
                        }
                    }
                }
                stockOrderRes.setSpecDetail(sb.toString());

                //通过仓库id查仓库名
                stockOrderRes.setStockId(StockOrderWithDetail.getStockId());
                StockSearch stockSearch = new StockSearch();
                stockSearch.setId(StockOrderWithDetail.getStockId());
                List<Stock> stock = stockService.getStock(stockSearch);
                stockOrderRes.setStockName(stock.get(0).getStockName());




                stockOrderRes.setCount(stockOrderDetail.getCount());
                stockOrderRes.setUnit(stockOrderDetail.getUnit());
                stockOrderRes.setId(StockOrderWithDetail.getId());
                stockOrderRes.setOrderId(StockOrderWithDetail.getOrderId());
                stockOrderRes.setCreateTimeUtc(StockOrderWithDetail.getCreateTimeUtc());
                resList.add(stockOrderRes);
            }

        }
        TableBase<StockOrderRes> table = new TableBase<>();
        table.setCode(0);
        table.setData(resList);
        table.setMsg("");
        table.setCount(pageInfo.getTotal());
        return table;
    }

    @RequestMapping("addStockInOrder")
    @ResponseBody
    public Map<String,Object> addStockInOrder(@RequestBody StockOrderWithDetail stockOrderExtend){
        int result = service.addStockInOrder(stockOrderExtend);
        Map<String, Object> map = new HashMap<>();
         map.put("result", "success");
         return map;
    }


}
