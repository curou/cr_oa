package com.curou.oa.dao;

import com.curou.oa.models.UserRoles;
import com.curou.oa.models.UserRolesExample;
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

public interface UserRolesMapper {
    @SelectProvider(type=UserRolesSqlProvider.class, method="countByExample")
    long countByExample(UserRolesExample example);

    @DeleteProvider(type=UserRolesSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserRolesExample example);

    @Delete({
        "delete from user_roles",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user_roles (id, user_id, ",
        "role_id, create_time_utc, ",
        "modify_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{roleId,jdbcType=VARCHAR}, #{createTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(UserRoles record);

    @InsertProvider(type=UserRolesSqlProvider.class, method="insertSelective")
    int insertSelective(UserRoles record);

    @SelectProvider(type=UserRolesSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserRoles> selectByExample(UserRolesExample example);

    @Select({
        "select",
        "id, user_id, role_id, create_time_utc, modify_time_utc",
        "from user_roles",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    UserRoles selectByPrimaryKey(String id);

    @UpdateProvider(type=UserRolesSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserRoles record, @Param("example") UserRolesExample example);

    @UpdateProvider(type=UserRolesSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserRoles record, @Param("example") UserRolesExample example);

    @UpdateProvider(type=UserRolesSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserRoles record);

    @Update({
        "update user_roles",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "role_id = #{roleId,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UserRoles record);
}