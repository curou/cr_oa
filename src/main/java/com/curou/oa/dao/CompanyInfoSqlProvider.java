package com.curou.oa.dao;

import com.curou.oa.models.CompanyInfo;
import com.curou.oa.models.CompanyInfoExample.Criteria;
import com.curou.oa.models.CompanyInfoExample.Criterion;
import com.curou.oa.models.CompanyInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CompanyInfoSqlProvider {

    public String countByExample(CompanyInfoExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("company_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CompanyInfoExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("company_info");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CompanyInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("company_info");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getRegNo() != null) {
            sql.VALUES("reg_no", "#{regNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.VALUES("company_name", "#{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.VALUES("contact_phone", "#{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadUserId() != null) {
            sql.VALUES("upload_user_id", "#{uploadUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegName() != null) {
            sql.VALUES("reg_name", "#{regName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.VALUES("create_time_utc", "#{createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.VALUES("modify_time_utc", "#{modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CompanyInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("reg_no");
        sql.SELECT("company_name");
        sql.SELECT("contact_phone");
        sql.SELECT("upload_user_id");
        sql.SELECT("reg_name");
        sql.SELECT("create_time_utc");
        sql.SELECT("modify_time_utc");
        sql.FROM("company_info");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CompanyInfo record = (CompanyInfo) parameter.get("record");
        CompanyInfoExample example = (CompanyInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("company_info");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getRegNo() != null) {
            sql.SET("reg_no = #{record.regNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadUserId() != null) {
            sql.SET("upload_user_id = #{record.uploadUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegName() != null) {
            sql.SET("reg_name = #{record.regName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("company_info");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("reg_no = #{record.regNo,jdbcType=VARCHAR}");
        sql.SET("company_name = #{record.companyName,jdbcType=VARCHAR}");
        sql.SET("contact_phone = #{record.contactPhone,jdbcType=VARCHAR}");
        sql.SET("upload_user_id = #{record.uploadUserId,jdbcType=VARCHAR}");
        sql.SET("reg_name = #{record.regName,jdbcType=VARCHAR}");
        sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        
        CompanyInfoExample example = (CompanyInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CompanyInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("company_info");
        
        if (record.getRegNo() != null) {
            sql.SET("reg_no = #{regNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCompanyName() != null) {
            sql.SET("company_name = #{companyName,jdbcType=VARCHAR}");
        }
        
        if (record.getContactPhone() != null) {
            sql.SET("contact_phone = #{contactPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getUploadUserId() != null) {
            sql.SET("upload_user_id = #{uploadUserId,jdbcType=VARCHAR}");
        }
        
        if (record.getRegName() != null) {
            sql.SET("reg_name = #{regName,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.SET("create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.SET("modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CompanyInfoExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}