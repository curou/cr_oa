package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class Stock implements Serializable {
    private String stockId;

    private String stockName;

    private Integer stockStatus;

    private Integer stockDeleteStatus;

    private Date stockCreateTimeUtc;

    private Date stockModifyTimeUtc;

    private String stockCreateEmployeeId;

    private String stockModifyEmployeeId;

    private static final long serialVersionUID = 1L;

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId == null ? null : stockId.trim();
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName == null ? null : stockName.trim();
    }

    public Integer getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Integer stockStatus) {
        this.stockStatus = stockStatus;
    }

    public Integer getStockDeleteStatus() {
        return stockDeleteStatus;
    }

    public void setStockDeleteStatus(Integer stockDeleteStatus) {
        this.stockDeleteStatus = stockDeleteStatus;
    }

    public Date getStockCreateTimeUtc() {
        return stockCreateTimeUtc;
    }

    public void setStockCreateTimeUtc(Date stockCreateTimeUtc) {
        this.stockCreateTimeUtc = stockCreateTimeUtc;
    }

    public Date getStockModifyTimeUtc() {
        return stockModifyTimeUtc;
    }

    public void setStockModifyTimeUtc(Date stockModifyTimeUtc) {
        this.stockModifyTimeUtc = stockModifyTimeUtc;
    }

    public String getStockCreateEmployeeId() {
        return stockCreateEmployeeId;
    }

    public void setStockCreateEmployeeId(String stockCreateEmployeeId) {
        this.stockCreateEmployeeId = stockCreateEmployeeId == null ? null : stockCreateEmployeeId.trim();
    }

    public String getStockModifyEmployeeId() {
        return stockModifyEmployeeId;
    }

    public void setStockModifyEmployeeId(String stockModifyEmployeeId) {
        this.stockModifyEmployeeId = stockModifyEmployeeId == null ? null : stockModifyEmployeeId.trim();
    }
}