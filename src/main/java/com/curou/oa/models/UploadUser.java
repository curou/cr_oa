package com.curou.oa.models;

import java.io.Serializable;

public class UploadUser implements Serializable {
    private String id;

    private String companyInfoId;

    private String uploadDetailId;

    private Integer sort;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyInfoId() {
        return companyInfoId;
    }

    public void setCompanyInfoId(String companyInfoId) {
        this.companyInfoId = companyInfoId == null ? null : companyInfoId.trim();
    }

    public String getUploadDetailId() {
        return uploadDetailId;
    }

    public void setUploadDetailId(String uploadDetailId) {
        this.uploadDetailId = uploadDetailId == null ? null : uploadDetailId.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}