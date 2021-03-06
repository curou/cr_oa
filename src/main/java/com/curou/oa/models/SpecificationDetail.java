package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class SpecificationDetail implements Serializable {
    private String id;

    private String specId;

    private String value;

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

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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