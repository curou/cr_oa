package com.curou.oa.dao.extend;

import com.curou.oa.dao.CompanyInfoMapper;
import com.curou.oa.dao.CompanyInfoSqlProvider;
import com.curou.oa.models.CompanyInfo;
import com.curou.oa.models.CompanyInfoExample;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface CompanyInfoExtendMapper extends CompanyInfoMapper {

    @SelectProvider(type= CompanyInfoExtendSqlProvider.class, method="getCompanyInfoByUploadDetailId")
    @Results({
            @Result(column="reg_no", property="regNo", jdbcType=JdbcType.VARCHAR),
            @Result(column="company_name", property="companyName", jdbcType=JdbcType.VARCHAR),
            @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
            @Result(column="reg_name", property="regName", jdbcType=JdbcType.VARCHAR),
    })
    List<CompanyInfo> getCompanyInfoByUploadDetailId(String uploadDetailId);
}
