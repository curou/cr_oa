package com.curou.oa.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(String value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(String value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(String value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(String value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(String value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLike(String value) {
            addCriterion("product_id like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotLike(String value) {
            addCriterion("product_id not like", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<String> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<String> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(String value1, String value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(String value1, String value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNull() {
            addCriterion("product_number is null");
            return (Criteria) this;
        }

        public Criteria andProductNumberIsNotNull() {
            addCriterion("product_number is not null");
            return (Criteria) this;
        }

        public Criteria andProductNumberEqualTo(String value) {
            addCriterion("product_number =", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotEqualTo(String value) {
            addCriterion("product_number <>", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThan(String value) {
            addCriterion("product_number >", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberGreaterThanOrEqualTo(String value) {
            addCriterion("product_number >=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThan(String value) {
            addCriterion("product_number <", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLessThanOrEqualTo(String value) {
            addCriterion("product_number <=", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberLike(String value) {
            addCriterion("product_number like", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotLike(String value) {
            addCriterion("product_number not like", value, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberIn(List<String> values) {
            addCriterion("product_number in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotIn(List<String> values) {
            addCriterion("product_number not in", values, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberBetween(String value1, String value2) {
            addCriterion("product_number between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductNumberNotBetween(String value1, String value2) {
            addCriterion("product_number not between", value1, value2, "productNumber");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusIsNull() {
            addCriterion("product_delete_status is null");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusIsNotNull() {
            addCriterion("product_delete_status is not null");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusEqualTo(String value) {
            addCriterion("product_delete_status =", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusNotEqualTo(String value) {
            addCriterion("product_delete_status <>", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusGreaterThan(String value) {
            addCriterion("product_delete_status >", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusGreaterThanOrEqualTo(String value) {
            addCriterion("product_delete_status >=", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusLessThan(String value) {
            addCriterion("product_delete_status <", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusLessThanOrEqualTo(String value) {
            addCriterion("product_delete_status <=", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusLike(String value) {
            addCriterion("product_delete_status like", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusNotLike(String value) {
            addCriterion("product_delete_status not like", value, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusIn(List<String> values) {
            addCriterion("product_delete_status in", values, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusNotIn(List<String> values) {
            addCriterion("product_delete_status not in", values, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusBetween(String value1, String value2) {
            addCriterion("product_delete_status between", value1, value2, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductDeleteStatusNotBetween(String value1, String value2) {
            addCriterion("product_delete_status not between", value1, value2, "productDeleteStatus");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIsNull() {
            addCriterion("product_inventory is null");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIsNotNull() {
            addCriterion("product_inventory is not null");
            return (Criteria) this;
        }

        public Criteria andProductInventoryEqualTo(BigDecimal value) {
            addCriterion("product_inventory =", value, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryNotEqualTo(BigDecimal value) {
            addCriterion("product_inventory <>", value, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryGreaterThan(BigDecimal value) {
            addCriterion("product_inventory >", value, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_inventory >=", value, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryLessThan(BigDecimal value) {
            addCriterion("product_inventory <", value, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_inventory <=", value, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryIn(List<BigDecimal> values) {
            addCriterion("product_inventory in", values, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryNotIn(List<BigDecimal> values) {
            addCriterion("product_inventory not in", values, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_inventory between", value1, value2, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductInventoryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_inventory not between", value1, value2, "productInventory");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNull() {
            addCriterion("product_price is null");
            return (Criteria) this;
        }

        public Criteria andProductPriceIsNotNull() {
            addCriterion("product_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductPriceEqualTo(BigDecimal value) {
            addCriterion("product_price =", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_price <>", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThan(BigDecimal value) {
            addCriterion("product_price >", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price >=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThan(BigDecimal value) {
            addCriterion("product_price <", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_price <=", value, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceIn(List<BigDecimal> values) {
            addCriterion("product_price in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_price not in", values, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_price not between", value1, value2, "productPrice");
            return (Criteria) this;
        }

        public Criteria andProductStatusIsNull() {
            addCriterion("product_status is null");
            return (Criteria) this;
        }

        public Criteria andProductStatusIsNotNull() {
            addCriterion("product_status is not null");
            return (Criteria) this;
        }

        public Criteria andProductStatusEqualTo(String value) {
            addCriterion("product_status =", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotEqualTo(String value) {
            addCriterion("product_status <>", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThan(String value) {
            addCriterion("product_status >", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThanOrEqualTo(String value) {
            addCriterion("product_status >=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThan(String value) {
            addCriterion("product_status <", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThanOrEqualTo(String value) {
            addCriterion("product_status <=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLike(String value) {
            addCriterion("product_status like", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotLike(String value) {
            addCriterion("product_status not like", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusIn(List<String> values) {
            addCriterion("product_status in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotIn(List<String> values) {
            addCriterion("product_status not in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusBetween(String value1, String value2) {
            addCriterion("product_status between", value1, value2, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotBetween(String value1, String value2) {
            addCriterion("product_status not between", value1, value2, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceIsNull() {
            addCriterion("product_cost_price is null");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceIsNotNull() {
            addCriterion("product_cost_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceEqualTo(BigDecimal value) {
            addCriterion("product_cost_price =", value, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_cost_price <>", value, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceGreaterThan(BigDecimal value) {
            addCriterion("product_cost_price >", value, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_cost_price >=", value, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceLessThan(BigDecimal value) {
            addCriterion("product_cost_price <", value, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_cost_price <=", value, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceIn(List<BigDecimal> values) {
            addCriterion("product_cost_price in", values, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_cost_price not in", values, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_cost_price between", value1, value2, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductCostPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_cost_price not between", value1, value2, "productCostPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceIsNull() {
            addCriterion("product_sell_price is null");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceIsNotNull() {
            addCriterion("product_sell_price is not null");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceEqualTo(BigDecimal value) {
            addCriterion("product_sell_price =", value, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceNotEqualTo(BigDecimal value) {
            addCriterion("product_sell_price <>", value, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceGreaterThan(BigDecimal value) {
            addCriterion("product_sell_price >", value, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sell_price >=", value, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceLessThan(BigDecimal value) {
            addCriterion("product_sell_price <", value, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_sell_price <=", value, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceIn(List<BigDecimal> values) {
            addCriterion("product_sell_price in", values, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceNotIn(List<BigDecimal> values) {
            addCriterion("product_sell_price not in", values, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sell_price between", value1, value2, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductSellPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_sell_price not between", value1, value2, "productSellPrice");
            return (Criteria) this;
        }

        public Criteria andProductUnitsIsNull() {
            addCriterion("product_units is null");
            return (Criteria) this;
        }

        public Criteria andProductUnitsIsNotNull() {
            addCriterion("product_units is not null");
            return (Criteria) this;
        }

        public Criteria andProductUnitsEqualTo(String value) {
            addCriterion("product_units =", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsNotEqualTo(String value) {
            addCriterion("product_units <>", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsGreaterThan(String value) {
            addCriterion("product_units >", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsGreaterThanOrEqualTo(String value) {
            addCriterion("product_units >=", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsLessThan(String value) {
            addCriterion("product_units <", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsLessThanOrEqualTo(String value) {
            addCriterion("product_units <=", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsLike(String value) {
            addCriterion("product_units like", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsNotLike(String value) {
            addCriterion("product_units not like", value, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsIn(List<String> values) {
            addCriterion("product_units in", values, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsNotIn(List<String> values) {
            addCriterion("product_units not in", values, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsBetween(String value1, String value2) {
            addCriterion("product_units between", value1, value2, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUnitsNotBetween(String value1, String value2) {
            addCriterion("product_units not between", value1, value2, "productUnits");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitIsNull() {
            addCriterion("product_upper_limit is null");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitIsNotNull() {
            addCriterion("product_upper_limit is not null");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitEqualTo(BigDecimal value) {
            addCriterion("product_upper_limit =", value, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitNotEqualTo(BigDecimal value) {
            addCriterion("product_upper_limit <>", value, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitGreaterThan(BigDecimal value) {
            addCriterion("product_upper_limit >", value, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_upper_limit >=", value, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitLessThan(BigDecimal value) {
            addCriterion("product_upper_limit <", value, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_upper_limit <=", value, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitIn(List<BigDecimal> values) {
            addCriterion("product_upper_limit in", values, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitNotIn(List<BigDecimal> values) {
            addCriterion("product_upper_limit not in", values, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_upper_limit between", value1, value2, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductUpperLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_upper_limit not between", value1, value2, "productUpperLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitIsNull() {
            addCriterion("product_lower_limit is null");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitIsNotNull() {
            addCriterion("product_lower_limit is not null");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitEqualTo(BigDecimal value) {
            addCriterion("product_lower_limit =", value, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitNotEqualTo(BigDecimal value) {
            addCriterion("product_lower_limit <>", value, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitGreaterThan(BigDecimal value) {
            addCriterion("product_lower_limit >", value, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_lower_limit >=", value, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitLessThan(BigDecimal value) {
            addCriterion("product_lower_limit <", value, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_lower_limit <=", value, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitIn(List<BigDecimal> values) {
            addCriterion("product_lower_limit in", values, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitNotIn(List<BigDecimal> values) {
            addCriterion("product_lower_limit not in", values, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_lower_limit between", value1, value2, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductLowerLimitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_lower_limit not between", value1, value2, "productLowerLimit");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusIsNull() {
            addCriterion("product_warning_status is null");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusIsNotNull() {
            addCriterion("product_warning_status is not null");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusEqualTo(Integer value) {
            addCriterion("product_warning_status =", value, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusNotEqualTo(Integer value) {
            addCriterion("product_warning_status <>", value, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusGreaterThan(Integer value) {
            addCriterion("product_warning_status >", value, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_warning_status >=", value, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusLessThan(Integer value) {
            addCriterion("product_warning_status <", value, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusLessThanOrEqualTo(Integer value) {
            addCriterion("product_warning_status <=", value, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusIn(List<Integer> values) {
            addCriterion("product_warning_status in", values, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusNotIn(List<Integer> values) {
            addCriterion("product_warning_status not in", values, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusBetween(Integer value1, Integer value2) {
            addCriterion("product_warning_status between", value1, value2, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductWarningStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("product_warning_status not between", value1, value2, "productWarningStatus");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdIsNull() {
            addCriterion("product_create_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdIsNotNull() {
            addCriterion("product_create_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdEqualTo(String value) {
            addCriterion("product_create_employee_id =", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdNotEqualTo(String value) {
            addCriterion("product_create_employee_id <>", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdGreaterThan(String value) {
            addCriterion("product_create_employee_id >", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_create_employee_id >=", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdLessThan(String value) {
            addCriterion("product_create_employee_id <", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("product_create_employee_id <=", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdLike(String value) {
            addCriterion("product_create_employee_id like", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdNotLike(String value) {
            addCriterion("product_create_employee_id not like", value, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdIn(List<String> values) {
            addCriterion("product_create_employee_id in", values, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdNotIn(List<String> values) {
            addCriterion("product_create_employee_id not in", values, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdBetween(String value1, String value2) {
            addCriterion("product_create_employee_id between", value1, value2, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("product_create_employee_id not between", value1, value2, "productCreateEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdIsNull() {
            addCriterion("product_modify_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdIsNotNull() {
            addCriterion("product_modify_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdEqualTo(String value) {
            addCriterion("product_modify_employee_id =", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdNotEqualTo(String value) {
            addCriterion("product_modify_employee_id <>", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdGreaterThan(String value) {
            addCriterion("product_modify_employee_id >", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdGreaterThanOrEqualTo(String value) {
            addCriterion("product_modify_employee_id >=", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdLessThan(String value) {
            addCriterion("product_modify_employee_id <", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdLessThanOrEqualTo(String value) {
            addCriterion("product_modify_employee_id <=", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdLike(String value) {
            addCriterion("product_modify_employee_id like", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdNotLike(String value) {
            addCriterion("product_modify_employee_id not like", value, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdIn(List<String> values) {
            addCriterion("product_modify_employee_id in", values, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdNotIn(List<String> values) {
            addCriterion("product_modify_employee_id not in", values, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdBetween(String value1, String value2) {
            addCriterion("product_modify_employee_id between", value1, value2, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductModifyEmployeeIdNotBetween(String value1, String value2) {
            addCriterion("product_modify_employee_id not between", value1, value2, "productModifyEmployeeId");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcIsNull() {
            addCriterion("product_create_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcIsNotNull() {
            addCriterion("product_create_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcEqualTo(Date value) {
            addCriterion("product_create_time_utc =", value, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcNotEqualTo(Date value) {
            addCriterion("product_create_time_utc <>", value, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcGreaterThan(Date value) {
            addCriterion("product_create_time_utc >", value, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("product_create_time_utc >=", value, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcLessThan(Date value) {
            addCriterion("product_create_time_utc <", value, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("product_create_time_utc <=", value, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcIn(List<Date> values) {
            addCriterion("product_create_time_utc in", values, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcNotIn(List<Date> values) {
            addCriterion("product_create_time_utc not in", values, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcBetween(Date value1, Date value2) {
            addCriterion("product_create_time_utc between", value1, value2, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductCreateTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("product_create_time_utc not between", value1, value2, "productCreateTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcIsNull() {
            addCriterion("product_modify_time_utc is null");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcIsNotNull() {
            addCriterion("product_modify_time_utc is not null");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcEqualTo(Date value) {
            addCriterion("product_modify_time_utc =", value, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcNotEqualTo(Date value) {
            addCriterion("product_modify_time_utc <>", value, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcGreaterThan(Date value) {
            addCriterion("product_modify_time_utc >", value, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcGreaterThanOrEqualTo(Date value) {
            addCriterion("product_modify_time_utc >=", value, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcLessThan(Date value) {
            addCriterion("product_modify_time_utc <", value, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcLessThanOrEqualTo(Date value) {
            addCriterion("product_modify_time_utc <=", value, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcIn(List<Date> values) {
            addCriterion("product_modify_time_utc in", values, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcNotIn(List<Date> values) {
            addCriterion("product_modify_time_utc not in", values, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcBetween(Date value1, Date value2) {
            addCriterion("product_modify_time_utc between", value1, value2, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductModifyTimeUtcNotBetween(Date value1, Date value2) {
            addCriterion("product_modify_time_utc not between", value1, value2, "productModifyTimeUtc");
            return (Criteria) this;
        }

        public Criteria andProductRemarksIsNull() {
            addCriterion("product_remarks is null");
            return (Criteria) this;
        }

        public Criteria andProductRemarksIsNotNull() {
            addCriterion("product_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andProductRemarksEqualTo(String value) {
            addCriterion("product_remarks =", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksNotEqualTo(String value) {
            addCriterion("product_remarks <>", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksGreaterThan(String value) {
            addCriterion("product_remarks >", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("product_remarks >=", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksLessThan(String value) {
            addCriterion("product_remarks <", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksLessThanOrEqualTo(String value) {
            addCriterion("product_remarks <=", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksLike(String value) {
            addCriterion("product_remarks like", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksNotLike(String value) {
            addCriterion("product_remarks not like", value, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksIn(List<String> values) {
            addCriterion("product_remarks in", values, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksNotIn(List<String> values) {
            addCriterion("product_remarks not in", values, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksBetween(String value1, String value2) {
            addCriterion("product_remarks between", value1, value2, "productRemarks");
            return (Criteria) this;
        }

        public Criteria andProductRemarksNotBetween(String value1, String value2) {
            addCriterion("product_remarks not between", value1, value2, "productRemarks");
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