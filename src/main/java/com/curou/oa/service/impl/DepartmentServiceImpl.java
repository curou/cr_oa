package com.curou.oa.service.impl;

import com.curou.oa.dao.DepartmentMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Department;
import com.curou.oa.models.DepartmentExample;
import com.curou.oa.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentMapper mapper;

    @Override
    public List<Department> get(SearchBase searchBase) {
        DepartmentExample example = new DepartmentExample();
        DepartmentExample.Criteria criteria = example.createCriteria();
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
        List<Department> list = mapper.selectByExample(example);
        return list;
    }
}
