package com.curou.oa.dao;

import com.curou.oa.models.Menu;
import com.curou.oa.models.MenuExample.Criteria;
import com.curou.oa.models.MenuExample.Criterion;
import com.curou.oa.models.MenuExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class MenuSqlProvider {

    public String countByExample(MenuExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(MenuExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("menu");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Menu record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("menu");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.VALUES("title", "#{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.VALUES("icon", "#{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.VALUES("path", "#{path,jdbcType=VARCHAR}");
        }
        
        if (record.getPermissionId() != null) {
            sql.VALUES("permission_id", "#{permissionId,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.VALUES("pid", "#{pid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(MenuExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("title");
        sql.SELECT("icon");
        sql.SELECT("path");
        sql.SELECT("permission_id");
        sql.SELECT("pid");
        sql.FROM("menu");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Menu record = (Menu) parameter.get("record");
        MenuExample example = (MenuExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("menu");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        }
        
        if (record.getTitle() != null) {
            sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("path = #{record.path,jdbcType=VARCHAR}");
        }
        
        if (record.getPermissionId() != null) {
            sql.SET("permission_id = #{record.permissionId,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{record.pid,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("menu");
        
        sql.SET("id = #{record.id,jdbcType=VARCHAR}");
        sql.SET("title = #{record.title,jdbcType=VARCHAR}");
        sql.SET("icon = #{record.icon,jdbcType=VARCHAR}");
        sql.SET("path = #{record.path,jdbcType=VARCHAR}");
        sql.SET("permission_id = #{record.permissionId,jdbcType=VARCHAR}");
        sql.SET("pid = #{record.pid,jdbcType=VARCHAR}");
        
        MenuExample example = (MenuExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Menu record) {
        SQL sql = new SQL();
        sql.UPDATE("menu");
        
        if (record.getTitle() != null) {
            sql.SET("title = #{title,jdbcType=VARCHAR}");
        }
        
        if (record.getIcon() != null) {
            sql.SET("icon = #{icon,jdbcType=VARCHAR}");
        }
        
        if (record.getPath() != null) {
            sql.SET("path = #{path,jdbcType=VARCHAR}");
        }
        
        if (record.getPermissionId() != null) {
            sql.SET("permission_id = #{permissionId,jdbcType=VARCHAR}");
        }
        
        if (record.getPid() != null) {
            sql.SET("pid = #{pid,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=VARCHAR}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, MenuExample example, boolean includeExamplePhrase) {
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