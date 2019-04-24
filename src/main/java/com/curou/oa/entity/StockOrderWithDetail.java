package com.curou.oa.entity;

import com.curou.oa.models.StockOrder;
import com.curou.oa.models.StockOrderDetail;

import java.util.List;

public class StockOrderWithDetail extends StockOrder {

    private List<StockOrderDetail> list;

    public List<StockOrderDetail> getList() {
        return list;
    }

    public void setList(List<StockOrderDetail> list) {
        this.list = list;
    }
}
