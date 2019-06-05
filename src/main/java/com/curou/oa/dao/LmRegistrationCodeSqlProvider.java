package com.curou.oa.dao;

import com.curou.oa.models.LmRegistrationCode;
import com.curou.oa.models.LmRegistrationCodeExample.Criteria;
import com.curou.oa.models.LmRegistrationCodeExample.Criterion;
import com.curou.oa.models.LmRegistrationCodeExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class LmRegistrationCodeSqlProvider {

    public String countByExample(LmRegistrationCodeExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("lm_registration_code");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(LmRegistrationCodeExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("lm_registration_code");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(LmRegistrationCode record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("lm_registration_code");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getCardType() != null) {
            sql.VALUES("card_type", "#{cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getExpirationTime() != null) {
            sql.VALUES("expiration_time", "#{expirationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.VALUES("remark", "#{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.VALUES("code", "#{code,jdbcType=VARCHAR}");
        }
        
        if (record.getProType() != null) {
            sql.VALUES("pro_type", "#{proType,jdbcType=VARCHAR}");
        }
        
        if (record.getActivationTime() != null) {
            sql.VALUES("activation_time", "#{activationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBindStatus() != null) {
            sql.VALUES("bind_status", "#{bindStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeviceNo() != null) {
            sql.VALUES("device_no", "#{deviceNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.VALUES("create_time_utc", "#{createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.VALUES("modify_time_utc", "#{modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFreezeStatus() != null) {
            sql.VALUES("freeze_status", "#{freezeStatus,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(LmRegistrationCodeExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("card_type");
        sql.SELECT("status");
        sql.SELECT("expiration_time");
        sql.SELECT("remark");
        sql.SELECT("code");
        sql.SELECT("pro_type");
        sql.SELECT("activation_time");
        sql.SELECT("bind_status");
        sql.SELECT("device_no");
        sql.SELECT("create_time_utc");
        sql.SELECT("modify_time_utc");
        sql.SELECT("freeze_status");
        sql.FROM("lm_registration_code");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        LmRegistrationCode record = (LmRegistrationCode) parameter.get("record");
        LmRegistrationCodeExample example = (LmRegistrationCodeExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("lm_registration_code");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getCardType() != null) {
            sql.SET("card_type = #{record.cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getExpirationTime() != null) {
            sql.SET("expiration_time = #{record.expirationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        }
        
        if (record.getProType() != null) {
            sql.SET("pro_type = #{record.proType,jdbcType=VARCHAR}");
        }
        
        if (record.getActivationTime() != null) {
            sql.SET("activation_time = #{record.activationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBindStatus() != null) {
            sql.SET("bind_status = #{record.bindStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeviceNo() != null) {
            sql.SET("device_no = #{record.deviceNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFreezeStatus() != null) {
            sql.SET("freeze_status = #{record.freezeStatus,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("lm_registration_code");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("card_type = #{record.cardType,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("expiration_time = #{record.expirationTime,jdbcType=TIMESTAMP}");
        sql.SET("remark = #{record.remark,jdbcType=VARCHAR}");
        sql.SET("code = #{record.code,jdbcType=VARCHAR}");
        sql.SET("pro_type = #{record.proType,jdbcType=VARCHAR}");
        sql.SET("activation_time = #{record.activationTime,jdbcType=TIMESTAMP}");
        sql.SET("bind_status = #{record.bindStatus,jdbcType=INTEGER}");
        sql.SET("device_no = #{record.deviceNo,jdbcType=VARCHAR}");
        sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("freeze_status = #{record.freezeStatus,jdbcType=INTEGER}");
        
        LmRegistrationCodeExample example = (LmRegistrationCodeExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(LmRegistrationCode record) {
        SQL sql = new SQL();
        sql.UPDATE("lm_registration_code");
        
        if (record.getCardType() != null) {
            sql.SET("card_type = #{cardType,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getExpirationTime() != null) {
            sql.SET("expiration_time = #{expirationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getRemark() != null) {
            sql.SET("remark = #{remark,jdbcType=VARCHAR}");
        }
        
        if (record.getCode() != null) {
            sql.SET("code = #{code,jdbcType=VARCHAR}");
        }
        
        if (record.getProType() != null) {
            sql.SET("pro_type = #{proType,jdbcType=VARCHAR}");
        }
        
        if (record.getActivationTime() != null) {
            sql.SET("activation_time = #{activationTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getBindStatus() != null) {
            sql.SET("bind_status = #{bindStatus,jdbcType=INTEGER}");
        }
        
        if (record.getDeviceNo() != null) {
            sql.SET("device_no = #{deviceNo,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.SET("create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.SET("modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getFreezeStatus() != null) {
            sql.SET("freeze_status = #{freezeStatus,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, LmRegistrationCodeExample example, boolean includeExamplePhrase) {
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