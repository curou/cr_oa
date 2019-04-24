package com.curou.oa.dao;

import com.curou.oa.models.SpecificationDetail;
import com.curou.oa.models.SpecificationDetailExample;
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

public interface SpecificationDetailMapper {
    @SelectProvider(type=SpecificationDetailSqlProvider.class, method="countByExample")
    long countByExample(SpecificationDetailExample example);

    @DeleteProvider(type=SpecificationDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(SpecificationDetailExample example);

    @Delete({
        "delete from specification_detail",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into specification_detail (id, spec_id, ",
        "value, create_employee_id, ",
        "modify_employee_id, create_time_utc, ",
        "modify_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{specId,jdbcType=VARCHAR}, ",
        "#{value,jdbcType=VARCHAR}, #{createEmployeeId,jdbcType=VARCHAR}, ",
        "#{modifyEmployeeId,jdbcType=VARCHAR}, #{createTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(SpecificationDetail record);

    @InsertProvider(type=SpecificationDetailSqlProvider.class, method="insertSelective")
    int insertSelective(SpecificationDetail record);

    @SelectProvider(type=SpecificationDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SpecificationDetail> selectByExample(SpecificationDetailExample example);

    @Select({
        "select",
        "id, spec_id, value, create_employee_id, modify_employee_id, create_time_utc, ",
        "modify_time_utc",
        "from specification_detail",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_employee_id", property="createEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="modify_employee_id", property="modifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    SpecificationDetail selectByPrimaryKey(String id);

    @UpdateProvider(type=SpecificationDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SpecificationDetail record, @Param("example") SpecificationDetailExample example);

    @UpdateProvider(type=SpecificationDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SpecificationDetail record, @Param("example") SpecificationDetailExample example);

    @UpdateProvider(type=SpecificationDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SpecificationDetail record);

    @Update({
        "update specification_detail",
        "set spec_id = #{specId,jdbcType=VARCHAR},",
          "value = #{value,jdbcType=VARCHAR},",
          "create_employee_id = #{createEmployeeId,jdbcType=VARCHAR},",
          "modify_employee_id = #{modifyEmployeeId,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(SpecificationDetail record);
}