package com.curou.oa.dao;

import com.curou.oa.models.CompanyInfo;
import com.curou.oa.models.CompanyInfoExample;
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

public interface CompanyInfoMapper {
    @SelectProvider(type=CompanyInfoSqlProvider.class, method="countByExample")
    long countByExample(CompanyInfoExample example);

    @DeleteProvider(type=CompanyInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(CompanyInfoExample example);

    @Delete({
        "delete from company_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into company_info (id, reg_no, ",
        "company_name, contact_phone, ",
        "upload_user_id, reg_name, ",
        "create_time_utc, modify_time_utc)",
        "values (#{id,jdbcType=VARCHAR}, #{regNo,jdbcType=VARCHAR}, ",
        "#{companyName,jdbcType=VARCHAR}, #{contactPhone,jdbcType=VARCHAR}, ",
        "#{uploadUserId,jdbcType=VARCHAR}, #{regName,jdbcType=VARCHAR}, ",
        "#{createTimeUtc,jdbcType=TIMESTAMP}, #{modifyTimeUtc,jdbcType=TIMESTAMP})"
    })
    int insert(CompanyInfo record);

    @InsertProvider(type=CompanyInfoSqlProvider.class, method="insertSelective")
    int insertSelective(CompanyInfo record);

    @SelectProvider(type=CompanyInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_user_id", property="uploadUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_name", property="regName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    List<CompanyInfo> selectByExample(CompanyInfoExample example);

    @Select({
        "select",
        "id, reg_no, company_name, contact_phone, upload_user_id, reg_name, create_time_utc, ",
        "modify_time_utc",
        "from company_info",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_user_id", property="uploadUserId", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_name", property="regName", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time_utc", property="createTimeUtc", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="modify_time_utc", property="modifyTimeUtc", jdbcType=JdbcType.TIMESTAMP)
    })
    CompanyInfo selectByPrimaryKey(String id);

    @UpdateProvider(type=CompanyInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    @UpdateProvider(type=CompanyInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CompanyInfo record, @Param("example") CompanyInfoExample example);

    @UpdateProvider(type=CompanyInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CompanyInfo record);

    @Update({
        "update company_info",
        "set reg_no = #{regNo,jdbcType=VARCHAR},",
          "company_name = #{companyName,jdbcType=VARCHAR},",
          "contact_phone = #{contactPhone,jdbcType=VARCHAR},",
          "upload_user_id = #{uploadUserId,jdbcType=VARCHAR},",
          "reg_name = #{regName,jdbcType=VARCHAR},",
          "create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP},",
          "modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(CompanyInfo record);
}