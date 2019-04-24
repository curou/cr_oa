package com.curou.oa.dao.extend;

import com.curou.oa.entity.StockOrderSearch;
import org.apache.commons.lang3.StringUtils;

public class StockExtendSqlProvider {

    public String selectByStockSearch(StockOrderSearch searchBase){
        StringBuffer sb = new StringBuffer();
        String sql = "select id,type,order_id,stock_id,create_employee_id,modify_employee_id, create_time_utc,modify_time_utc from stock_order where 1 = 1 ";
        sb.append(sql);
        if(searchBase.getType()!=null){
            sb.append(" and type=" + searchBase.getType());
        }
        if(searchBase.getBeginDate()!=null){
            sb.append(" and create_time_utc>='" + searchBase.getBeginStr()+"'");
        }
        if (searchBase.getEndDate()!= null) {
            sb.append(" and create_time_utc<='" + searchBase.getEndStr()+"'");
        }
        if(StringUtils.isNotEmpty(searchBase.getStockId())){
            sb.append(" and stock_id ='" + searchBase.getStockId()+"'");
        }
        if(StringUtils.isNotEmpty(searchBase.getOrderId())){
            sb.append(" and order_id like CONCAT('%',"+searchBase.getOrderId()+",'%')" );
        }
        if(StringUtils.isNotEmpty(searchBase.getOrderBy())){
            sb.append(" order by" + searchBase.getOrderBy()+" desc");
        }else{
            sb.append(" order by create_time_utc desc");

        }
        return sb.toString();
    }
}
