package com.curou.oa.dao;

import com.curou.oa.models.StockOrder;
import com.curou.oa.models.StockOrderExample;
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

public interface StockOrderMapper {
    @SelectProvider(type=StockOrderSqlProvider.class, method="countByExample")
    long countByExample(StockOrderExample example);

    @DeleteProvider(type=StockOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(StockOrderExample example);

    @Delete({
        "delete from stock_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into stock_order (id, type, ",
        "order_id, stock_id, ",
        "create_employee_id, modify_employee_id, ",
        "create_time_utc, modify_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{orderId,jdbcType=VARCHAR}, #{stockId,jdbcType=VARCHAR}, ",
        "#{createEmployeeId,jdbcType=VARCHAR}, #{modifyEmployeeId,jdbcType=VARCHAR}, ",
        "#{createTimeUtc,jdbcType=TIMESTAMP}, #{modifyTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(StockOrder record);

    @InsertProvider(type=StockOrderSqlProvider.class, method="insertSelective")
    int insertSelective(StockOrder record);

    @SelectProvider(type=StockOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_id", property="stockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<StockOrder> selectByExample(StockOrderExample example);

    @Select({
        "select",
        "id, type, order_id, stock_id, create_employee_id, modify_employee_id, create_time_utc, ",
        "modify_time_utc",
        "from stock_order",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_id", property="orderId", jdbcType=JdbcType.VARCHAR),
        @Result(column="stock_id", property="stockId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    StockOrder selectByPrimaryKey(String id);

    @UpdateProvider(type=StockOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") StockOrder record, @Param("example") StockOrderExample example);

    @UpdateProvider(type=StockOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") StockOrder record, @Param("example") StockOrderExample example);

    @UpdateProvider(type=StockOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(StockOrder record);

    @Update({
        "update stock_order",
        "set type = #{type,jdbcType=VARCHAR},",
          "order_id = #{orderId,jdbcType=VARCHAR},",
          "stock_id = #{stockId,jdbcType=VARCHAR},",
          "create_employee_id = #{createEmployeeId,jdbcType=VARCHAR},",
          "modify_employee_id = #{modifyEmployeeId,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(StockOrder record);
}