package com.curou.oa.dao;

import com.curou.oa.models.MenuSort;
import com.curou.oa.models.MenuSortExample;
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

public interface MenuSortMapper {
    @SelectProvider(type=MenuSortSqlProvider.class, method="countByExample")
    long countByExample(MenuSortExample example);

    @DeleteProvider(type=MenuSortSqlProvider.class, method="deleteByExample")
    int deleteByExample(MenuSortExample example);

    @Delete({
        "delete from menu_sort",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into menu_sort (id, menu_id, ",
        "sort)",
        "values (#{id,jdbcType=VARCHAR}, #{menuId,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=INTEGER})"
    })
    int insert(MenuSort record);

    @InsertProvider(type=MenuSortSqlProvider.class, method="insertSelective")
    int insertSelective(MenuSort record);

    @SelectProvider(type=MenuSortSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<MenuSort> selectByExample(MenuSortExample example);

    @Select({
        "select",
        "id, menu_id, sort",
        "from menu_sort",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    MenuSort selectByPrimaryKey(String id);

    @UpdateProvider(type=MenuSortSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MenuSort record, @Param("example") MenuSortExample example);

    @UpdateProvider(type=MenuSortSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MenuSort record, @Param("example") MenuSortExample example);

    @UpdateProvider(type=MenuSortSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MenuSort record);

    @Update({
        "update menu_sort",
        "set menu_id = #{menuId,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(MenuSort record);
}