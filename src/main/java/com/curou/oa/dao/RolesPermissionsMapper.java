package com.curou.oa.dao;

import com.curou.oa.models.RolesPermissions;
import com.curou.oa.models.RolesPermissionsExample;
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

public interface RolesPermissionsMapper {
    @SelectProvider(type=RolesPermissionsSqlProvider.class, method="countByExample")
    long countByExample(RolesPermissionsExample example);

    @DeleteProvider(type=RolesPermissionsSqlProvider.class, method="deleteByExample")
    int deleteByExample(RolesPermissionsExample example);

    @Delete({
        "delete from roles_permissions",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into roles_permissions (id, role_id, ",
        "perm_id, create_time_utc, ",
        "modify_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{roleId,jdbcType=VARCHAR}, ",
        "#{permId,jdbcType=VARCHAR}, #{createTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(RolesPermissions record);

    @InsertProvider(type=RolesPermissionsSqlProvider.class, method="insertSelective")
    int insertSelective(RolesPermissions record);

    @SelectProvider(type=RolesPermissionsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="perm_id", property="permId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RolesPermissions> selectByExample(RolesPermissionsExample example);

    @Select({
        "select",
        "id, role_id, perm_id, create_time_utc, modify_time_utc",
        "from roles_permissions",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="perm_id", property="permId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    RolesPermissions selectByPrimaryKey(String id);

    @UpdateProvider(type=RolesPermissionsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RolesPermissions record, @Param("example") RolesPermissionsExample example);

    @UpdateProvider(type=RolesPermissionsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RolesPermissions record, @Param("example") RolesPermissionsExample example);

    @UpdateProvider(type=RolesPermissionsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RolesPermissions record);

    @Update({
        "update roles_permissions",
        "set role_id = #{roleId,jdbcType=VARCHAR},",
          "perm_id = #{permId,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(RolesPermissions record);
}