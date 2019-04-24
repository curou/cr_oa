package com.curou.oa.dao.extend;

import com.curou.oa.dao.StockMapper;
import com.curou.oa.entity.StockOrderSearch;
import com.curou.oa.entity.StockOrderWithDetail;
import com.curou.oa.models.Stock;
import com.curou.oa.models.StockOrderDetail;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface StockExtendMapper extends StockMapper {

    @Select({
            "select",
            "stock_id, stock_name ",
            "from stock",
            "where stock_status = 0"
    })
    @Results({
            @Result(column="stock_id", property="stockId", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="stock_name", property="stockName", jdbcType=JdbcType.VARCHAR),
    })
    List<Stock> selectAllStock();

    @SelectProvider(type= StockExtendSqlProvider.class, method="selectByStockSearch")
    @Results({
            @Result(id=true,column="id",property="id"),
            @Result(column="stock_id",property="stockId"),
            @Result(column="type",property="type"),
            @Result(column="order_id",property="orderId"),
            @Result(column="create_time_utc",property="createTimeUtc"),
            @Result(column="modify_time_utc",property="modifyTimeUtc"),
            @Result(column="create_employee_id",property="createEmployeeId"),
            @Result(column="modify_employee_id",property="modifyEmployeeId"),
            @Result(column="order_id",property="list",
                    many=@Many(
                            select="com.curou.oa.dao.extend.StockExtendMapper.selectByOrderId",
                            fetchType= FetchType.LAZY))
    })
    List<StockOrderWithDetail> selectByStockOrderSearch(StockOrderSearch searchBase);

    @Select({
            "select",
            "id, product_id, spec_detail, order_id, count, unit",
            "from stock_order_detail",
            "where order_id = #{orderId,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
            @Result(column="spec_detail", property="specDetail", jdbcType=JdbcType.VARCHAR),
            @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
            @Result(column="count", property="count", jdbcType=JdbcType.BIGINT),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR)
    })
    List<StockOrderDetail> selectByOrderId(String orderId);
}
