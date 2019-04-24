package com.curou.oa.service.impl;

import com.curou.oa.dao.ProductStockMapper;
import com.curou.oa.dao.StockOrderDetailMapper;
import com.curou.oa.dao.StockOrderMapper;
import com.curou.oa.dao.extend.StockExtendMapper;
import com.curou.oa.entity.ProductStockSearch;
import com.curou.oa.entity.StockOrderSearch;
import com.curou.oa.entity.StockOrderWithDetail;
import com.curou.oa.models.ProductStock;
import com.curou.oa.models.StockOrder;
import com.curou.oa.models.StockOrderDetail;
import com.curou.oa.service.ProductStockService;
import com.curou.oa.service.StockInService;
import com.curou.oa.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class StockInServiceImpl implements StockInService {

    @Autowired
    StockOrderMapper mapper;

    @Autowired
    StockExtendMapper stockExtendMapper;

    @Autowired
    StockOrderDetailMapper detailMapper;

    @Autowired
    ProductStockService productStockService;

    @Autowired
    ProductStockMapper productStockMapper;

    @Override
    public Integer add(StockOrder stockIn) {
        String id = UUID.randomUUID().toString();

        stockIn.setId(id);
        stockIn.setCreateTimeUtc(new Date());
        stockIn.setModifyTimeUtc(new Date());
        int insert = mapper.insert(stockIn);
        return insert;
    }

    @Override
    public List<StockOrderWithDetail> get(StockOrderSearch searchBase) {
        List<StockOrderWithDetail> list = stockExtendMapper.selectByStockOrderSearch(searchBase);
        return list;
    }

    @Override
    public void update(List<StockOrder> list) {

    }

    @Override
    public void delete(List<String> list) {

    }

    public int addStockInOrder(StockOrderWithDetail stockOrderWithDetail){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String orderId = sdf.format(new Date());       //将Date类型转换成String类型
        String id = UUID.randomUUID().toString();
        stockOrderWithDetail.setId(id);
        stockOrderWithDetail.setOrderId(orderId);
        stockOrderWithDetail.setType("0");
        stockOrderWithDetail.setCreateTimeUtc(new Date());
        stockOrderWithDetail.setModifyTimeUtc(new Date());
        List<StockOrderDetail> list = stockOrderWithDetail.getList();

        for (StockOrderDetail stockOrderDetail : list) {
            String sonId = UUID.randomUUID().toString();
            stockOrderDetail.setId(sonId);
            stockOrderDetail.setOrderId(orderId);
            ProductStockSearch searchBase = new ProductStockSearch();
            searchBase.setId(stockOrderWithDetail.getStockId());
            searchBase.setSpecDetail(stockOrderDetail.getSpecDetail());
            searchBase.setProductId(stockOrderDetail.getProductId());
            List<ProductStock> productStockList = productStockService.get(searchBase);
            if(ListUtils.isNotNullOrEmpty(productStockList)){
                ProductStock productStock = productStockList.get(0);
                productStock.setCount(productStock.getCount()+stockOrderDetail.getCount());
                productStock.setModifyTimeUtc(new Date());
                productStockMapper.updateByPrimaryKeySelective(productStock);
            }else{
                ProductStock productStock = new ProductStock();
                productStock.setCount(stockOrderDetail.getCount());
                productStock.setId(UUID.randomUUID().toString());
                productStock.setProductId(stockOrderDetail.getProductId());
                productStock.setSpecDetail(stockOrderDetail.getSpecDetail());
                productStock.setStockId(stockOrderWithDetail.getStockId());
                productStock.setUnit(stockOrderDetail.getUnit());
                productStock.setCreateTimeUtc(new Date());
                productStock.setModifyTimeUtc(new Date());
                productStockMapper.insert(productStock);

            }
            detailMapper.insert(stockOrderDetail);

        }
        int result = mapper.insert(stockOrderWithDetail);

        return result;

    }
}
