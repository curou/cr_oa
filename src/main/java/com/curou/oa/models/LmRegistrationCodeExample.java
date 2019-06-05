package com.curou.oa.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LmRegistrationCodeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LmRegistrationCodeExample() {
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

        public Criteria andCardTypeIsNull() {
            addCriterion("card_type is null");
            return (Criteria) this;
        }

        public Criteria andCardTypeIsNotNull() {
            addCriterion("card_type is not null");
            return (Criteria) this;
        }

        public Criteria andCardTypeEqualTo(String value) {
            addCriterion("card_type =", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotEqualTo(String value) {
            addCriterion("card_type <>", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThan(String value) {
            addCriterion("card_type >", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeGreaterThanOrEqualTo(String value) {
            addCriterion("card_type >=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThan(String value) {
            addCriterion("card_type <", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLessThanOrEqualTo(String value) {
            addCriterion("card_type <=", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeLike(String value) {
            addCriterion("card_type like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotLike(String value) {
            addCriterion("card_type not like", value, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeIn(List<String> values) {
            addCriterion("card_type in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotIn(List<String> values) {
            addCriterion("card_type not in", values, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeBetween(String value1, String value2) {
            addCriterion("card_type between", value1, value2, "cardType");
            return (Criteria) this;
        }

        public Criteria andCardTypeNotBetween(String value1, String value2) {
            addCriterion("card_type not between", value1, value2, "cardType");
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

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNull() {
            addCriterion("expiration_time is null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIsNotNull() {
            addCriterion("expiration_time is not null");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeEqualTo(Date value) {
            addCriterion("expiration_time =", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotEqualTo(Date value) {
            addCriterion("expiration_time <>", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThan(Date value) {
            addCriterion("expiration_time >", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("expiration_time >=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThan(Date value) {
            addCriterion("expiration_time <", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeLessThanOrEqualTo(Date value) {
            addCriterion("expiration_time <=", value, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeIn(List<Date> values) {
            addCriterion("expiration_time in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotIn(List<Date> values) {
            addCriterion("expiration_time not in", values, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeBetween(Date value1, Date value2) {
            addCriterion("expiration_time between", value1, value2, "expirationTime");
            return (Criteria) this;
        }

        public Criteria andExpirationTimeNotBetween(Date value1, Date value2) {
            addCriterion("expiration_time not between", value1, value2, "expirationTime");
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNull() {
            addCriterion("pro_type is null");
            return (Criteria) this;
        }

        public Criteria andProTypeIsNotNull() {
            addCriterion("pro_type is not null");
            return (Criteria) this;
        }

        public Criteria andProTypeEqualTo(String value) {
            addCriterion("pro_type =", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotEqualTo(String value) {
            addCriterion("pro_type <>", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThan(String value) {
            addCriterion("pro_type >", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pro_type >=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThan(String value) {
            addCriterion("pro_type <", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLessThanOrEqualTo(String value) {
            addCriterion("pro_type <=", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeLike(String value) {
            addCriterion("pro_type like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotLike(String value) {
            addCriterion("pro_type not like", value, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeIn(List<String> values) {
            addCriterion("pro_type in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotIn(List<String> values) {
            addCriterion("pro_type not in", values, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeBetween(String value1, String value2) {
            addCriterion("pro_type between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andProTypeNotBetween(String value1, String value2) {
            addCriterion("pro_type not between", value1, value2, "proType");
            return (Criteria) this;
        }

        public Criteria andActivationTimeIsNull() {
            addCriterion("activation_time is null");
            return (Criteria) this;
        }

        public Criteria andActivationTimeIsNotNull() {
            addCriterion("activation_time is not null");
            return (Criteria) this;
        }

        public Criteria andActivationTimeEqualTo(Date value) {
            addCriterion("activation_time =", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeNotEqualTo(Date value) {
            addCriterion("activation_time <>", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeGreaterThan(Date value) {
            addCriterion("activation_time >", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("activation_time >=", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeLessThan(Date value) {
            addCriterion("activation_time <", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeLessThanOrEqualTo(Date value) {
            addCriterion("activation_time <=", value, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeIn(List<Date> values) {
            addCriterion("activation_time in", values, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeNotIn(List<Date> values) {
            addCriterion("activation_time not in", values, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeBetween(Date value1, Date value2) {
            addCriterion("activation_time between", value1, value2, "activationTime");
            return (Criteria) this;
        }

        public Criteria andActivationTimeNotBetween(Date value1, Date value2) {
            addCriterion("activation_time not between", value1, value2, "activationTime");
            return (Criteria) this;
        }

        public Criteria andBindStatusIsNull() {
            addCriterion("bind_status is null");
            return (Criteria) this;
        }

        public Criteria andBindStatusIsNotNull() {
            addCriterion("bind_status is not null");
            return (Criteria) this;
        }

        public Criteria andBindStatusEqualTo(Integer value) {
            addCriterion("bind_status =", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotEqualTo(Integer value) {
            addCriterion("bind_status <>", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusGreaterThan(Integer value) {
            addCriterion("bind_status >", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bind_status >=", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusLessThan(Integer value) {
            addCriterion("bind_status <", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bind_status <=", value, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusIn(List<Integer> values) {
            addCriterion("bind_status in", values, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotIn(List<Integer> values) {
            addCriterion("bind_status not in", values, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusBetween(Integer value1, Integer value2) {
            addCriterion("bind_status between", value1, value2, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andBindStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bind_status not between", value1, value2, "bindStatus");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNull() {
            addCriterion("device_no is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIsNotNull() {
            addCriterion("device_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNoEqualTo(String value) {
            addCriterion("device_no =", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotEqualTo(String value) {
            addCriterion("device_no <>", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThan(String value) {
            addCriterion("device_no >", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoGreaterThanOrEqualTo(String value) {
            addCriterion("device_no >=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThan(String value) {
            addCriterion("device_no <", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLessThanOrEqualTo(String value) {
            addCriterion("device_no <=", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoLike(String value) {
            addCriterion("device_no like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotLike(String value) {
            addCriterion("device_no not like", value, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoIn(List<String> values) {
            addCriterion("device_no in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotIn(List<String> values) {
            addCriterion("device_no not in", values, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoBetween(String value1, String value2) {
            addCriterion("device_no between", value1, value2, "deviceNo");
            return (Criteria) this;
        }

        public Criteria andDeviceNoNotBetween(String value1, String value2) {
            addCriterion("device_no not between", value1, value2, "deviceNo");
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

        public Criteria andFreezeStatusIsNull() {
            addCriterion("freeze_status is null");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIsNotNull() {
            addCriterion("freeze_status is not null");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusEqualTo(Integer value) {
            addCriterion("freeze_status =", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotEqualTo(Integer value) {
            addCriterion("freeze_status <>", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusGreaterThan(Integer value) {
            addCriterion("freeze_status >", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("freeze_status >=", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusLessThan(Integer value) {
            addCriterion("freeze_status <", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("freeze_status <=", value, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusIn(List<Integer> values) {
            addCriterion("freeze_status in", values, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotIn(List<Integer> values) {
            addCriterion("freeze_status not in", values, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusBetween(Integer value1, Integer value2) {
            addCriterion("freeze_status between", value1, value2, "freezeStatus");
            return (Criteria) this;
        }

        public Criteria andFreezeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("freeze_status not between", value1, value2, "freezeStatus");
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