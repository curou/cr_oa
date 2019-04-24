package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class Specification implements Serializable {
    private String specId;

    private Integer specDeleteStatus;

    private String specName;

    private Integer specSort;

    private String specCreateEmployeeId;

    private String specModifyEmployeeId;

    private Date specCreateTimeUtc;

    private Date specModifyTimeUtc;

    private static final long serialVersionUID = 1L;

    public String getSpecId() {
        return specId;
    }

    public void setSpecId(String specId) {
        this.specId = specId == null ? null : specId.trim();
    }

    public Integer getSpecDeleteStatus() {
        return specDeleteStatus;
    }

    public void setSpecDeleteStatus(Integer specDeleteStatus) {
        this.specDeleteStatus = specDeleteStatus;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }

    public Integer getSpecSort() {
        return specSort;
    }

    public void setSpecSort(Integer specSort) {
        this.specSort = specSort;
    }

    public String getSpecCreateEmployeeId() {
        return specCreateEmployeeId;
    }

    public void setSpecCreateEmployeeId(String specCreateEmployeeId) {
        this.specCreateEmployeeId = specCreateEmployeeId == null ? null : specCreateEmployeeId.trim();
    }

    public String getSpecModifyEmployeeId() {
        return specModifyEmployeeId;
    }

    public void setSpecModifyEmployeeId(String specModifyEmployeeId) {
        this.specModifyEmployeeId = specModifyEmployeeId == null ? null : specModifyEmployeeId.trim();
    }

    public Date getSpecCreateTimeUtc() {
        return specCreateTimeUtc;
    }

    public void setSpecCreateTimeUtc(Date specCreateTimeUtc) {
        this.specCreateTimeUtc = specCreateTimeUtc;
    }

    public Date getSpecModifyTimeUtc() {
        return specModifyTimeUtc;
    }

    public void setSpecModifyTimeUtc(Date specModifyTimeUtc) {
        this.specModifyTimeUtc = specModifyTimeUtc;
    }
}