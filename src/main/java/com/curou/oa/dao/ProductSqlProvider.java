package com.curou.oa.dao;

import com.curou.oa.models.Product;
import com.curou.oa.models.ProductExample.Criteria;
import com.curou.oa.models.ProductExample.Criterion;
import com.curou.oa.models.ProductExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {

    public String countByExample(ProductExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("product");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProductExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("product");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Product record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product");
        
        if (record.getProductId() != null) {
            sql.VALUES("product_id", "#{productId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductNumber() != null) {
            sql.VALUES("product_number", "#{productNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getProductDeleteStatus() != null) {
            sql.VALUES("product_delete_status", "#{productDeleteStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getProductInventory() != null) {
            sql.VALUES("product_inventory", "#{productInventory,jdbcType=DECIMAL}");
        }
        
        if (record.getProductName() != null) {
            sql.VALUES("product_name", "#{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.VALUES("product_price", "#{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductStatus() != null) {
            sql.VALUES("product_status", "#{productStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCostPrice() != null) {
            sql.VALUES("product_cost_price", "#{productCostPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductSellPrice() != null) {
            sql.VALUES("product_sell_price", "#{productSellPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductUnits() != null) {
            sql.VALUES("product_units", "#{productUnits,jdbcType=VARCHAR}");
        }
        
        if (record.getProductUpperLimit() != null) {
            sql.VALUES("product_upper_limit", "#{productUpperLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getProductLowerLimit() != null) {
            sql.VALUES("product_lower_limit", "#{productLowerLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getProductWarningStatus() != null) {
            sql.VALUES("product_warning_status", "#{productWarningStatus,jdbcType=INTEGER}");
        }
        
        if (record.getProductCreateEmployeeId() != null) {
            sql.VALUES("product_create_employee_id", "#{productCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductModifyEmployeeId() != null) {
            sql.VALUES("product_modify_employee_id", "#{productModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCreateTimeUtc() != null) {
            sql.VALUES("product_create_time_utc", "#{productCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductModifyTimeUtc() != null) {
            sql.VALUES("product_modify_time_utc", "#{productModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductRemarks() != null) {
            sql.VALUES("product_remarks", "#{productRemarks,jdbcType=VARCHAR}");
        }
        
        if (record.getProductInventoryDetail() != null) {
            sql.VALUES("product_inventory_detail", "#{productInventoryDetail,jdbcType=LONGVARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExampleWithBLOBs(ProductExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("product_id");
        } else {
            sql.SELECT("product_id");
        }
        sql.SELECT("product_number");
        sql.SELECT("product_delete_status");
        sql.SELECT("product_inventory");
        sql.SELECT("product_name");
        sql.SELECT("product_price");
        sql.SELECT("product_status");
        sql.SELECT("product_cost_price");
        sql.SELECT("product_sell_price");
        sql.SELECT("product_units");
        sql.SELECT("product_upper_limit");
        sql.SELECT("product_lower_limit");
        sql.SELECT("product_warning_status");
        sql.SELECT("product_create_employee_id");
        sql.SELECT("product_modify_employee_id");
        sql.SELECT("product_create_time_utc");
        sql.SELECT("product_modify_time_utc");
        sql.SELECT("product_remarks");
        sql.SELECT("product_inventory_detail");
        sql.FROM("product");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String selectByExample(ProductExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("product_id");
        } else {
            sql.SELECT("product_id");
        }
        sql.SELECT("product_number");
        sql.SELECT("product_delete_status");
        sql.SELECT("product_inventory");
        sql.SELECT("product_name");
        sql.SELECT("product_price");
        sql.SELECT("product_status");
        sql.SELECT("product_cost_price");
        sql.SELECT("product_sell_price");
        sql.SELECT("product_units");
        sql.SELECT("product_upper_limit");
        sql.SELECT("product_lower_limit");
        sql.SELECT("product_warning_status");
        sql.SELECT("product_create_employee_id");
        sql.SELECT("product_modify_employee_id");
        sql.SELECT("product_create_time_utc");
        sql.SELECT("product_modify_time_utc");
        sql.SELECT("product_remarks");
        sql.FROM("product");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Product record = (Product) parameter.get("record");
        ProductExample example = (ProductExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getProductId() != null) {
            sql.SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductNumber() != null) {
            sql.SET("product_number = #{record.productNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getProductDeleteStatus() != null) {
            sql.SET("product_delete_status = #{record.productDeleteStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getProductInventory() != null) {
            sql.SET("product_inventory = #{record.productInventory,jdbcType=DECIMAL}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{record.productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductStatus() != null) {
            sql.SET("product_status = #{record.productStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCostPrice() != null) {
            sql.SET("product_cost_price = #{record.productCostPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductSellPrice() != null) {
            sql.SET("product_sell_price = #{record.productSellPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductUnits() != null) {
            sql.SET("product_units = #{record.productUnits,jdbcType=VARCHAR}");
        }
        
        if (record.getProductUpperLimit() != null) {
            sql.SET("product_upper_limit = #{record.productUpperLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getProductLowerLimit() != null) {
            sql.SET("product_lower_limit = #{record.productLowerLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getProductWarningStatus() != null) {
            sql.SET("product_warning_status = #{record.productWarningStatus,jdbcType=INTEGER}");
        }
        
        if (record.getProductCreateEmployeeId() != null) {
            sql.SET("product_create_employee_id = #{record.productCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductModifyEmployeeId() != null) {
            sql.SET("product_modify_employee_id = #{record.productModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCreateTimeUtc() != null) {
            sql.SET("product_create_time_utc = #{record.productCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductModifyTimeUtc() != null) {
            sql.SET("product_modify_time_utc = #{record.productModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductRemarks() != null) {
            sql.SET("product_remarks = #{record.productRemarks,jdbcType=VARCHAR}");
        }
        
        if (record.getProductInventoryDetail() != null) {
            sql.SET("product_inventory_detail = #{record.productInventoryDetail,jdbcType=LONGVARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExampleWithBLOBs(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        sql.SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        sql.SET("product_number = #{record.productNumber,jdbcType=VARCHAR}");
        sql.SET("product_delete_status = #{record.productDeleteStatus,jdbcType=VARCHAR}");
        sql.SET("product_inventory = #{record.productInventory,jdbcType=DECIMAL}");
        sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        sql.SET("product_price = #{record.productPrice,jdbcType=DECIMAL}");
        sql.SET("product_status = #{record.productStatus,jdbcType=VARCHAR}");
        sql.SET("product_cost_price = #{record.productCostPrice,jdbcType=DECIMAL}");
        sql.SET("product_sell_price = #{record.productSellPrice,jdbcType=DECIMAL}");
        sql.SET("product_units = #{record.productUnits,jdbcType=VARCHAR}");
        sql.SET("product_upper_limit = #{record.productUpperLimit,jdbcType=DECIMAL}");
        sql.SET("product_lower_limit = #{record.productLowerLimit,jdbcType=DECIMAL}");
        sql.SET("product_warning_status = #{record.productWarningStatus,jdbcType=INTEGER}");
        sql.SET("product_create_employee_id = #{record.productCreateEmployeeId,jdbcType=VARCHAR}");
        sql.SET("product_modify_employee_id = #{record.productModifyEmployeeId,jdbcType=VARCHAR}");
        sql.SET("product_create_time_utc = #{record.productCreateTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("product_modify_time_utc = #{record.productModifyTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("product_remarks = #{record.productRemarks,jdbcType=VARCHAR}");
        sql.SET("product_inventory_detail = #{record.productInventoryDetail,jdbcType=LONGVARCHAR}");
        
        ProductExample example = (ProductExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        sql.SET("product_id = #{record.productId,jdbcType=VARCHAR}");
        sql.SET("product_number = #{record.productNumber,jdbcType=VARCHAR}");
        sql.SET("product_delete_status = #{record.productDeleteStatus,jdbcType=VARCHAR}");
        sql.SET("product_inventory = #{record.productInventory,jdbcType=DECIMAL}");
        sql.SET("product_name = #{record.productName,jdbcType=VARCHAR}");
        sql.SET("product_price = #{record.productPrice,jdbcType=DECIMAL}");
        sql.SET("product_status = #{record.productStatus,jdbcType=VARCHAR}");
        sql.SET("product_cost_price = #{record.productCostPrice,jdbcType=DECIMAL}");
        sql.SET("product_sell_price = #{record.productSellPrice,jdbcType=DECIMAL}");
        sql.SET("product_units = #{record.productUnits,jdbcType=VARCHAR}");
        sql.SET("product_upper_limit = #{record.productUpperLimit,jdbcType=DECIMAL}");
        sql.SET("product_lower_limit = #{record.productLowerLimit,jdbcType=DECIMAL}");
        sql.SET("product_warning_status = #{record.productWarningStatus,jdbcType=INTEGER}");
        sql.SET("product_create_employee_id = #{record.productCreateEmployeeId,jdbcType=VARCHAR}");
        sql.SET("product_modify_employee_id = #{record.productModifyEmployeeId,jdbcType=VARCHAR}");
        sql.SET("product_create_time_utc = #{record.productCreateTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("product_modify_time_utc = #{record.productModifyTimeUtc,jdbcType=TIMESTAMP}");
        sql.SET("product_remarks = #{record.productRemarks,jdbcType=VARCHAR}");
        
        ProductExample example = (ProductExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Product record) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getProductNumber() != null) {
            sql.SET("product_number = #{productNumber,jdbcType=VARCHAR}");
        }
        
        if (record.getProductDeleteStatus() != null) {
            sql.SET("product_delete_status = #{productDeleteStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getProductInventory() != null) {
            sql.SET("product_inventory = #{productInventory,jdbcType=DECIMAL}");
        }
        
        if (record.getProductName() != null) {
            sql.SET("product_name = #{productName,jdbcType=VARCHAR}");
        }
        
        if (record.getProductPrice() != null) {
            sql.SET("product_price = #{productPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductStatus() != null) {
            sql.SET("product_status = #{productStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCostPrice() != null) {
            sql.SET("product_cost_price = #{productCostPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductSellPrice() != null) {
            sql.SET("product_sell_price = #{productSellPrice,jdbcType=DECIMAL}");
        }
        
        if (record.getProductUnits() != null) {
            sql.SET("product_units = #{productUnits,jdbcType=VARCHAR}");
        }
        
        if (record.getProductUpperLimit() != null) {
            sql.SET("product_upper_limit = #{productUpperLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getProductLowerLimit() != null) {
            sql.SET("product_lower_limit = #{productLowerLimit,jdbcType=DECIMAL}");
        }
        
        if (record.getProductWarningStatus() != null) {
            sql.SET("product_warning_status = #{productWarningStatus,jdbcType=INTEGER}");
        }
        
        if (record.getProductCreateEmployeeId() != null) {
            sql.SET("product_create_employee_id = #{productCreateEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductModifyEmployeeId() != null) {
            sql.SET("product_modify_employee_id = #{productModifyEmployeeId,jdbcType=VARCHAR}");
        }
        
        if (record.getProductCreateTimeUtc() != null) {
            sql.SET("product_create_time_utc = #{productCreateTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductModifyTimeUtc() != null) {
            sql.SET("product_modify_time_utc = #{productModifyTimeUtc,jdbcType=TIMESTAMP}");
        }
        
        if (record.getProductRemarks() != null) {
            sql.SET("product_remarks = #{productRemarks,jdbcType=VARCHAR}");
        }
        
        if (record.getProductInventoryDetail() != null) {
            sql.SET("product_inventory_detail = #{productInventoryDetail,jdbcType=LONGVARCHAR}");
        }
        
        sql.WHERE("product_id = #{productId,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProductExample example, boolean includeExamplePhrase) {
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