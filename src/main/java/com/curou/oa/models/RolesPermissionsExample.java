package com.curou.oa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RolesPermissionsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RolesPermissionsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(String value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(String value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(String value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(String value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(String value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(String value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLike(String value) {
            addCriterion("role_id like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotLike(String value) {
            addCriterion("role_id not like", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<String> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<String> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(String value1, String value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(String value1, String value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNull() {
            addCriterion("perm_id is null");
            return (Criteria) this;
        }

        public Criteria andPermIdIsNotNull() {
            addCriterion("perm_id is not null");
            return (Criteria) this;
        }

        public Criteria andPermIdEqualTo(String value) {
            addCriterion("perm_id =", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotEqualTo(String value) {
            addCriterion("perm_id <>", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThan(String value) {
            addCriterion("perm_id >", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdGreaterThanOrEqualTo(String value) {
            addCriterion("perm_id >=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThan(String value) {
            addCriterion("perm_id <", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLessThanOrEqualTo(String value) {
            addCriterion("perm_id <=", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdLike(String value) {
            addCriterion("perm_id like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotLike(String value) {
            addCriterion("perm_id not like", value, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdIn(List<String> values) {
            addCriterion("perm_id in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotIn(List<String> values) {
            addCriterion("perm_id not in", values, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdBetween(String value1, String value2) {
            addCriterion("perm_id between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andPermIdNotBetween(String value1, String value2) {
            addCriterion("perm_id not between", value1, value2, "permId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcIsNull() {
            addCriterion("create_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcIsNotNull() {
            addCriterion("create_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcEqualTo(Date value) {
            addCriterion("create_time_utc =", value, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcNotEqualTo(Date value) {
            addCriterion("create_time_utc <>", value, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcGreaterThan(Date value) {
            addCriterion("create_time_utc >", value, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time_utc >=", value, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcLessThan(Date value) {
            addCriterion("create_time_utc <", value, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("create_time_utc <=", value, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcIn(List<Date> values) {
            addCriterion("create_time_utc in", values, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcNotIn(List<Date> values) {
            addCriterion("create_time_utc not in", values, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcBetween(Date value1, Date value2) {
            addCriterion("create_time_utc between", value1, value2, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("create_time_utc not between", value1, value2, "createTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcIsNull() {
            addCriterion("modify_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcIsNotNull() {
            addCriterion("modify_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcEqualTo(Date value) {
            addCriterion("modify_time_utc =", value, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcNotEqualTo(Date value) {
            addCriterion("modify_time_utc <>", value, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcGreaterThan(Date value) {
            addCriterion("modify_time_utc >", value, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("modify_time_utc >=", value, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcLessThan(Date value) {
            addCriterion("modify_time_utc <", value, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("modify_time_utc <=", value, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcIn(List<Date> values) {
            addCriterion("modify_time_utc in", values, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcNotIn(List<Date> values) {
            addCriterion("modify_time_utc not in", values, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcBetween(Date value1, Date value2) {
            addCriterion("modify_time_utc between", value1, value2, "modifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andModifyTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("modify_time_utc not between", value1, value2, "modifyTimeUtc");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}