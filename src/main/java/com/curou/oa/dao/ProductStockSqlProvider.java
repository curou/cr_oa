package com.curou.oa.dao;

import com.curou.oa.models.ProductStock;
import com.curou.oa.models.ProductStockExample.Criteria;
import com.curou.oa.models.ProductStockExample.Criterion;
import com.curou.oa.models.ProductStockExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductStockSqlProvider {

    public String countByExample(ProductStockExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("product_stock");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProductStockExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("product_stock");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ProductStock record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product_stock");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockId() != null) {
            sql.VALUES("stock_id", "#{stockId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecDetail() != null) {
            sql.VALUES("spec_detail", "#{specDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            sql.VALUES("unit", "#{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getCount() != null) {
            sql.VALUES("count", "#{count,jdbcType=BIGINT}");
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

    public String selectByExample(ProductStockExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("product_id");
        sql.SELECT("stock_id");
        sql.SELECT("spec_detail");
        sql.SELECT("unit");
        sql.SELECT("count");
        sql.SELECT("create_time_utc");
        sql.SELECT("modify_time_utc");
        sql.SELECT("create_employee_id");
        sql.SELECT("modify_employee_id");
        sql.FROM("product_stock");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ProductStock record = (ProductStock) parameter.get("record");
        ProductStockExample example = (ProductStockExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("product_stock");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockId() != null) {
            sql.SET("stock_id = #{record.stockId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecDetail() != null) {
            sql.SET("spec_detail = #{record.specDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            sql.SET("unit = #{record.unit,jdbcType=VARCHAR}");
        }
        
        if (record.getCount() != null) {
            sql.SET("count = #{record.count,jdbcType=BIGINT}");
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
        sql.UPDATE("product_stock");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        sql.SET("stock_id = #{record.stockId,jdbcType=VARCHAR}");
        sql.SET("spec_detail = #{record.specDetail,jdbcType=VARCHAR}");
        sql.SET("unit = #{record.unit,jdbcType=VARCHAR}");
        sql.SET("count = #{record.count,jdbcType=BIGINT}");
        sql.SET("create_time_utc = #{record.createTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("modify_time_utc = #{record.modifyTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("create_employee_id = #{record.createEmployeeId,jdbcType=VARCHAR}");
        sql.SET("modify_employee_id = #{record.modifyEmployeeId,jdbcType=VARCHAR}");
        
        ProductStockExample example = (ProductStockExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ProductStock record) {
        SQL sql = new SQL();
        sql.UPDATE("product_stock");
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getStockId() != null) {
            sql.SET("stock_id = #{stockId,jdbcType=VARCHAR}");
        }
        
        if (record.getSpecDetail() != null) {
            sql.SET("spec_detail = #{specDetail,jdbcType=VARCHAR}");
        }
        
        if (record.getUnit() != null) {
            sql.SET("unit = #{unit,jdbcType=VARCHAR}");
        }
        
        if (record.getCount() != null) {
            sql.SET("count = #{count,jdbcType=BIGINT}");
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

    protected void applyWhere(SQL sql, ProductStockExample example, boolean includeExamplePhrase) {
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