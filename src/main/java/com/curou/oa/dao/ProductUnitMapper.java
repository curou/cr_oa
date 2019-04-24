package com.curou.oa.dao;

import com.curou.oa.models.ProductUnit;
import com.curou.oa.models.ProductUnitExample;
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

public interface ProductUnitMapper {
    @SelectProvider(type=ProductUnitSqlProvider.class, method="countByExample")
    long countByExample(ProductUnitExample example);

    @DeleteProvider(type=ProductUnitSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductUnitExample example);

    @Delete({
        "delete from product_unit",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into product_unit (id, value, ",
        "create_time_utc, modify_time_utc, ",
        "create_employee_id, modify_employee_id)",
        "values (#{id,jdbcType=VARCHAR}, #{value,jdbcType=VARCHAR}, ",
        "#{createTimeUtc,jdbcType=TIMESTAMP}, #{modifyTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{createEmployeeId,jdbcType=VARCHAR}, #{modifyEmployeeId,jdbcType=VARCHAR})"
    })
    int insert(ProductUnit record);

    @InsertProvider(type=ProductUnitSqlProvider.class, method="insertSelective")
    int insertSelective(ProductUnit record);

    @SelectProvider(type=ProductUnitSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR)
    })
    List<ProductUnit> selectByExample(ProductUnitExample example);

    @Select({
        "select",
        "id, value, create_time_utc, modify_time_utc, create_employee_id, modify_employee_id",
        "from product_unit",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR)
    })
    ProductUnit selectByPrimaryKey(String id);

    @UpdateProvider(type=ProductUnitSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ProductUnit record, @Param("example") ProductUnitExample example);

    @UpdateProvider(type=ProductUnitSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ProductUnit record, @Param("example") ProductUnitExample example);

    @UpdateProvider(type=ProductUnitSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ProductUnit record);

    @Update({
        "update product_unit",
        "set value = #{value,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP},",
          "create_employee_id = #{createEmployeeId,jdbcType=VARCHAR},",
          "modify_employee_id = #{modifyEmployeeId,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(ProductUnit record);
}