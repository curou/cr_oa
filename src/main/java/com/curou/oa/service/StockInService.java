package com.curou.oa.service;

import com.curou.oa.entity.StockOrderSearch;
import com.curou.oa.entity.StockOrderWithDetail;
import com.curou.oa.models.StockOrder;

import java.util.List;

public interface StockInService {

    Integer add(StockOrder stockIn);

    List<StockOrderWithDetail> get(StockOrderSearch searchBase);

    void update(List<StockOrder> list);

    void delete(List<String> list);

    int addStockInOrder(StockOrderWithDetail stockOrderWithDetail);

}
