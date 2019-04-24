package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class LmRegistrationCode implements Serializable {
    private String id;

    private Integer cardType;

    private Integer status;

    private Date expirationTime;

    private String remark;

    private String code;

    private Integer proType;

    private Integer activationTime;

    private String deviceNo;

    private Date createTimeUtc;

    private Date modifyTimeUtc;

    private Integer onlineStatus;

    private Integer count;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getProType() {
        return proType;
    }

    public void setProType(Integer proType) {
        this.proType = proType;
    }

    public Integer getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Integer activationTime) {
        this.activationTime = activationTime;
    }

    public String getDeviceNo() {
        return deviceNo;
    }

    public void setDeviceNo(String deviceNo) {
        this.deviceNo = deviceNo == null ? null : deviceNo.trim();
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

    public Integer getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Integer onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}