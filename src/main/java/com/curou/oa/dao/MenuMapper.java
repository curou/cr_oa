package com.curou.oa.dao;

import com.curou.oa.models.Menu;
import com.curou.oa.models.MenuExample;
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

public interface MenuMapper {
    @SelectProvider(type=MenuSqlProvider.class, method="countByExample")
    long countByExample(MenuExample example);

    @DeleteProvider(type=MenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(MenuExample example);

    @Delete({
        "delete from menu",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into menu (id, title, ",
        "icon, path, permission_id, ",
        "pid)",
        "values (#{id,jdbcType=VARCHAR}, #{title,jdbcType=VARCHAR}, ",
        "#{icon,jdbcType=VARCHAR}, #{path,jdbcType=VARCHAR}, #{permissionId,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=VARCHAR})"
    })
    int insert(Menu record);

    @InsertProvider(type=MenuSqlProvider.class, method="insertSelective")
    int insertSelective(Menu record);

    @SelectProvider(type=MenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR)
    })
    List<Menu> selectByExample(MenuExample example);

    @Select({
        "select",
        "id, title, icon, path, permission_id, pid",
        "from menu",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission_id", property="permissionId", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.VARCHAR)
    })
    Menu selectByPrimaryKey(String id);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    @UpdateProvider(type=MenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Menu record);

    @Update({
        "update menu",
        "set title = #{title,jdbcType=VARCHAR},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "path = #{path,jdbcType=VARCHAR},",
          "permission_id = #{permissionId,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Menu record);
}