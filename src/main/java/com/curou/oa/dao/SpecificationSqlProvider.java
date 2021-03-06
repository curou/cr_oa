package com.curou.oa.dao;

import com.curou.oa.models.Specification;
import com.curou.oa.models.SpecificationExample.Criteria;
import com.curou.oa.models.SpecificationExample.Criterion;
import com.curou.oa.models.SpecificationExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class SpecificationSqlProvider {

    public String countByExample(SpecificationExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("specification");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(SpecificationExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("specification");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Specification record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("specification");
        
        if (record.getSpecId() != null) {
            sql.VALUES("spec_id", "#{specId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecDeleteStatus() != null) {
            sql.VALUES("spec_delete_status", "#{specDeleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSpecName() != null) {
            sql.VALUES("spec_name", "#{specName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecSort() != null) {
            sql.VALUES("spec_sort", "#{specSort,jdbcType=INTEGER}");
        }
        
        if (record.getSpecCreateEmployeeId() != null) {
            sql.VALUES("spec_create_employee_id", "#{specCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecModifyEmployeeId() != null) {
            sql.VALUES("spec_modify_employee_id", "#{specModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecCreateTimeUtc() != null) {
            sql.VALUES("spec_create_time_utc", "#{specCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSpecModifyTimeUtc() != null) {
            sql.VALUES("spec_modify_time_utc", "#{specModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String selectByExample(SpecificationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("spec_id");
        } else {
            sql.SELECT("spec_id");
        }
        sql.SELECT("spec_delete_status");
        sql.SELECT("spec_name");
        sql.SELECT("spec_sort");
        sql.SELECT("spec_create_employee_id");
        sql.SELECT("spec_modify_employee_id");
        sql.SELECT("spec_create_time_utc");
        sql.SELECT("spec_modify_time_utc");
        sql.FROM("specification");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Specification record = (Specification) parameter.get("record");
        SpecificationExample example = (SpecificationExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("specification");
        
        if (record.getSpecId() != null) {
            sql.SET("spec_id = #{record.specId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecDeleteStatus() != null) {
            sql.SET("spec_delete_status = #{record.specDeleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSpecName() != null) {
            sql.SET("spec_name = #{record.specName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecSort() != null) {
            sql.SET("spec_sort = #{record.specSort,jdbcType=INTEGER}");
        }
        
        if (record.getSpecCreateEmployeeId() != null) {
            sql.SET("spec_create_employee_id = #{record.specCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecModifyEmployeeId() != null) {
            sql.SET("spec_modify_employee_id = #{record.specModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecCreateTimeUtc() != null) {
            sql.SET("spec_create_time_utc = #{record.specCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSpecModifyTimeUtc() != null) {
            sql.SET("spec_modify_time_utc = #{record.specModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("specification");
        
        sql.SET("spec_id = #{record.specId,jdbcType=VARCHAR}");
        sql.SET("spec_delete_status = #{record.specDeleteStatus,jdbcType=INTEGER}");
        sql.SET("spec_name = #{record.specName,jdbcType=VARCHAR}");
        sql.SET("spec_sort = #{record.specSort,jdbcType=INTEGER}");
        sql.SET("spec_create_employee_id = #{record.specCreateEmployeeId,jdbcType=VARCHAR}");
        sql.SET("spec_modify_employee_id = #{record.specModifyEmployeeId,jdbcType=VARCHAR}");
        sql.SET("spec_create_time_utc = #{record.specCreateTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("spec_modify_time_utc = #{record.specModifyTimeUtc,jdbcType=TIMESTAMP}");
        
        SpecificationExample example = (SpecificationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Specification record) {
        SQL sql = new SQL();
        sql.UPDATE("specification");
        
        if (record.getSpecDeleteStatus() != null) {
            sql.SET("spec_delete_status = #{specDeleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getSpecName() != null) {
            sql.SET("spec_name = #{specName,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecSort() != null) {
            sql.SET("spec_sort = #{specSort,jdbcType=INTEGER}");
        }
        
        if (record.getSpecCreateEmployeeId() != null) {
            sql.SET("spec_create_employee_id = #{specCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecModifyEmployeeId() != null) {
            sql.SET("spec_modify_employee_id = #{specModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecCreateTimeUtc() != null) {
            sql.SET("spec_create_time_utc = #{specCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getSpecModifyTimeUtc() != null) {
            sql.SET("spec_modify_time_utc = #{specModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("spec_id = #{specId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, SpecificationExample example, boolean includeExamplePhrase) {
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