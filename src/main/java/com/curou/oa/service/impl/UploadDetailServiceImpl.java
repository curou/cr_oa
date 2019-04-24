package com.curou.oa.service.impl;

import com.curou.oa.dao.UploadDetailMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.UploadDetail;
import com.curou.oa.models.UploadDetailExample;
import com.curou.oa.service.UploadDetailService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UploadDetailServiceImpl implements UploadDetailService {

    @Autowired
    UploadDetailMapper mapper;

    @Override
    public int add(UploadDetail uploadDetail) {
        return mapper.insert(uploadDetail);
    }

    @Override
    public List<UploadDetail> list(SearchBase searchBase) {
        UploadDetailExample example = new UploadDetailExample();
        UploadDetailExample.Criteria criteria = example.createCriteria();
        if(searchBase.getBeginDate()!=null){
            criteria.andCreateTimeUtcGreaterThanOrEqualTo(searchBase.getBeginDate());
        }
        if (searchBase.getEndDate()!= null) {
            criteria.andCreateTimeUtcLessThanOrEqualTo(searchBase.getEndDate());
        }
        if(searchBase.getOrderBy()!=null){
            example.setOrderByClause(searchBase.getOrderBy());
        }else{
            example.setOrderByClause("create_time_utc desc");
        }
        List<UploadDetail> list = mapper.selectByExample(example);

        return list;

    }
}
