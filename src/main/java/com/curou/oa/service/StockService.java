package com.curou.oa.service;

import com.curou.oa.entity.StockSearch;
import com.curou.oa.models.Stock;

import java.util.List;

public interface StockService {

    Integer addStock(Stock stock);

    List<Stock> getStock(StockSearch searchBase);

    void updateStock(List<Stock> list);

    void deleteStock(List<String> list);

    List<Stock> getAllStock();

}
