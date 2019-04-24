package com.curou.oa.service;

import com.curou.oa.entity.ProductStockSearch;
import com.curou.oa.models.ProductStock;
import com.curou.oa.models.StockOrder;
import com.curou.oa.models.extend.ProductStockExtend;

import java.util.List;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/4/1 0001
 * @email 200890949@qq.com
 */
public interface StockOutService {

    List<ProductStockExtend> get(ProductStockSearch search);

//    List<ProductStockExtend> getProByKeyword(String keyword,String outStockId);

    Boolean addStockOrder(String stockId, String orderId);

    Boolean addStockOrderDeatail(ProductStock productStock, String orderId);

    List<StockOrder> getStockOrders(ProductStockSearch stockOutSearch);
}
