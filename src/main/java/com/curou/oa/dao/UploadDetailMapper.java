package com.curou.oa.dao;

import com.curou.oa.models.UploadDetail;
import com.curou.oa.models.UploadDetailExample;
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

public interface UploadDetailMapper {
    @SelectProvider(type=UploadDetailSqlProvider.class, method="countByExample")
    long countByExample(UploadDetailExample example);

    @DeleteProvider(type=UploadDetailSqlProvider.class, method="deleteByExample")
    int deleteByExample(UploadDetailExample example);

    @Delete({
        "delete from upload_detail",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into upload_detail (id, user_id, ",
        "create_time_utc, effective_count, ",
        "modify_time_utc, count)",
        "values (#{id,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{createTimeUtc,jdbcType=TIMESTAMP}, #{effectiveCount,jdbcType=INTEGER}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP}, #{count,jdbcType=INTEGER})"
    })
    int insert(UploadDetail record);

    @InsertProvider(type=UploadDetailSqlProvider.class, method="insertSelective")
    int insertSelective(UploadDetail record);

    @SelectProvider(type=UploadDetailSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="effective_count", property="effectiveCount", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER)
    })
    List<UploadDetail> selectByExample(UploadDetailExample example);

    @Select({
        "select",
        "id, user_id, create_time_utc, effective_count, modify_time_utc, count",
        "from upload_detail",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="effective_count", property="effectiveCount", jdbcType=JdbcType.INTEGER),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="count", property="count", jdbcType=JdbcType.INTEGER)
    })
    UploadDetail selectByPrimaryKey(String id);

    @UpdateProvider(type=UploadDetailSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UploadDetail record, @Param("example") UploadDetailExample example);

    @UpdateProvider(type=UploadDetailSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UploadDetail record, @Param("example") UploadDetailExample example);

    @UpdateProvider(type=UploadDetailSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UploadDetail record);

    @Update({
        "update upload_detail",
        "set user_id = #{userId,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "effective_count = #{effectiveCount,jdbcType=INTEGER},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP},",
          "count = #{count,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UploadDetail record);
}