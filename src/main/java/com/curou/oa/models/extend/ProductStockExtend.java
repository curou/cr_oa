package com.curou.oa.models.extend;

import com.curou.oa.models.ProductStock;

public class ProductStockExtend extends ProductStock {

    private String productName;


    private String stockName;

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }


    public String getProductName() {
        return productName;
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }
}
