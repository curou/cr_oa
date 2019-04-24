package com.curou.oa.dao;

import com.curou.oa.models.ProductStock;
import com.curou.oa.models.ProductStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ProductStockMapper {
    @SelectProvider(type=ProductStockSqlProvider.class, method="countByExample")
    long countByExample(ProductStockExample example);

    @DeleteProvider(type=ProductStockSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductStockExample example);

    @Delete({
        "delete from product_stock",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into product_stock (id, product_id, ",
        "stock_id, spec_detail, ",
        "unit, count, create_time_utc, ",
        "modify_time_utc, create_employee_id, ",
        "modify_employee_id)",
        "values (#{id,jdbcType=VARCHAR}, #{productId,jdbcType=VARCHAR}, ",
        "#{stockId,jdbcType=VARCHAR}, #{specDetail,jdbcType=VARCHAR}, ",
        "#{unit,jdbcType=VARCHAR}, #{count,jdbcType=BIGINT}, #{createTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP}, #{createEmployeeId,jdbcType=VARCHAR}, ",
        "#{modifyEmployeeId,jdbcType=VARCHAR})"
    })
    int insert(ProductStock record);

    @InsertProvider(type=ProductStockSqlProvider.class, method="insertSelective")
    int insertSelective(ProductStock record);

    @SelectProvider(type=ProductStockSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_id", property="stockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_detail", property="specDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductStock> selectByExample(ProductStockExample example);

    @Select({
        "select",
        "id, product_id, stock_id, spec_detail, unit, count, create_time_utc, modify_time_utc, ",
        "create_employee_id, modify_employee_id",
        "from product_stock",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_id", property="stockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_detail", property="specDetail", jdbcType=JdbcType.VARCHAR),
        @Result(column="unit", property="unit", jdbcType=JdbcType.VARCHAR),
        @Result(column="count", property="count", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR)
    })
    ProductStock selectByPrimaryKey(String id);

    @UpdateProvider(type=ProductStockSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductStock record, @Param("example") ProductStockExample example);

    @UpdateProvider(type=ProductStockSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductStock record, @Param("example") ProductStockExample example);

    @UpdateProvider(type=ProductStockSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductStock record);

    @Update({
        "update product_stock",
        "set product_id = #{productId,jdbcType=VARCHAR},",
          "stock_id = #{stockId,jdbcType=VARCHAR},",
          "spec_detail = #{specDetail,jdbcType=VARCHAR},",
          "unit = #{unit,jdbcType=VARCHAR},",
          "count = #{count,jdbcType=BIGINT},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP},",
          "create_employee_id = #{createEmployeeId,jdbcType=VARCHAR},",
          "modify_employee_id = #{modifyEmployeeId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ProductStock record);
}