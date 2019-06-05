package com.curou.oa.dao.extend;

import com.curou.oa.dao.LmRegistrationCodeMapper;
import com.curou.oa.entity.LmRegistrationCodeSearch;
import com.curou.oa.vo.response.LmRegistrationCodeRes;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface LmRegistrationCodeExtendMapper extends LmRegistrationCodeMapper {

    @SelectProvider(type= LmRegistrationCodeExtendSqlProvider.class, method="list")
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
            @Result(column="card_type", property="cardType", jdbcType=JdbcType.VARCHAR),
            @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
            @Result(column="expiration_time", property="expirationTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
            @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
            @Result(column="pro_type", property="proType", jdbcType=JdbcType.VARCHAR),
            @Result(column="pro_name", property="proName", jdbcType=JdbcType.VARCHAR),
            @Result(column="card_name", property="cardName", jdbcType=JdbcType.VARCHAR),
            @Result(column="activation_time", property="activationTime", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="bind_status", property="bindStatus", jdbcType=JdbcType.INTEGER),
            @Result(column="device_no", property="deviceNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="freeze_status", property="freezeStatus", jdbcType=JdbcType.INTEGER)
    })
    List<LmRegistrationCodeRes> list(LmRegistrationCodeSearch search);
}
