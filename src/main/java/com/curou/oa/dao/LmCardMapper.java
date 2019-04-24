package com.curou.oa.dao;

import com.curou.oa.models.LmCard;
import com.curou.oa.models.LmCardExample;
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

public interface LmCardMapper {
    @SelectProvider(type=LmCardSqlProvider.class, method="countByExample")
    long countByExample(LmCardExample example);

    @DeleteProvider(type=LmCardSqlProvider.class, method="deleteByExample")
    int deleteByExample(LmCardExample example);

    @Delete({
        "delete from lm_card",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into lm_card (id, card_name, ",
        "create_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{cardName,jdbcType=VARCHAR}, ",
        "#{createTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(LmCard record);

    @InsertProvider(type=LmCardSqlProvider.class, method="insertSelective")
    int insertSelective(LmCard record);

    @SelectProvider(type=LmCardSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="card_name", property="cardName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<LmCard> selectByExample(LmCardExample example);

    @Select({
        "select",
        "id, card_name, create_time_utc",
        "from lm_card",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="card_name", property="cardName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    LmCard selectByPrimaryKey(String id);

    @UpdateProvider(type=LmCardSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LmCard record, @Param("example") LmCardExample example);

    @UpdateProvider(type=LmCardSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LmCard record, @Param("example") LmCardExample example);

    @UpdateProvider(type=LmCardSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LmCard record);

    @Update({
        "update lm_card",
        "set card_name = #{cardName,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(LmCard record);
}