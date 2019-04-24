package com.curou.oa.dao;

import com.curou.oa.models.Permission;
import com.curou.oa.models.PermissionExample;
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

public interface PermissionMapper {
    @SelectProvider(type=PermissionSqlProvider.class, method="countByExample")
    long countByExample(PermissionExample example);

    @DeleteProvider(type=PermissionSqlProvider.class, method="deleteByExample")
    int deleteByExample(PermissionExample example);

    @Delete({
        "delete from permission",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into permission (id, name, ",
        "flag, create_time_utc, ",
        "modify_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{flag,jdbcType=VARCHAR}, #{createTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(Permission record);

    @InsertProvider(type=PermissionSqlProvider.class, method="insertSelective")
    int insertSelective(Permission record);

    @SelectProvider(type=PermissionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Permission> selectByExample(PermissionExample example);

    @Select({
        "select",
        "id, name, flag, create_time_utc, modify_time_utc",
        "from permission",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    Permission selectByPrimaryKey(String id);

    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    @UpdateProvider(type=PermissionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Permission record);

    @Update({
        "update permission",
        "set name = #{name,jdbcType=VARCHAR},",
          "flag = #{flag,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Permission record);
}