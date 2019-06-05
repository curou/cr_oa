package com.curou.oa.dao.extend;

import com.curou.oa.dao.UserMapper;
import com.curou.oa.entity.UserSearch;
import com.curou.oa.vo.response.UserDataRes;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserExtendMapper extends UserMapper {

    @SelectProvider(type=UserExtendSqlProvider.class, method="userList")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
            @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
            @Result(column="role", property="role", jdbcType=JdbcType.VARCHAR),
            @Result(column="roleId", property="roleId", jdbcType=JdbcType.VARCHAR),
            @Result(column="department", property="department", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="sex", property="sex", jdbcType=JdbcType.VARCHAR),
            @Result(column="department_id", property="departmentId", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="mobile_phone", property="mobilePhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserDataRes> list(UserSearch search);

    @SelectProvider(type=UserExtendSqlProvider.class, method="getPermsFlagByUserAccount")
    List<String> getPermsFlagByUserAccount(String accout);

    @SelectProvider(type=UserExtendSqlProvider.class, method="getPermsIdByUserAccount")
    List<String> getPermsIdByUserAccount(String accout);

}
