package com.curou.oa.dao;

import com.curou.oa.models.Specification;
import com.curou.oa.models.SpecificationExample;
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

public interface SpecificationMapper {
    @SelectProvider(type=SpecificationSqlProvider.class, method="countByExample")
    long countByExample(SpecificationExample example);

    @DeleteProvider(type=SpecificationSqlProvider.class, method="deleteByExample")
    int deleteByExample(SpecificationExample example);

    @Delete({
        "delete from specification",
        "where spec_id = #{specId,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String specId);

    @Insert({
        "insert into specification (spec_id, spec_delete_status, ",
        "spec_name, spec_sort, ",
        "spec_create_employee_id, spec_modify_employee_id, ",
        "spec_create_time_utc, spec_modify_time_utc)",
        "values (#{specId,jdbcType=VARCHAR}, #{specDeleteStatus,jdbcType=INTEGER}, ",
        "#{specName,jdbcType=VARCHAR}, #{specSort,jdbcType=INTEGER}, ",
        "#{specCreateEmployeeId,jdbcType=VARCHAR}, #{specModifyEmployeeId,jdbcType=VARCHAR}, ",
        "#{specCreateTimeUtc,jdbcType=TIMESTAMP}, #{specModifyTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(Specification record);

    @InsertProvider(type=SpecificationSqlProvider.class, method="insertSelective")
    int insertSelective(Specification record);

    @SelectProvider(type=SpecificationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="spec_delete_status", property="specDeleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="spec_name", property="specName", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_sort", property="specSort", jdbcType=JdbcType.INTEGER),
        @Result(column="spec_create_employee_id", property="specCreateEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_modify_employee_id", property="specModifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_create_time_utc", property="specCreateTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="spec_modify_time_utc", property="specModifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Specification> selectByExample(SpecificationExample example);

    @Select({
        "select",
        "spec_id, spec_delete_status, spec_name, spec_sort, spec_create_employee_id, ",
        "spec_modify_employee_id, spec_create_time_utc, spec_modify_time_utc",
        "from specification",
        "where spec_id = #{specId,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="spec_id", property="specId", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="spec_delete_status", property="specDeleteStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="spec_name", property="specName", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_sort", property="specSort", jdbcType=JdbcType.INTEGER),
        @Result(column="spec_create_employee_id", property="specCreateEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_modify_employee_id", property="specModifyEmployeeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="spec_create_time_utc", property="specCreateTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="spec_modify_time_utc", property="specModifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    Specification selectByPrimaryKey(String specId);

    @UpdateProvider(type=SpecificationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Specification record, @Param("example") SpecificationExample example);

    @UpdateProvider(type=SpecificationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Specification record, @Param("example") SpecificationExample example);

    @UpdateProvider(type=SpecificationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Specification record);

    @Update({
        "update specification",
        "set spec_delete_status = #{specDeleteStatus,jdbcType=INTEGER},",
          "spec_name = #{specName,jdbcType=VARCHAR},",
          "spec_sort = #{specSort,jdbcType=INTEGER},",
          "spec_create_employee_id = #{specCreateEmployeeId,jdbcType=VARCHAR},",
          "spec_modify_employee_id = #{specModifyEmployeeId,jdbcType=VARCHAR},",
          "spec_create_time_utc = #{specCreateTimeUtc,jdbcType=TIMESTAMP},",
          "spec_modify_time_utc = #{specModifyTimeUtc,jdbcType=TIMESTAMP}",
        "where spec_id = #{specId,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Specification record);
}