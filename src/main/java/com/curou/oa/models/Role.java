package com.curou.oa.models;

import java.io.Serializable;
import java.util.Date;

public class Role implements Serializable {
    private String id;

    private String name;

    private String code;

    private Date createTimeUtc;

    private Date modifyTimeUtc;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
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