package com.curou.oa.dao;

import com.curou.oa.models.ProductUnit;
import com.curou.oa.models.ProductUnitExample.Criteria;
import com.curou.oa.models.ProductUnitExample.Criterion;
import com.curou.oa.models.ProductUnitExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductUnitSqlProvider {

    public String countByExample(ProductUnitExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("product_unit");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProductUnitExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("product_unit");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ProductUnit record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_unit");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            sql.VALUES("value", "#{value,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.VALUES("create_time_utc", "#{createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.VALUES("modify_time_utc", "#{modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateEmployeeId() != null) {
            sql.VALUES("create_employee_id", "#{createEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyEmployeeId() != null) {
            sql.VALUES("modify_employee_id", "#{modifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ProductUnitExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("value");
        sql.SELECT("create_time_utc");
        sql.SELECT("modify_time_utc");
        sql.SELECT("create_employee_id");
        sql.SELECT("modify_employee_id");
        sql.FROM("product_unit");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProductUnit record = (ProductUnit) parameter.get("record");
        ProductUnitExample example = (ProductUnitExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("product_unit");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getValue() != null) {
            sql.SET("value = #{record.value,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateEmployeeId() != null) {
            sql.SET("create_employee_id = #{record.createEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyEmployeeId() != null) {
            sql.SET("modify_employee_id = #{record.modifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product_unit");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("value = #{record.value,jdbcType=VARCHAR}");
        sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("create_employee_id = #{record.createEmployeeId,jdbcType=VARCHAR}");
        sql.SET("modify_employee_id = #{record.modifyEmployeeId,jdbcType=VARCHAR}");
        
        ProductUnitExample example = (ProductUnitExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProductUnit record) {
        SQL sql = new SQL();
        sql.UPDATE("product_unit");
        
        if (record.getValue() != null) {
            sql.SET("value = #{value,jdbcType=VARCHAR}");
        }
        
        if (record.getCreateTimeUtc() != null) {
            sql.SET("create_time_utc = #{createTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getModifyTimeUtc() != null) {
            sql.SET("modify_time_utc = #{modifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getCreateEmployeeId() != null) {
            sql.SET("create_employee_id = #{createEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getModifyEmployeeId() != null) {
            sql.SET("modify_employee_id = #{modifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProductUnitExample example, boolean includeExamplePhrase) {
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