package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class StockOrder implements Serializable {
    private String id;

    private String type;

    private String orderId;

    private String stockId;

    private String createEmployeeId;

    private String modifyEmployeeId;

    private Date createTimeUtc;

    private Date modifyTimeUtc;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
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
}