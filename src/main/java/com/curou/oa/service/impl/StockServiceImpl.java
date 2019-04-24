package com.curou.oa.service.impl;

import com.curou.oa.dao.extend.StockExtendMapper;
import com.curou.oa.entity.StockSearch;
import com.curou.oa.models.Stock;
import com.curou.oa.models.StockExample;
import com.curou.oa.service.StockService;
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
public class StockServiceImpl implements StockService {

    @Autowired
    StockExtendMapper stockMapper;

    public Integer addStock(Stock stock){
        StockExample stockExample = new StockExample();
        StockExample.Criteria criteria = stockExample.createCriteria();
        criteria.andStockNameEqualTo(stock.getStockName());
        List<Stock> list = stockMapper.selectByExample(stockExample);
        if(ListUtils.isNotNullOrEmpty(list)){
            return 0;
        }
        String id = UUID.randomUUID().toString();
        stock.setStockId(id);
        stock.setStockCreateTimeUtc(new Date());
        stock.setStockModifyTimeUtc(new Date());
        stock.setStockDeleteStatus(0);
        int insert = stockMapper.insert(stock);
        return insert;
    }

    public List<Stock> getStock(StockSearch searchBase){

        StockExample stockExample = new StockExample();
        StockExample.Criteria criteria = stockExample.createCriteria();
        if(StringUtils.isNotBlank(searchBase.getId())){
            criteria.andStockIdEqualTo(searchBase.getId());
        }
        if(searchBase.getStatus()!=null){
            criteria.andStockStatusEqualTo(searchBase.getStatus());
        }
        if(searchBase.getBeginDate()!=null){
            criteria.andStockCreateTimeUtcGreaterThanOrEqualTo(searchBase.getBeginDate());
        }
        if (searchBase.getEndDate()!= null) {
            criteria.andStockCreateTimeUtcLessThanOrEqualTo(searchBase.getEndDate());
        }
        if(searchBase.getKeyword()!=null){
            criteria.andStockNameLike("%"+searchBase.getKeyword()+"%");
        }
        if(searchBase.getOrderBy()!=null){
            stockExample.setOrderByClause(searchBase.getOrderBy());
        }else{
            stockExample.setOrderByClause("stock_create_time_utc desc");
        }
        List<Stock> list = stockMapper.selectByExample(stockExample);

        return list;
    }

    public void updateStock(List<Stock> list){
        for (Stock stock : list) {
            stockMapper.updateByPrimaryKeySelective(stock);
        }

    }

    public void deleteStock(List<String> list) {
        for (String str : list) {
            stockMapper.deleteByPrimaryKey(str);
        }
    }

    @Override
    public List<Stock> getAllStock() {

        return stockMapper.selectAllStock();
    }
}
