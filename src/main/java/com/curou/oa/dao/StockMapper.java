package com.curou.oa.dao;

import com.curou.oa.models.Stock;
import com.curou.oa.models.StockExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface StockMapper {
    @SelectProvider(type= StockSqlProvider.class, method="countByExample")
    long countByExample(StockExample example);

    @DeleteProvider(type= StockSqlProvider.class, method="deleteByExample")
    int deleteByExample(StockExample example);

    @Delete({
        "delete from stock",
        "where stock_id = #{stockId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String stockId);

    @Insert({
        "insert into stock (stock_id, stock_name, ",
        "stock_status, stock_delete_status, ",
        "stock_create_time_utc, stock_modify_time_utc, ",
        "stock_create_employee_id, stock_modify_employee_id)",
        "values (#{stockId,jdbcType=VARCHAR}, #{stockName,jdbcType=VARCHAR}, ",
        "#{stockStatus,jdbcType=INTEGER}, #{stockDeleteStatus,jdbcType=INTEGER}, ",
        "#{stockCreateTimeUtc,jdbcType=TIMESTAMP}, #{stockModifyTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{stockCreateEmployeeId,jdbcType=VARCHAR}, #{stockModifyEmployeeId,jdbcType=VARCHAR})"
    })
    int insert(Stock record);

    @InsertProvider(type= StockSqlProvider.class, method="insertSelective")
    int insertSelective(Stock record);

    @SelectProvider(type= StockSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="stock_id", property="stockId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="stock_name", property="stockName", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_status", property="stockStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="stock_delete_status", property="stockDeleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="stock_create_time_utc", property="stockCreateTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stock_modify_time_utc", property="stockModifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stock_create_employee_id", property="stockCreateEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_modify_employee_id", property="stockModifyEmployeeId", jdbcType=JdbcType.VARCHAR)
    })
    List<Stock> selectByExample(StockExample example);

    @Select({
        "select",
        "stock_id, stock_name, stock_status, stock_delete_status, stock_create_time_utc, ",
        "stock_modify_time_utc, stock_create_employee_id, stock_modify_employee_id",
        "from stock",
        "where stock_id = #{stockId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="stock_id", property="stockId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="stock_name", property="stockName", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_status", property="stockStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="stock_delete_status", property="stockDeleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="stock_create_time_utc", property="stockCreateTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stock_modify_time_utc", property="stockModifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stock_create_employee_id", property="stockCreateEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_modify_employee_id", property="stockModifyEmployeeId", jdbcType=JdbcType.VARCHAR)
    })
    Stock selectByPrimaryKey(String stockId);

    @UpdateProvider(type= StockSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Stock record, @Param("example") StockExample example);

    @UpdateProvider(type= StockSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Stock record, @Param("example") StockExample example);

    @UpdateProvider(type= StockSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Stock record);

    @Update({
        "update stock",
        "set stock_name = #{stockName,jdbcType=VARCHAR},",
          "stock_status = #{stockStatus,jdbcType=INTEGER},",
          "stock_delete_status = #{stockDeleteStatus,jdbcType=INTEGER},",
          "stock_create_time_utc = #{stockCreateTimeUtc,jdbcType=TIMESTAMP},",
          "stock_modify_time_utc = #{stockModifyTimeUtc,jdbcType=TIMESTAMP},",
          "stock_create_employee_id = #{stockCreateEmployeeId,jdbcType=VARCHAR},",
          "stock_modify_employee_id = #{stockModifyEmployeeId,jdbcType=VARCHAR}",
        "where stock_id = #{stockId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Stock record);
}