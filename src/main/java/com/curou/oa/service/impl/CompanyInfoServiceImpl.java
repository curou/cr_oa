package com.curou.oa.service.impl;


import com.curou.oa.dao.CompanyInfoMapper;
import com.curou.oa.dao.extend.CompanyInfoExtendMapper;
import com.curou.oa.models.CompanyInfo;
import com.curou.oa.models.CompanyInfoExample;
import com.curou.oa.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyInfoServiceImpl implements CompanyInfoService {
    @Autowired
    CompanyInfoExtendMapper mapper;

    @Override
    public int update(CompanyInfo companyInfo) {

        return mapper.updateByPrimaryKey(companyInfo);
    }

    @Override
    public List<CompanyInfo> getCompanyInfoByUploadDetailId(String uploadDetailId) {
        return mapper.getCompanyInfoByUploadDetailId(uploadDetailId);
    }

    @Override
    public List<CompanyInfo> getByRegNoAndRegName(CompanyInfo companyInfo) {
        CompanyInfoExample example = new CompanyInfoExample();
        CompanyInfoExample.Criteria criteria = example.createCriteria();
        criteria.andRegNameEqualTo(companyInfo.getRegName());
        criteria.andRegNoEqualTo(companyInfo.getRegNo());
        return mapper.selectByExample(example);
    }



    @Override
    public int add(CompanyInfo companyInfo) {
        return mapper.insert(companyInfo);
    }
}
