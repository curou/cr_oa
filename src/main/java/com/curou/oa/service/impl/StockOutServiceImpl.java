package com.curou.oa.service.impl;//package com.yili.oa.service.impl;


import com.curou.oa.dao.StockOrderDetailMapper;
import com.curou.oa.dao.StockOrderMapper;
import com.curou.oa.dao.extend.ProductStockExtendMapper;
import com.curou.oa.entity.ProductStockSearch;
import com.curou.oa.models.*;
import com.curou.oa.models.extend.ProductStockExtend;
import com.curou.oa.service.StockOutService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/4/2 0002
 * @email 200890949@qq.com
 */
@SuppressWarnings("ALL")
@Service
@Transactional
public class StockOutServiceImpl implements StockOutService {

    @Autowired
    private ProductStockExtendMapper productStockMapper;

    @Autowired
    private StockOrderMapper stockOrderMapper;

    @Autowired
    private StockOrderDetailMapper stockOrderDetailMapper;



    @Override
    public List<ProductStockExtend> get(ProductStockSearch search) {
        List<ProductStockExtend> list = productStockMapper.selectByProductStockSearch(search);
        return list;
    }

    @Override
    public Boolean addStockOrder(String stockId,String orderId) {
        User nowUser = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
        StockOrder stockOrder = new StockOrder();
        stockOrder.setId(UUID.randomUUID().toString());
        stockOrder.setStockId(stockId);
        stockOrder.setOrderId(orderId);
        stockOrder.setCreateTimeUtc(new Date());
        stockOrder.setModifyTimeUtc(new Date());
        stockOrder.setCreateEmployeeId(nowUser.getId());
        stockOrder.setModifyEmployeeId(nowUser.getId());
        stockOrder.setType("1");
        try {
            stockOrderMapper.insert(stockOrder);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Boolean addStockOrderDeatail(ProductStock productStock, String orderId) {
        StockOrderDetail stockOrderDetail = new StockOrderDetail();
        stockOrderDetail.setId(UUID.randomUUID().toString());
        stockOrderDetail.setOrderId(orderId);
        stockOrderDetail.setCount(productStock.getCount());
        stockOrderDetail.setSpecDetail(productStock.getSpecDetail());
        stockOrderDetail.setProductId(productStock.getProductId());
        stockOrderDetail.setUnit(productStock.getUnit());
        try {
            stockOrderDetailMapper.insert(stockOrderDetail);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<StockOrder> getStockOrders(ProductStockSearch stockOutSearch) {
        StockOrderExample example = new StockOrderExample();
        StockOrderExample.Criteria criteria = example.createCriteria();
        criteria.andTypeEqualTo("1");
        if (StringUtils.isNotBlank(stockOutSearch.getOrderId())){
            criteria.andOrderIdLike("%"+stockOutSearch.getOrderId()+"%");
        }
        if (StringUtils.isNotBlank(stockOutSearch.getStockId())){
            criteria.andStockIdEqualTo(stockOutSearch.getStockId());
        }
        return stockOrderMapper.selectByExample(example);
    }
}
