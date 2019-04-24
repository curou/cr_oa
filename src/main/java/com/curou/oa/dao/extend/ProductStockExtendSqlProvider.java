package com.curou.oa.dao.extend;

import com.curou.oa.entity.ProductStockSearch;
import org.apache.commons.lang3.StringUtils;


public class ProductStockExtendSqlProvider {

    public String selectByProductStockSearch(ProductStockSearch search){
        StringBuffer sb = new StringBuffer();
        String sql = "SELECT a.*,b.product_name,c.stock_name from product_stock as a join product as b  on a.product_id=b.product_id ";
        sb.append(sql);
        if(search.getBeginDate()!=null){
            sb.append(" and a.modify_time_utc>='"+search.getBeginStr()+"'");
        }
        if(search.getEndDate()!=null){
            sb.append(" and a.modify_time_utc<='"+search.getEndStr()+"'");
        }
        if(StringUtils.isNotBlank(search.getProductName())){
            sb.append(" and b.product_name like '%"+search.getProductName()+"%'");
        }

        sb.append(" join stock as c on a.stock_id=c.stock_id");
        if(StringUtils.isNotBlank(search.getStockId())){
            sb.append(" and c.stock_id = '"+search.getStockId()+"'");
        }
        if(StringUtils.isNotBlank(search.getOrderBy())){
            sb.append(" order by "+search.getOrderBy());
        }else{
            sb.append(" order by a.modify_time_utc desc");
        }

        return sb.toString();
    }
}
