package com.curou.oa.dao;

import com.curou.oa.models.UploadUser;
import com.curou.oa.models.UploadUserExample;
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

public interface UploadUserMapper {
    @SelectProvider(type=UploadUserSqlProvider.class, method="countByExample")
    long countByExample(UploadUserExample example);

    @DeleteProvider(type=UploadUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UploadUserExample example);

    @Delete({
        "delete from upload_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into upload_user (id, company_info_id, ",
        "upload_detail_id, sort)",
        "values (#{id,jdbcType=VARCHAR}, #{companyInfoId,jdbcType=VARCHAR}, ",
        "#{uploadDetailId,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER})"
    })
    int insert(UploadUser record);

    @InsertProvider(type=UploadUserSqlProvider.class, method="insertSelective")
    int insertSelective(UploadUser record);

    @SelectProvider(type=UploadUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="company_info_id", property="companyInfoId", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_detail_id", property="uploadDetailId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    List<UploadUser> selectByExample(UploadUserExample example);

    @Select({
        "select",
        "id, company_info_id, upload_detail_id, sort",
        "from upload_user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="company_info_id", property="companyInfoId", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_detail_id", property="uploadDetailId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER)
    })
    UploadUser selectByPrimaryKey(String id);

    @UpdateProvider(type=UploadUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UploadUser record, @Param("example") UploadUserExample example);

    @UpdateProvider(type=UploadUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UploadUser record, @Param("example") UploadUserExample example);

    @UpdateProvider(type=UploadUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UploadUser record);

    @Update({
        "update upload_user",
        "set company_info_id = #{companyInfoId,jdbcType=VARCHAR},",
          "upload_detail_id = #{uploadDetailId,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(UploadUser record);
}