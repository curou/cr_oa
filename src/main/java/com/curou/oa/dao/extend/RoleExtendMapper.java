package com.curou.oa.dao.extend;

import com.curou.oa.dao.RoleMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.vo.response.RoleDataRes;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface RoleExtendMapper extends RoleMapper {

    @SelectProvider(type=RoleExtendSqlProvider.class, method="roleList")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="perm", property="perm", jdbcType=JdbcType.VARCHAR),
            @Result(column="permId", property="permId", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<RoleDataRes> list(SearchBase search);
}
