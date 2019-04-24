package com.curou.oa.service;

import com.curou.oa.models.CompanyInfo;

import java.util.List;

public interface CompanyInfoService {

    int add(CompanyInfo companyInfo);

    List<CompanyInfo> getByRegNoAndRegName(CompanyInfo companyInfo);

    int update(CompanyInfo companyInfo);

    List<CompanyInfo> getCompanyInfoByUploadDetailId(String uploadDetailId);

}
