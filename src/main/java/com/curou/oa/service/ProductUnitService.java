package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.ProductUnit;

import java.util.List;

public interface ProductUnitService {

    Integer add(ProductUnit productUnit);

    List<ProductUnit> get(SearchBase searchBase);

    void update(List<ProductUnit> list);

    void delete(List<String> list);

    List<ProductUnit> getAll(SearchBase searchBase);
}
