package com.curou.oa.dao.extend;

import com.curou.oa.dao.ProductStockMapper;
import com.curou.oa.entity.ProductStockSearch;
import com.curou.oa.models.extend.ProductStockExtend;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface ProductStockExtendMapper extends ProductStockMapper {

    @SelectProvider(type= ProductStockExtendSqlProvider.class, method="selectByProductStockSearch")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
            @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
            @Result(column="stock_name", property="stockName", jdbcType=JdbcType.VARCHAR),
            @Result(column="stock_id", property="stockId", jdbcType=JdbcType.VARCHAR),
            @Result(column="spec_detail", property="specDetail", jdbcType=JdbcType.VARCHAR),
            @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
            @Result(column="count", property="count", jdbcType=JdbcType.INTEGER),
            @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
            @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductStockExtend> selectByProductStockSearch(ProductStockSearch search);

}
