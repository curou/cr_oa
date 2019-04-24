package com.curou.oa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpecificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpecificationExample() {
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

        public Criteria andSpecIdIsNull() {
            addCriterion("spec_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecIdIsNotNull() {
            addCriterion("spec_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecIdEqualTo(String value) {
            addCriterion("spec_id =", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotEqualTo(String value) {
            addCriterion("spec_id <>", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdGreaterThan(String value) {
            addCriterion("spec_id >", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdGreaterThanOrEqualTo(String value) {
            addCriterion("spec_id >=", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLessThan(String value) {
            addCriterion("spec_id <", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLessThanOrEqualTo(String value) {
            addCriterion("spec_id <=", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdLike(String value) {
            addCriterion("spec_id like", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotLike(String value) {
            addCriterion("spec_id not like", value, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdIn(List<String> values) {
            addCriterion("spec_id in", values, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotIn(List<String> values) {
            addCriterion("spec_id not in", values, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdBetween(String value1, String value2) {
            addCriterion("spec_id between", value1, value2, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecIdNotBetween(String value1, String value2) {
            addCriterion("spec_id not between", value1, value2, "specId");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusIsNull() {
            addCriterion("spec_delete_status is null");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusIsNotNull() {
            addCriterion("spec_delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusEqualTo(Integer value) {
            addCriterion("spec_delete_status =", value, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusNotEqualTo(Integer value) {
            addCriterion("spec_delete_status <>", value, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusGreaterThan(Integer value) {
            addCriterion("spec_delete_status >", value, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_delete_status >=", value, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusLessThan(Integer value) {
            addCriterion("spec_delete_status <", value, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("spec_delete_status <=", value, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusIn(List<Integer> values) {
            addCriterion("spec_delete_status in", values, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusNotIn(List<Integer> values) {
            addCriterion("spec_delete_status not in", values, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("spec_delete_status between", value1, value2, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_delete_status not between", value1, value2, "specDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andSpecNameIsNull() {
            addCriterion("spec_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecNameIsNotNull() {
            addCriterion("spec_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecNameEqualTo(String value) {
            addCriterion("spec_name =", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotEqualTo(String value) {
            addCriterion("spec_name <>", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThan(String value) {
            addCriterion("spec_name >", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThanOrEqualTo(String value) {
            addCriterion("spec_name >=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThan(String value) {
            addCriterion("spec_name <", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThanOrEqualTo(String value) {
            addCriterion("spec_name <=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLike(String value) {
            addCriterion("spec_name like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotLike(String value) {
            addCriterion("spec_name not like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameIn(List<String> values) {
            addCriterion("spec_name in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotIn(List<String> values) {
            addCriterion("spec_name not in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameBetween(String value1, String value2) {
            addCriterion("spec_name between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotBetween(String value1, String value2) {
            addCriterion("spec_name not between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecSortIsNull() {
            addCriterion("spec_sort is null");
            return (Criteria) this;
        }

        public Criteria andSpecSortIsNotNull() {
            addCriterion("spec_sort is not null");
            return (Criteria) this;
        }

        public Criteria andSpecSortEqualTo(Integer value) {
            addCriterion("spec_sort =", value, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortNotEqualTo(Integer value) {
            addCriterion("spec_sort <>", value, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortGreaterThan(Integer value) {
            addCriterion("spec_sort >", value, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("spec_sort >=", value, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortLessThan(Integer value) {
            addCriterion("spec_sort <", value, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortLessThanOrEqualTo(Integer value) {
            addCriterion("spec_sort <=", value, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortIn(List<Integer> values) {
            addCriterion("spec_sort in", values, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortNotIn(List<Integer> values) {
            addCriterion("spec_sort not in", values, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortBetween(Integer value1, Integer value2) {
            addCriterion("spec_sort between", value1, value2, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecSortNotBetween(Integer value1, Integer value2) {
            addCriterion("spec_sort not between", value1, value2, "specSort");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdIsNull() {
            addCriterion("spec_create_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdIsNotNull() {
            addCriterion("spec_create_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdEqualTo(String value) {
            addCriterion("spec_create_employee_id =", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdNotEqualTo(String value) {
            addCriterion("spec_create_employee_id <>", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdGreaterThan(String value) {
            addCriterion("spec_create_employee_id >", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("spec_create_employee_id >=", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdLessThan(String value) {
            addCriterion("spec_create_employee_id <", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("spec_create_employee_id <=", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdLike(String value) {
            addCriterion("spec_create_employee_id like", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdNotLike(String value) {
            addCriterion("spec_create_employee_id not like", value, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdIn(List<String> values) {
            addCriterion("spec_create_employee_id in", values, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdNotIn(List<String> values) {
            addCriterion("spec_create_employee_id not in", values, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdBetween(String value1, String value2) {
            addCriterion("spec_create_employee_id between", value1, value2, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("spec_create_employee_id not between", value1, value2, "specCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdIsNull() {
            addCriterion("spec_modify_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdIsNotNull() {
            addCriterion("spec_modify_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdEqualTo(String value) {
            addCriterion("spec_modify_employee_id =", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdNotEqualTo(String value) {
            addCriterion("spec_modify_employee_id <>", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdGreaterThan(String value) {
            addCriterion("spec_modify_employee_id >", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("spec_modify_employee_id >=", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdLessThan(String value) {
            addCriterion("spec_modify_employee_id <", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("spec_modify_employee_id <=", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdLike(String value) {
            addCriterion("spec_modify_employee_id like", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdNotLike(String value) {
            addCriterion("spec_modify_employee_id not like", value, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdIn(List<String> values) {
            addCriterion("spec_modify_employee_id in", values, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdNotIn(List<String> values) {
            addCriterion("spec_modify_employee_id not in", values, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdBetween(String value1, String value2) {
            addCriterion("spec_modify_employee_id between", value1, value2, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecModifyEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("spec_modify_employee_id not between", value1, value2, "specModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcIsNull() {
            addCriterion("spec_create_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcIsNotNull() {
            addCriterion("spec_create_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcEqualTo(Date value) {
            addCriterion("spec_create_time_utc =", value, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcNotEqualTo(Date value) {
            addCriterion("spec_create_time_utc <>", value, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcGreaterThan(Date value) {
            addCriterion("spec_create_time_utc >", value, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("spec_create_time_utc >=", value, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcLessThan(Date value) {
            addCriterion("spec_create_time_utc <", value, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("spec_create_time_utc <=", value, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcIn(List<Date> values) {
            addCriterion("spec_create_time_utc in", values, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcNotIn(List<Date> values) {
            addCriterion("spec_create_time_utc not in", values, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcBetween(Date value1, Date value2) {
            addCriterion("spec_create_time_utc between", value1, value2, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecCreateTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("spec_create_time_utc not between", value1, value2, "specCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcIsNull() {
            addCriterion("spec_modify_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcIsNotNull() {
            addCriterion("spec_modify_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcEqualTo(Date value) {
            addCriterion("spec_modify_time_utc =", value, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcNotEqualTo(Date value) {
            addCriterion("spec_modify_time_utc <>", value, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcGreaterThan(Date value) {
            addCriterion("spec_modify_time_utc >", value, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("spec_modify_time_utc >=", value, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcLessThan(Date value) {
            addCriterion("spec_modify_time_utc <", value, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("spec_modify_time_utc <=", value, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcIn(List<Date> values) {
            addCriterion("spec_modify_time_utc in", values, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcNotIn(List<Date> values) {
            addCriterion("spec_modify_time_utc not in", values, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcBetween(Date value1, Date value2) {
            addCriterion("spec_modify_time_utc between", value1, value2, "specModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andSpecModifyTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("spec_modify_time_utc not between", value1, value2, "specModifyTimeUtc");
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