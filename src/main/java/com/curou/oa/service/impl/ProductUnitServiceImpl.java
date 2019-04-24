package com.curou.oa.service.impl;

import com.curou.oa.dao.ProductUnitMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.ProductUnit;
import com.curou.oa.models.ProductUnitExample;
import com.curou.oa.service.ProductUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductUnitServiceImpl implements ProductUnitService {

    @Autowired
    ProductUnitMapper mapper;

    @Override
    public Integer add(ProductUnit productUnit) {
       return null;
    }

    @Override
    public List<ProductUnit> get(SearchBase searchBase) {

        ProductUnitExample example = new ProductUnitExample();
        ProductUnitExample.Criteria criteria = example.createCriteria();

        if(searchBase.getBeginDate()!=null){
            criteria.andCreateTimeUtcGreaterThanOrEqualTo(searchBase.getBeginDate());
        }
        if (searchBase.getEndDate()!= null) {
            criteria.andCreateTimeUtcLessThanOrEqualTo(searchBase.getEndDate());
        }
        if(searchBase.getOrderBy()!=null){
            example.setOrderByClause(searchBase.getOrderBy());
        }else{
            example.setOrderByClause("spec_create_time_utc desc");
        }
        List<ProductUnit> list = mapper.selectByExample(example);

        return list;
    }

    @Override
    public void update(List<ProductUnit> list) {

    }

    @Override
    public void delete(List<String> list) {

    }

    @Override
    public List<ProductUnit> getAll(SearchBase searchBase) {
        ProductUnitExample example = new ProductUnitExample();
        List<ProductUnit> list = mapper.selectByExample(example);
        return list;
    }
}
