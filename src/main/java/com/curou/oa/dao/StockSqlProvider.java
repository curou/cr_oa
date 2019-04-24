package com.curou.oa.dao;

import com.curou.oa.models.Stock;
import com.curou.oa.models.StockExample;
import com.curou.oa.models.StockExample.Criteria;
import com.curou.oa.models.StockExample.Criterion;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

public class StockSqlProvider {

    public String countByExample(StockExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("stock");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(StockExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("stock");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Stock record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("stock");
        
        if (record.getStockId() != null) {
            sql.VALUES("stock_id", "#{stockId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockName() != null) {
            sql.VALUES("stock_name", "#{stockName,jdbcType=VARCHAR}");
        }
        
        if (record.getStockStatus() != null) {
            sql.VALUES("stock_status", "#{stockStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStockDeleteStatus() != null) {
            sql.VALUES("stock_delete_status", "#{stockDeleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStockCreateTimeUtc() != null) {
            sql.VALUES("stock_create_time_utc", "#{stockCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStockModifyTimeUtc() != null) {
            sql.VALUES("stock_modify_time_utc", "#{stockModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStockCreateEmployeeId() != null) {
            sql.VALUES("stock_create_employee_id", "#{stockCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockModifyEmployeeId() != null) {
            sql.VALUES("stock_modify_employee_id", "#{stockModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(StockExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("stock_id");
        } else {
            sql.SELECT("stock_id");
        }
        sql.SELECT("stock_name");
        sql.SELECT("stock_status");
        sql.SELECT("stock_delete_status");
        sql.SELECT("stock_create_time_utc");
        sql.SELECT("stock_modify_time_utc");
        sql.SELECT("stock_create_employee_id");
        sql.SELECT("stock_modify_employee_id");
        sql.FROM("stock");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Stock record = (Stock) parameter.get("record");
        StockExample example = (StockExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("stock");
        
        if (record.getStockId() != null) {
            sql.SET("stock_id = #{record.stockId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockName() != null) {
            sql.SET("stock_name = #{record.stockName,jdbcType=VARCHAR}");
        }
        
        if (record.getStockStatus() != null) {
            sql.SET("stock_status = #{record.stockStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStockDeleteStatus() != null) {
            sql.SET("stock_delete_status = #{record.stockDeleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStockCreateTimeUtc() != null) {
            sql.SET("stock_create_time_utc = #{record.stockCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStockModifyTimeUtc() != null) {
            sql.SET("stock_modify_time_utc = #{record.stockModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStockCreateEmployeeId() != null) {
            sql.SET("stock_create_employee_id = #{record.stockCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockModifyEmployeeId() != null) {
            sql.SET("stock_modify_employee_id = #{record.stockModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("stock");
        
        sql.SET("stock_id = #{record.stockId,jdbcType=VARCHAR}");
        sql.SET("stock_name = #{record.stockName,jdbcType=VARCHAR}");
        sql.SET("stock_status = #{record.stockStatus,jdbcType=INTEGER}");
        sql.SET("stock_delete_status = #{record.stockDeleteStatus,jdbcType=INTEGER}");
        sql.SET("stock_create_time_utc = #{record.stockCreateTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("stock_modify_time_utc = #{record.stockModifyTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("stock_create_employee_id = #{record.stockCreateEmployeeId,jdbcType=VARCHAR}");
        sql.SET("stock_modify_employee_id = #{record.stockModifyEmployeeId,jdbcType=VARCHAR}");
        
        StockExample example = (StockExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Stock record) {
        SQL sql = new SQL();
        sql.UPDATE("stock");
        
        if (record.getStockName() != null) {
            sql.SET("stock_name = #{stockName,jdbcType=VARCHAR}");
        }
        
        if (record.getStockStatus() != null) {
            sql.SET("stock_status = #{stockStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStockDeleteStatus() != null) {
            sql.SET("stock_delete_status = #{stockDeleteStatus,jdbcType=INTEGER}");
        }
        
        if (record.getStockCreateTimeUtc() != null) {
            sql.SET("stock_create_time_utc = #{stockCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStockModifyTimeUtc() != null) {
            sql.SET("stock_modify_time_utc = #{stockModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStockCreateEmployeeId() != null) {
            sql.SET("stock_create_employee_id = #{stockCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockModifyEmployeeId() != null) {
            sql.SET("stock_modify_employee_id = #{stockModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("stock_id = #{stockId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, StockExample example, boolean includeExamplePhrase) {
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