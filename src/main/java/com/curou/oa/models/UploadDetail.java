package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class UploadDetail implements Serializable {
    private String id;

    private String userId;

    private Date createTimeUtc;

    private Integer effectiveCount;

    private Date modifyTimeUtc;

    private Integer count;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTimeUtc() {
        return createTimeUtc;
    }

    public void setCreateTimeUtc(Date createTimeUtc) {
        this.createTimeUtc = createTimeUtc;
    }

    public Integer getEffectiveCount() {
        return effectiveCount;
    }

    public void setEffectiveCount(Integer effectiveCount) {
        this.effectiveCount = effectiveCount;
    }

    public Date getModifyTimeUtc() {
        return modifyTimeUtc;
    }

    public void setModifyTimeUtc(Date modifyTimeUtc) {
        this.modifyTimeUtc = modifyTimeUtc;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}