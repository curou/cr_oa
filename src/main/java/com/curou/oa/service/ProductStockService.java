package com.curou.oa.service;

import com.curou.oa.entity.ProductStockSearch;
import com.curou.oa.models.ProductStock;

import java.util.List;

public interface ProductStockService {

    List<ProductStock> get(ProductStockSearch searchBase);

    ProductStock getById(String id);

    Boolean update(ProductStock productStock);
}
