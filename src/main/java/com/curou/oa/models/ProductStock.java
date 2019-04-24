package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class ProductStock implements Serializable {
    private String id;

    private String productId;

    private String stockId;

    private String specDetail;

    private String unit;

    private Long count;

    private Date createTimeUtc;

    private Date modifyTimeUtc;

    private String createEmployeeId;

    private String modifyEmployeeId;

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

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getSpecDetail() {
        return specDetail;
    }

    public void setSpecDetail(String specDetail) {
        this.specDetail = specDetail == null ? null : specDetail.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Date getCreateTimeUtc() {
        return createTimeUtc;
    }

    public void setCreateTimeUtc(Date createTimeUtc) {
        this.createTimeUtc = createTimeUtc;
    }

    public Date getModifyTimeUtc() {
        return modifyTimeUtc;
    }

    public void setModifyTimeUtc(Date modifyTimeUtc) {
        this.modifyTimeUtc = modifyTimeUtc;
    }

    public String getCreateEmployeeId() {
        return createEmployeeId;
    }

    public void setCreateEmployeeId(String createEmployeeId) {
        this.createEmployeeId = createEmployeeId == null ? null : createEmployeeId.trim();
    }

    public String getModifyEmployeeId() {
        return modifyEmployeeId;
    }

    public void setModifyEmployeeId(String modifyEmployeeId) {
        this.modifyEmployeeId = modifyEmployeeId == null ? null : modifyEmployeeId.trim();
    }
}