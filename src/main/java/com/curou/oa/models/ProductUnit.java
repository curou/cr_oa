package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class ProductUnit implements Serializable {
    private String id;

    private String value;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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