package com.curou.oa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockExample() {
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

        public Criteria andStockIdIsNull() {
            addCriterion("stock_id is null");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNotNull() {
            addCriterion("stock_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockIdEqualTo(String value) {
            addCriterion("stock_id =", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(String value) {
            addCriterion("stock_id <>", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(String value) {
            addCriterion("stock_id >", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(String value) {
            addCriterion("stock_id >=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(String value) {
            addCriterion("stock_id <", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(String value) {
            addCriterion("stock_id <=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLike(String value) {
            addCriterion("stock_id like", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotLike(String value) {
            addCriterion("stock_id not like", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<String> values) {
            addCriterion("stock_id in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<String> values) {
            addCriterion("stock_id not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(String value1, String value2) {
            addCriterion("stock_id between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(String value1, String value2) {
            addCriterion("stock_id not between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNull() {
            addCriterion("stock_name is null");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNotNull() {
            addCriterion("stock_name is not null");
            return (Criteria) this;
        }

        public Criteria andStockNameEqualTo(String value) {
            addCriterion("stock_name =", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotEqualTo(String value) {
            addCriterion("stock_name <>", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThan(String value) {
            addCriterion("stock_name >", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThanOrEqualTo(String value) {
            addCriterion("stock_name >=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThan(String value) {
            addCriterion("stock_name <", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThanOrEqualTo(String value) {
            addCriterion("stock_name <=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLike(String value) {
            addCriterion("stock_name like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotLike(String value) {
            addCriterion("stock_name not like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameIn(List<String> values) {
            addCriterion("stock_name in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotIn(List<String> values) {
            addCriterion("stock_name not in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameBetween(String value1, String value2) {
            addCriterion("stock_name between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotBetween(String value1, String value2) {
            addCriterion("stock_name not between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNull() {
            addCriterion("stock_status is null");
            return (Criteria) this;
        }

        public Criteria andStockStatusIsNotNull() {
            addCriterion("stock_status is not null");
            return (Criteria) this;
        }

        public Criteria andStockStatusEqualTo(Integer value) {
            addCriterion("stock_status =", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotEqualTo(Integer value) {
            addCriterion("stock_status <>", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThan(Integer value) {
            addCriterion("stock_status >", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_status >=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThan(Integer value) {
            addCriterion("stock_status <", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusLessThanOrEqualTo(Integer value) {
            addCriterion("stock_status <=", value, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusIn(List<Integer> values) {
            addCriterion("stock_status in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotIn(List<Integer> values) {
            addCriterion("stock_status not in", values, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusBetween(Integer value1, Integer value2) {
            addCriterion("stock_status between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_status not between", value1, value2, "stockStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusIsNull() {
            addCriterion("stock_delete_status is null");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusIsNotNull() {
            addCriterion("stock_delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusEqualTo(Integer value) {
            addCriterion("stock_delete_status =", value, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusNotEqualTo(Integer value) {
            addCriterion("stock_delete_status <>", value, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusGreaterThan(Integer value) {
            addCriterion("stock_delete_status >", value, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("stock_delete_status >=", value, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusLessThan(Integer value) {
            addCriterion("stock_delete_status <", value, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("stock_delete_status <=", value, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusIn(List<Integer> values) {
            addCriterion("stock_delete_status in", values, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusNotIn(List<Integer> values) {
            addCriterion("stock_delete_status not in", values, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("stock_delete_status between", value1, value2, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("stock_delete_status not between", value1, value2, "stockDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcIsNull() {
            addCriterion("stock_create_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcIsNotNull() {
            addCriterion("stock_create_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcEqualTo(Date value) {
            addCriterion("stock_create_time_utc =", value, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcNotEqualTo(Date value) {
            addCriterion("stock_create_time_utc <>", value, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcGreaterThan(Date value) {
            addCriterion("stock_create_time_utc >", value, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("stock_create_time_utc >=", value, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcLessThan(Date value) {
            addCriterion("stock_create_time_utc <", value, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("stock_create_time_utc <=", value, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcIn(List<Date> values) {
            addCriterion("stock_create_time_utc in", values, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcNotIn(List<Date> values) {
            addCriterion("stock_create_time_utc not in", values, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcBetween(Date value1, Date value2) {
            addCriterion("stock_create_time_utc between", value1, value2, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("stock_create_time_utc not between", value1, value2, "stockCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcIsNull() {
            addCriterion("stock_modify_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcIsNotNull() {
            addCriterion("stock_modify_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcEqualTo(Date value) {
            addCriterion("stock_modify_time_utc =", value, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcNotEqualTo(Date value) {
            addCriterion("stock_modify_time_utc <>", value, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcGreaterThan(Date value) {
            addCriterion("stock_modify_time_utc >", value, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("stock_modify_time_utc >=", value, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcLessThan(Date value) {
            addCriterion("stock_modify_time_utc <", value, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("stock_modify_time_utc <=", value, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcIn(List<Date> values) {
            addCriterion("stock_modify_time_utc in", values, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcNotIn(List<Date> values) {
            addCriterion("stock_modify_time_utc not in", values, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcBetween(Date value1, Date value2) {
            addCriterion("stock_modify_time_utc between", value1, value2, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockModifyTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("stock_modify_time_utc not between", value1, value2, "stockModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdIsNull() {
            addCriterion("stock_create_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdIsNotNull() {
            addCriterion("stock_create_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdEqualTo(String value) {
            addCriterion("stock_create_employee_id =", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdNotEqualTo(String value) {
            addCriterion("stock_create_employee_id <>", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdGreaterThan(String value) {
            addCriterion("stock_create_employee_id >", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("stock_create_employee_id >=", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdLessThan(String value) {
            addCriterion("stock_create_employee_id <", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("stock_create_employee_id <=", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdLike(String value) {
            addCriterion("stock_create_employee_id like", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdNotLike(String value) {
            addCriterion("stock_create_employee_id not like", value, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdIn(List<String> values) {
            addCriterion("stock_create_employee_id in", values, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdNotIn(List<String> values) {
            addCriterion("stock_create_employee_id not in", values, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdBetween(String value1, String value2) {
            addCriterion("stock_create_employee_id between", value1, value2, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockCreateEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("stock_create_employee_id not between", value1, value2, "stockCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdIsNull() {
            addCriterion("stock_modify_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdIsNotNull() {
            addCriterion("stock_modify_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdEqualTo(String value) {
            addCriterion("stock_modify_employee_id =", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdNotEqualTo(String value) {
            addCriterion("stock_modify_employee_id <>", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdGreaterThan(String value) {
            addCriterion("stock_modify_employee_id >", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("stock_modify_employee_id >=", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdLessThan(String value) {
            addCriterion("stock_modify_employee_id <", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("stock_modify_employee_id <=", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdLike(String value) {
            addCriterion("stock_modify_employee_id like", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdNotLike(String value) {
            addCriterion("stock_modify_employee_id not like", value, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdIn(List<String> values) {
            addCriterion("stock_modify_employee_id in", values, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdNotIn(List<String> values) {
            addCriterion("stock_modify_employee_id not in", values, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdBetween(String value1, String value2) {
            addCriterion("stock_modify_employee_id between", value1, value2, "stockModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStockModifyEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("stock_modify_employee_id not between", value1, value2, "stockModifyEmployeeId");
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