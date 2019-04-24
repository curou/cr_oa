package com.curou.oa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReimburseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReimburseExample() {
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

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(String value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(String value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(String value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(String value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(String value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(String value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLike(String value) {
            addCriterion("amount like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotLike(String value) {
            addCriterion("amount not like", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<String> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<String> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(String value1, String value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(String value1, String value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andCreateEmployeeIdIsNull() {
            addCriterion("create_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdIsNotNull() {
            addCriterion("create_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdEqualTo(String value) {
            addCriterion("create_employee_id =", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdNotEqualTo(String value) {
            addCriterion("create_employee_id <>", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdGreaterThan(String value) {
            addCriterion("create_employee_id >", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("create_employee_id >=", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdLessThan(String value) {
            addCriterion("create_employee_id <", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("create_employee_id <=", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdLike(String value) {
            addCriterion("create_employee_id like", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdNotLike(String value) {
            addCriterion("create_employee_id not like", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdIn(List<String> values) {
            addCriterion("create_employee_id in", values, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdNotIn(List<String> values) {
            addCriterion("create_employee_id not in", values, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdBetween(String value1, String value2) {
            addCriterion("create_employee_id between", value1, value2, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("create_employee_id not between", value1, value2, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdIsNull() {
            addCriterion("modify_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdIsNotNull() {
            addCriterion("modify_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdEqualTo(String value) {
            addCriterion("modify_employee_id =", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdNotEqualTo(String value) {
            addCriterion("modify_employee_id <>", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdGreaterThan(String value) {
            addCriterion("modify_employee_id >", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("modify_employee_id >=", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdLessThan(String value) {
            addCriterion("modify_employee_id <", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("modify_employee_id <=", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdLike(String value) {
            addCriterion("modify_employee_id like", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdNotLike(String value) {
            addCriterion("modify_employee_id not like", value, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdIn(List<String> values) {
            addCriterion("modify_employee_id in", values, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdNotIn(List<String> values) {
            addCriterion("modify_employee_id not in", values, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdBetween(String value1, String value2) {
            addCriterion("modify_employee_id between", value1, value2, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andModifyEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("modify_employee_id not between", value1, value2, "modifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNull() {
            addCriterion("task_id is null");
            return (Criteria) this;
        }

        public Criteria andTaskIdIsNotNull() {
            addCriterion("task_id is not null");
            return (Criteria) this;
        }

        public Criteria andTaskIdEqualTo(String value) {
            addCriterion("task_id =", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotEqualTo(String value) {
            addCriterion("task_id <>", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThan(String value) {
            addCriterion("task_id >", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdGreaterThanOrEqualTo(String value) {
            addCriterion("task_id >=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThan(String value) {
            addCriterion("task_id <", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLessThanOrEqualTo(String value) {
            addCriterion("task_id <=", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdLike(String value) {
            addCriterion("task_id like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotLike(String value) {
            addCriterion("task_id not like", value, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdIn(List<String> values) {
            addCriterion("task_id in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotIn(List<String> values) {
            addCriterion("task_id not in", values, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdBetween(String value1, String value2) {
            addCriterion("task_id between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andTaskIdNotBetween(String value1, String value2) {
            addCriterion("task_id not between", value1, value2, "taskId");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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