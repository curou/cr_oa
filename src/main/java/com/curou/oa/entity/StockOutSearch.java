package com.curou.oa.entity;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/4/2 0002
 * @email 200890949@qq.com
 */
public class StockOutSearch extends SearchBase {

    private String outStockId;

    public String getOutStockId() {
        return outStockId;
    }

    public void setOutStockId(String outStockId) {
        this.outStockId = outStockId;
    }
}
