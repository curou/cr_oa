package com.curou.oa.dao.extend;


import com.curou.oa.dao.MenuMapper;
import com.curou.oa.models.extend.MenuExtend;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface MenuExtendMapper extends MenuMapper {


    @SelectProvider(type=MenuExtendSqlProvider.class, method="getListByPermissionsAndSort")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
            @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
            @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
            @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
            @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.VARCHAR),
            @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR),
            @Result(column="permission_id", property="permissionName",one=@One(select="com.curou.oa.dao.extend.MenuExtendMapper.getPermissionName"))
    })
    List<MenuExtend> getListBySort(@Param("pid") String pid, @Param("permissions")List<String> permissions);


    @Select("select name from permission where id = #{id}")
    String getPermissionName(String id);

}
