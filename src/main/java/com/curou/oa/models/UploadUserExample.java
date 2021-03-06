package com.curou.oa.models;

import java.util.ArrayList;
import java.util.List;

public class UploadUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UploadUserExample() {
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

        public Criteria andCompanyInfoIdIsNull() {
            addCriterion("company_info_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdIsNotNull() {
            addCriterion("company_info_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdEqualTo(String value) {
            addCriterion("company_info_id =", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdNotEqualTo(String value) {
            addCriterion("company_info_id <>", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdGreaterThan(String value) {
            addCriterion("company_info_id >", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdGreaterThanOrEqualTo(String value) {
            addCriterion("company_info_id >=", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdLessThan(String value) {
            addCriterion("company_info_id <", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdLessThanOrEqualTo(String value) {
            addCriterion("company_info_id <=", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdLike(String value) {
            addCriterion("company_info_id like", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdNotLike(String value) {
            addCriterion("company_info_id not like", value, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdIn(List<String> values) {
            addCriterion("company_info_id in", values, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdNotIn(List<String> values) {
            addCriterion("company_info_id not in", values, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdBetween(String value1, String value2) {
            addCriterion("company_info_id between", value1, value2, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andCompanyInfoIdNotBetween(String value1, String value2) {
            addCriterion("company_info_id not between", value1, value2, "companyInfoId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdIsNull() {
            addCriterion("upload_detail_id is null");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdIsNotNull() {
            addCriterion("upload_detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdEqualTo(String value) {
            addCriterion("upload_detail_id =", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdNotEqualTo(String value) {
            addCriterion("upload_detail_id <>", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdGreaterThan(String value) {
            addCriterion("upload_detail_id >", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdGreaterThanOrEqualTo(String value) {
            addCriterion("upload_detail_id >=", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdLessThan(String value) {
            addCriterion("upload_detail_id <", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdLessThanOrEqualTo(String value) {
            addCriterion("upload_detail_id <=", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdLike(String value) {
            addCriterion("upload_detail_id like", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdNotLike(String value) {
            addCriterion("upload_detail_id not like", value, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdIn(List<String> values) {
            addCriterion("upload_detail_id in", values, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdNotIn(List<String> values) {
            addCriterion("upload_detail_id not in", values, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdBetween(String value1, String value2) {
            addCriterion("upload_detail_id between", value1, value2, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andUploadDetailIdNotBetween(String value1, String value2) {
            addCriterion("upload_detail_id not between", value1, value2, "uploadDetailId");
            return (Criteria) this;
        }

        public Criteria andSortIsNull() {
            addCriterion("sort is null");
            return (Criteria) this;
        }

        public Criteria andSortIsNotNull() {
            addCriterion("sort is not null");
            return (Criteria) this;
        }

        public Criteria andSortEqualTo(Integer value) {
            addCriterion("sort =", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotEqualTo(Integer value) {
            addCriterion("sort <>", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThan(Integer value) {
            addCriterion("sort >", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortGreaterThanOrEqualTo(Integer value) {
            addCriterion("sort >=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThan(Integer value) {
            addCriterion("sort <", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortLessThanOrEqualTo(Integer value) {
            addCriterion("sort <=", value, "sort");
            return (Criteria) this;
        }

        public Criteria andSortIn(List<Integer> values) {
            addCriterion("sort in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotIn(List<Integer> values) {
            addCriterion("sort not in", values, "sort");
            return (Criteria) this;
        }

        public Criteria andSortBetween(Integer value1, Integer value2) {
            addCriterion("sort between", value1, value2, "sort");
            return (Criteria) this;
        }

        public Criteria andSortNotBetween(Integer value1, Integer value2) {
            addCriterion("sort not between", value1, value2, "sort");
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