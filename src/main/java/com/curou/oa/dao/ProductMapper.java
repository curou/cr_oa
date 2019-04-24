package com.curou.oa.dao;

import com.curou.oa.models.Product;
import com.curou.oa.models.ProductExample;
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

public interface ProductMapper {
    @SelectProvider(type=ProductSqlProvider.class, method="countByExample")
    long countByExample(ProductExample example);

    @DeleteProvider(type=ProductSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductExample example);

    @Delete({
        "delete from product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String productId);

    @Insert({
        "insert into product (product_id, product_number, ",
        "product_delete_status, product_inventory, ",
        "product_name, product_price, ",
        "product_status, product_cost_price, ",
        "product_sell_price, product_units, ",
        "product_upper_limit, product_lower_limit, ",
        "product_warning_status, product_create_employee_id, ",
        "product_modify_employee_id, product_create_time_utc, ",
        "product_modify_time_utc, product_remarks, ",
        "product_inventory_detail)",
        "values (#{productId,jdbcType=VARCHAR}, #{productNumber,jdbcType=VARCHAR}, ",
        "#{productDeleteStatus,jdbcType=VARCHAR}, #{productInventory,jdbcType=DECIMAL}, ",
        "#{productName,jdbcType=VARCHAR}, #{productPrice,jdbcType=DECIMAL}, ",
        "#{productStatus,jdbcType=VARCHAR}, #{productCostPrice,jdbcType=DECIMAL}, ",
        "#{productSellPrice,jdbcType=DECIMAL}, #{productUnits,jdbcType=VARCHAR}, ",
        "#{productUpperLimit,jdbcType=DECIMAL}, #{productLowerLimit,jdbcType=DECIMAL}, ",
        "#{productWarningStatus,jdbcType=INTEGER}, #{productCreateEmployeeId,jdbcType=VARCHAR}, ",
        "#{productModifyEmployeeId,jdbcType=VARCHAR}, #{productCreateTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{productModifyTimeUtc,jdbcType=TIMESTAMP}, #{productRemarks,jdbcType=VARCHAR}, ",
        "#{productInventoryDetail,jdbcType=LONGVARCHAR})"
    })
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    int insertSelective(Product record);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_number", property="productNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_delete_status", property="productDeleteStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_inventory", property="productInventory", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_status", property="productStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_cost_price", property="productCostPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_sell_price", property="productSellPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_units", property="productUnits", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_upper_limit", property="productUpperLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_lower_limit", property="productLowerLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_warning_status", property="productWarningStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="product_create_employee_id", property="productCreateEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_modify_employee_id", property="productModifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_create_time_utc", property="productCreateTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_modify_time_utc", property="productModifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_remarks", property="productRemarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_inventory_detail", property="productInventoryDetail", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Product> selectByExampleWithBLOBs(ProductExample example);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_number", property="productNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_delete_status", property="productDeleteStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_inventory", property="productInventory", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_status", property="productStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_cost_price", property="productCostPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_sell_price", property="productSellPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_units", property="productUnits", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_upper_limit", property="productUpperLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_lower_limit", property="productLowerLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_warning_status", property="productWarningStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="product_create_employee_id", property="productCreateEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_modify_employee_id", property="productModifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_create_time_utc", property="productCreateTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_modify_time_utc", property="productModifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_remarks", property="productRemarks", jdbcType=JdbcType.VARCHAR)
    })
    List<Product> selectByExample(ProductExample example);

    @Select({
        "select",
        "product_id, product_number, product_delete_status, product_inventory, product_name, ",
        "product_price, product_status, product_cost_price, product_sell_price, product_units, ",
        "product_upper_limit, product_lower_limit, product_warning_status, product_create_employee_id, ",
        "product_modify_employee_id, product_create_time_utc, product_modify_time_utc, ",
        "product_remarks, product_inventory_detail",
        "from product",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="product_id", property="productId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="product_number", property="productNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_delete_status", property="productDeleteStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_inventory", property="productInventory", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_name", property="productName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_price", property="productPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_status", property="productStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_cost_price", property="productCostPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_sell_price", property="productSellPrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_units", property="productUnits", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_upper_limit", property="productUpperLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_lower_limit", property="productLowerLimit", jdbcType=JdbcType.DECIMAL),
        @Result(column="product_warning_status", property="productWarningStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="product_create_employee_id", property="productCreateEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_modify_employee_id", property="productModifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_create_time_utc", property="productCreateTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_modify_time_utc", property="productModifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_remarks", property="productRemarks", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_inventory_detail", property="productInventoryDetail", jdbcType=JdbcType.LONGVARCHAR)
    })
    Product selectByPrimaryKey(String productId);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set product_number = #{productNumber,jdbcType=VARCHAR},",
          "product_delete_status = #{productDeleteStatus,jdbcType=VARCHAR},",
          "product_inventory = #{productInventory,jdbcType=DECIMAL},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "product_status = #{productStatus,jdbcType=VARCHAR},",
          "product_cost_price = #{productCostPrice,jdbcType=DECIMAL},",
          "product_sell_price = #{productSellPrice,jdbcType=DECIMAL},",
          "product_units = #{productUnits,jdbcType=VARCHAR},",
          "product_upper_limit = #{productUpperLimit,jdbcType=DECIMAL},",
          "product_lower_limit = #{productLowerLimit,jdbcType=DECIMAL},",
          "product_warning_status = #{productWarningStatus,jdbcType=INTEGER},",
          "product_create_employee_id = #{productCreateEmployeeId,jdbcType=VARCHAR},",
          "product_modify_employee_id = #{productModifyEmployeeId,jdbcType=VARCHAR},",
          "product_create_time_utc = #{productCreateTimeUtc,jdbcType=TIMESTAMP},",
          "product_modify_time_utc = #{productModifyTimeUtc,jdbcType=TIMESTAMP},",
          "product_remarks = #{productRemarks,jdbcType=VARCHAR},",
          "product_inventory_detail = #{productInventoryDetail,jdbcType=LONGVARCHAR}",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKeyWithBLOBs(Product record);

    @Update({
        "update product",
        "set product_number = #{productNumber,jdbcType=VARCHAR},",
          "product_delete_status = #{productDeleteStatus,jdbcType=VARCHAR},",
          "product_inventory = #{productInventory,jdbcType=DECIMAL},",
          "product_name = #{productName,jdbcType=VARCHAR},",
          "product_price = #{productPrice,jdbcType=DECIMAL},",
          "product_status = #{productStatus,jdbcType=VARCHAR},",
          "product_cost_price = #{productCostPrice,jdbcType=DECIMAL},",
          "product_sell_price = #{productSellPrice,jdbcType=DECIMAL},",
          "product_units = #{productUnits,jdbcType=VARCHAR},",
          "product_upper_limit = #{productUpperLimit,jdbcType=DECIMAL},",
          "product_lower_limit = #{productLowerLimit,jdbcType=DECIMAL},",
          "product_warning_status = #{productWarningStatus,jdbcType=INTEGER},",
          "product_create_employee_id = #{productCreateEmployeeId,jdbcType=VARCHAR},",
          "product_modify_employee_id = #{productModifyEmployeeId,jdbcType=VARCHAR},",
          "product_create_time_utc = #{productCreateTimeUtc,jdbcType=TIMESTAMP},",
          "product_modify_time_utc = #{productModifyTimeUtc,jdbcType=TIMESTAMP},",
          "product_remarks = #{productRemarks,jdbcType=VARCHAR}",
        "where product_id = #{productId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Product record);
}