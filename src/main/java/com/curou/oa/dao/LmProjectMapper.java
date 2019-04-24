package com.curou.oa.dao;

import com.curou.oa.models.LmProject;
import com.curou.oa.models.LmProjectExample;
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

public interface LmProjectMapper {
    @SelectProvider(type=LmProjectSqlProvider.class, method="countByExample")
    long countByExample(LmProjectExample example);

    @DeleteProvider(type=LmProjectSqlProvider.class, method="deleteByExample")
    int deleteByExample(LmProjectExample example);

    @Delete({
        "delete from lm_project",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into lm_project (id, pro_name, ",
        "create_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{proName,jdbcType=VARCHAR}, ",
        "#{createTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(LmProject record);

    @InsertProvider(type=LmProjectSqlProvider.class, method="insertSelective")
    int insertSelective(LmProject record);

    @SelectProvider(type=LmProjectSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="pro_name", property="proName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LmProject> selectByExample(LmProjectExample example);

    @Select({
        "select",
        "id, pro_name, create_time_utc",
        "from lm_project",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="pro_name", property="proName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    LmProject selectByPrimaryKey(String id);

    @UpdateProvider(type=LmProjectSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LmProject record, @Param("example") LmProjectExample example);

    @UpdateProvider(type=LmProjectSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LmProject record, @Param("example") LmProjectExample example);

    @UpdateProvider(type=LmProjectSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LmProject record);

    @Update({
        "update lm_project",
        "set pro_name = #{proName,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(LmProject record);
}