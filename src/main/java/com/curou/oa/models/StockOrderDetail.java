package com.curou.oa.models;

import java.io.Serializable;

public class StockOrderDetail implements Serializable {
    private String id;

    private String productId;

    private String specDetail;

    private String orderId;

    private Long count;

    private String unit;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getSpecDetail() {
        return specDetail;
    }

    public void setSpecDetail(String specDetail) {
        this.specDetail = specDetail == null ? null : specDetail.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}