package com.curou.oa.service.impl;

import com.curou.oa.dao.ProductMapper;
import com.curou.oa.entity.ProductSearch;
import com.curou.oa.models.Product;
import com.curou.oa.models.ProductExample;
import com.curou.oa.service.ProductService;
import com.curou.oa.utils.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;

    @Override
    public Integer addProduct(Product product) {
        ProductExample ProductExample = new ProductExample();
        com.curou.oa.models.ProductExample.Criteria criteria = ProductExample.createCriteria();
        criteria.andProductNameEqualTo(product.getProductName());
        List<Product> list = productMapper.selectByExample(ProductExample);
        if(ListUtils.isNotNullOrEmpty(list)){
            return 0;
        }
        String id = UUID.randomUUID().toString();
        product.setProductId(id);
        product.setProductCreateTimeUtc(new Date());
        product.setProductModifyTimeUtc(new Date());
        product.setProductDeleteStatus("0");
        int insert = productMapper.insert(product);
        return insert;
    }

    @Override
    public List<Product> getProduct(ProductSearch searchBase) {

        ProductExample productExample = new ProductExample();
        ProductExample.Criteria criteria = productExample.createCriteria();
        if(StringUtils.isNotBlank(searchBase.getId())){
            criteria.andProductIdEqualTo(searchBase.getId());
        }
        if(StringUtils.isNotBlank(searchBase.getProductStatus())){
            criteria.andProductStatusEqualTo(searchBase.getProductStatus());
        }
        if(StringUtils.isNotBlank(searchBase.getProductNumber())){
            criteria.andProductNumberLike("%"+searchBase.getProductNumber()+"%");
        }
        if(searchBase.getBeginDate()!=null){
            criteria.andProductCreateTimeUtcGreaterThanOrEqualTo(searchBase.getBeginDate());
        }
        if (searchBase.getEndDate()!= null) {
            criteria.andProductCreateTimeUtcLessThanOrEqualTo(searchBase.getEndDate());
        }
        if(StringUtils.isNotBlank(searchBase.getKeyword())){
            criteria.andProductNameLike("%"+searchBase.getKeyword()+"%");
        }
        if(StringUtils.isNotBlank(searchBase.getOrderBy())){
            productExample.setOrderByClause(searchBase.getOrderBy());
        }else{
            productExample.setOrderByClause("product_create_time_utc desc");
        }
        List<Product> list = productMapper.selectByExample(productExample);

        return list;
    }

    @Override
    public void updateProduct(List<Product> list) {
        for (Product product : list) {
            productMapper.updateByPrimaryKeySelective(product);
        }
    }

    @Override
    public void deleteProduct(List<String> list) {
        for (String str : list) {
            productMapper.deleteByPrimaryKey(str);
        }
    }

    @Override
    public Product getProById(String productId) {
        Product product = productMapper.selectByPrimaryKey(productId);
        return product;
    }
}
