package com.curou.oa.service;

import com.curou.oa.entity.ProductSearch;
import com.curou.oa.models.Product;

import java.util.List;

public interface ProductService {

    Integer addProduct(Product product);

    List<Product> getProduct(ProductSearch searchBase);

    void updateProduct(List<Product> list);

    void deleteProduct(List<String> list);

    Product getProById(String productId);

}
