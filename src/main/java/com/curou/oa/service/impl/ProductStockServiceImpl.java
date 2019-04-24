package com.curou.oa.service.impl;

import com.curou.oa.dao.extend.ProductStockExtendMapper;
import com.curou.oa.entity.ProductStockSearch;
import com.curou.oa.models.ProductStock;
import com.curou.oa.models.ProductStockExample;
import com.curou.oa.service.ProductStockService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductStockServiceImpl implements ProductStockService {

    @Autowired
    ProductStockExtendMapper mapper;

    @Override
    public List<ProductStock> get(ProductStockSearch searchBase) {
        ProductStockExample example = new ProductStockExample();
        ProductStockExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(searchBase.getProductId())){
            criteria.andProductIdEqualTo(searchBase.getProductId());
        }
        if(StringUtils.isNotBlank(searchBase.getSpecDetail())){
            criteria.andSpecDetailEqualTo(searchBase.getSpecDetail());
        }
        if(StringUtils.isNotBlank(searchBase.getProductId())){
            criteria.andStockIdEqualTo(searchBase.getProductId());
        }
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
        List<ProductStock> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public ProductStock getById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(ProductStock productStock) {
        try {
            mapper.updateByPrimaryKeySelective(productStock);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
