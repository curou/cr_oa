package com.curou.oa.dao;

import com.curou.oa.models.SpecificationDetail;
import com.curou.oa.models.SpecificationDetailExample.Criteria;
import com.curou.oa.models.SpecificationDetailExample.Criterion;
import com.curou.oa.models.SpecificationDetailExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SpecificationDetailSqlProvider {

    public String countByExample(SpecificationDetailExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("specification_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SpecificationDetailExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("specification_detail");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(SpecificationDetail record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("specification_detail");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecId() != null) {
            sql.VALUES("spec_id", "#{specId,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            sql.VALUES("value", "#{value,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateEmployeeId() != null) {
            sql.VALUES("create_employee_id", "#{createEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyEmployeeId() != null) {
            sql.VALUES("modify_employee_id", "#{modifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.VALUES("create_time_utc", "#{createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.VALUES("modify_time_utc", "#{modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SpecificationDetailExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("spec_id");
        sql.SELECT("value");
        sql.SELECT("create_employee_id");
        sql.SELECT("modify_employee_id");
        sql.SELECT("create_time_utc");
        sql.SELECT("modify_time_utc");
        sql.FROM("specification_detail");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        SpecificationDetail record = (SpecificationDetail) parameter.get("record");
        SpecificationDetailExample example = (SpecificationDetailExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("specification_detail");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecId() != null) {
            sql.SET("spec_id = #{record.specId,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            sql.SET("value = #{record.value,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateEmployeeId() != null) {
            sql.SET("create_employee_id = #{record.createEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyEmployeeId() != null) {
            sql.SET("modify_employee_id = #{record.modifyEmployeeId,jdbcType=VARCHAR}");
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
        sql.UPDATE("specification_detail");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("spec_id = #{record.specId,jdbcType=VARCHAR}");
        sql.SET("value = #{record.value,jdbcType=VARCHAR}");
        sql.SET("create_employee_id = #{record.createEmployeeId,jdbcType=VARCHAR}");
        sql.SET("modify_employee_id = #{record.modifyEmployeeId,jdbcType=VARCHAR}");
        sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        
        SpecificationDetailExample example = (SpecificationDetailExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(SpecificationDetail record) {
        SQL sql = new SQL();
        sql.UPDATE("specification_detail");
        
        if (record.getSpecId() != null) {
            sql.SET("spec_id = #{specId,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            sql.SET("value = #{value,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateEmployeeId() != null) {
            sql.SET("create_employee_id = #{createEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyEmployeeId() != null) {
            sql.SET("modify_employee_id = #{modifyEmployeeId,jdbcType=VARCHAR}");
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

    protected void applyWhere(SQL sql, SpecificationDetailExample example, boolean includeExamplePhrase) {
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