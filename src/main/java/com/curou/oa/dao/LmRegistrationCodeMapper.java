package com.curou.oa.dao;

import com.curou.oa.models.LmRegistrationCode;
import com.curou.oa.models.LmRegistrationCodeExample;
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

public interface LmRegistrationCodeMapper {
    @SelectProvider(type=LmRegistrationCodeSqlProvider.class, method="countByExample")
    long countByExample(LmRegistrationCodeExample example);

    @DeleteProvider(type=LmRegistrationCodeSqlProvider.class, method="deleteByExample")
    int deleteByExample(LmRegistrationCodeExample example);

    @Delete({
        "delete from lm_registration_code",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into lm_registration_code (id, card_type, ",
        "status, expiration_time, ",
        "remark, code, pro_type, ",
        "activation_time, bind_status, ",
        "device_no, create_time_utc, ",
        "modify_time_utc, freeze_status)",
        "values (#{id,jdbcType=VARCHAR}, #{cardType,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{expirationTime,jdbcType=TIMESTAMP}, ",
        "#{remark,jdbcType=VARCHAR}, #{code,jdbcType=VARCHAR}, #{proType,jdbcType=VARCHAR}, ",
        "#{activationTime,jdbcType=TIMESTAMP}, #{bindStatus,jdbcType=INTEGER}, ",
        "#{deviceNo,jdbcType=VARCHAR}, #{createTimeUtc,jdbcType=TIMESTAMP}, ",
        "#{modifyTimeUtc,jdbcType=TIMESTAMP}, #{freezeStatus,jdbcType=INTEGER})"
    })
    int insert(LmRegistrationCode record);

    @InsertProvider(type=LmRegistrationCodeSqlProvider.class, method="insertSelective")
    int insertSelective(LmRegistrationCode record);

    @SelectProvider(type=LmRegistrationCodeSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="card_type", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="expiration_time", property="expirationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_type", property="proType", jdbcType=JdbcType.VARCHAR),
        @Result(column="activation_time", property="activationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bind_status", property="bindStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="device_no", property="deviceNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="freeze_status", property="freezeStatus", jdbcType=JdbcType.INTEGER)
    })
    List<LmRegistrationCode> selectByExample(LmRegistrationCodeExample example);

    @Select({
        "select",
        "id, card_type, status, expiration_time, remark, code, pro_type, activation_time, ",
        "bind_status, device_no, create_time_utc, modify_time_utc, freeze_status",
        "from lm_registration_code",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="card_type", property="cardType", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="expiration_time", property="expirationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="pro_type", property="proType", jdbcType=JdbcType.VARCHAR),
        @Result(column="activation_time", property="activationTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="bind_status", property="bindStatus", jdbcType=JdbcType.INTEGER),
        @Result(column="device_no", property="deviceNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="freeze_status", property="freezeStatus", jdbcType=JdbcType.INTEGER)
    })
    LmRegistrationCode selectByPrimaryKey(String id);

    @UpdateProvider(type=LmRegistrationCodeSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") LmRegistrationCode record, @Param("example") LmRegistrationCodeExample example);

    @UpdateProvider(type=LmRegistrationCodeSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") LmRegistrationCode record, @Param("example") LmRegistrationCodeExample example);

    @UpdateProvider(type=LmRegistrationCodeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(LmRegistrationCode record);

    @Update({
        "update lm_registration_code",
        "set card_type = #{cardType,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "expiration_time = #{expirationTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "code = #{code,jdbcType=VARCHAR},",
          "pro_type = #{proType,jdbcType=VARCHAR},",
          "activation_time = #{activationTime,jdbcType=TIMESTAMP},",
          "bind_status = #{bindStatus,jdbcType=INTEGER},",
          "device_no = #{deviceNo,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP},",
          "freeze_status = #{freezeStatus,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(LmRegistrationCode record);
}