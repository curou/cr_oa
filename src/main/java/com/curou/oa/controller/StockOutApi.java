package com.curou.oa.controller;//package com.yili.oa.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.curou.oa.entity.*;
import com.curou.oa.models.*;
import com.curou.oa.models.extend.ProductStockExtend;
import com.curou.oa.service.*;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.vo.request.StockOutReq;
import com.curou.oa.vo.response.StockOrderRes;
import com.curou.oa.vo.response.StockOutRes;
import com.curou.oa.vo.response.UserDataRes;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/4/1 0001
 * @email 200890949@qq.com
 */
@SuppressWarnings("ALL")
@Controller
@RequestMapping("/stockOut")
public class StockOutApi {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockOutService stockOutService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SpecificationService specificationService;

    @Autowired
    private SpecificationDetailService specificationDetailService;

    @Autowired
    private ProductStockService productStockService;

    @Autowired
    private StockInService stockInService;

    @Autowired
    private UserService userService;


    @RequestMapping("/addButton")
    public String addButton(ModelMap modelMap){
        List<Stock> stockList = stockService.getAllStock();
        modelMap.addAttribute("stocks",stockList);
        return "/stock/stockOut/stockOutAdd";
    }

    @GetMapping("/getStockPro")
    @ResponseBody
    public TableBase getStockPro(ModelMap modelMap, ProductStockSearch search){

        PageHelper.startPage(search.getPage(),search.getLimit());
        List<ProductStockExtend> list  = stockOutService.get(search);

        //返回的结果
        List<StockOutRes> result = new ArrayList<>();
        for (ProductStockExtend productStock:
             list) {
            StockOutRes stockOutRes = new StockOutRes();
            //返回名字
            stockOutRes.setProName(productStock.getProductName());
            Product product = productService.getProById(productStock.getProductId());
            if (product==null){
                throw new AjaxException("该产品不存在");
            }
            stockOutRes.setProName(product.getProductName());

            //返回规格
            JSONArray jsonArray = JSONArray.parseArray(productStock.getSpecDetail());
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
            stockOutRes.setProductSpec(sb.toString());
            stockOutRes.setUnit(productStock.getUnit());
            stockOutRes.setCount(productStock.getCount());
            stockOutRes.setId(productStock.getId());
            stockOutRes.setStockName(productStock.getStockName());
            result.add(stockOutRes);
        }
        PageInfo pageInfo = new PageInfo<>(list,search.getLimit());
        TableBase tableBase = new TableBase();
        tableBase.setData(result);
        tableBase.setMsg("success");
        tableBase.setCount(pageInfo.getTotal());
        tableBase.setCode(0);
        return tableBase;
    }


    @PostMapping("/add")
    @ResponseBody
    public Map addStockOut(ModelMap modelMap, @RequestBody List<StockOutReq> list){
        String stockId = null;

        //获取时间格式
        Date date = new Date();
        long times = date.getTime();//时间戳
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderId = formatter.format(date);
        for (StockOutReq stockOutReq:
             list) {
            if (stockOutReq.getCount()==0){
                continue;
            }
            ProductStock productStock = productStockService.getById(stockOutReq.getId());
            if (stockId==null){
                stockId = productStock.getStockId();
            }
            if (productStock==null){
                throw new AjaxException("出现错误,请重试");
            }
            //更新库存信息
            String productStockId = productStock.getId();
            Long lastCount = productStock.getCount()-stockOutReq.getCount();
            ProductStock updProductStock = new ProductStock();
            updProductStock.setId(productStockId);
            updProductStock.setCount(lastCount);
            productStockService.update(updProductStock);
            //添加出库明细
            productStock.setCount(stockOutReq.getCount());
            stockOutService.addStockOrderDeatail(productStock,orderId);
        }
        Boolean result = stockOutService.addStockOrder(stockId,orderId);
        if (!result){
            throw new AjaxException("出现错误 请重试");
        }
        Map map = new HashMap();
        map.put("result","success");
        return map;
    }

    @RequestMapping("/getList")
    @ResponseBody
    public TableBase<StockOrderRes> getStockIn(StockOrderSearch searchBase){
        PageHelper.startPage(searchBase.getPage(),searchBase.getLimit());
        List<StockOrderWithDetail> list = stockInService.get(searchBase);
        List<StockOrderRes> resList = new ArrayList<>();
        PageInfo pageInfo = new PageInfo<>(list,searchBase.getLimit());
        for (StockOrderWithDetail StockOrderWithDetail : list) {
            List<StockOrderDetail> temp = StockOrderWithDetail.getList();
            String userName = null;
            for (StockOrderDetail stockOrderDetail : temp) {
                if (userName==null){
                    UserDataRes user = userService.getById(StockOrderWithDetail.getCreateEmployeeId());
                    userName = user.getName();
                }
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
                stockOrderRes.setCount(stockOrderDetail.getCount());
                stockOrderRes.setUnit(stockOrderDetail.getUnit());
                stockOrderRes.setCreateUser(userName);
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
}
