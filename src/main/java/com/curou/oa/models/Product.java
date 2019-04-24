package com.curou.oa.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private String productId;

    private String productNumber;

    private String productDeleteStatus;

    private BigDecimal productInventory;

    private String productName;

    private BigDecimal productPrice;

    private String productStatus;

    private BigDecimal productCostPrice;

    private BigDecimal productSellPrice;

    private String productUnits;

    private BigDecimal productUpperLimit;

    private BigDecimal productLowerLimit;

    private Integer productWarningStatus;

    private String productCreateEmployeeId;

    private String productModifyEmployeeId;

    private Date productCreateTimeUtc;

    private Date productModifyTimeUtc;

    private String productRemarks;

    private String productInventoryDetail;

    private static final long serialVersionUID = 1L;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber == null ? null : productNumber.trim();
    }

    public String getProductDeleteStatus() {
        return productDeleteStatus;
    }

    public void setProductDeleteStatus(String productDeleteStatus) {
        this.productDeleteStatus = productDeleteStatus == null ? null : productDeleteStatus.trim();
    }

    public BigDecimal getProductInventory() {
        return productInventory;
    }

    public void setProductInventory(BigDecimal productInventory) {
        this.productInventory = productInventory;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus == null ? null : productStatus.trim();
    }

    public BigDecimal getProductCostPrice() {
        return productCostPrice;
    }

    public void setProductCostPrice(BigDecimal productCostPrice) {
        this.productCostPrice = productCostPrice;
    }

    public BigDecimal getProductSellPrice() {
        return productSellPrice;
    }

    public void setProductSellPrice(BigDecimal productSellPrice) {
        this.productSellPrice = productSellPrice;
    }

    public String getProductUnits() {
        return productUnits;
    }

    public void setProductUnits(String productUnits) {
        this.productUnits = productUnits == null ? null : productUnits.trim();
    }

    public BigDecimal getProductUpperLimit() {
        return productUpperLimit;
    }

    public void setProductUpperLimit(BigDecimal productUpperLimit) {
        this.productUpperLimit = productUpperLimit;
    }

    public BigDecimal getProductLowerLimit() {
        return productLowerLimit;
    }

    public void setProductLowerLimit(BigDecimal productLowerLimit) {
        this.productLowerLimit = productLowerLimit;
    }

    public Integer getProductWarningStatus() {
        return productWarningStatus;
    }

    public void setProductWarningStatus(Integer productWarningStatus) {
        this.productWarningStatus = productWarningStatus;
    }

    public String getProductCreateEmployeeId() {
        return productCreateEmployeeId;
    }

    public void setProductCreateEmployeeId(String productCreateEmployeeId) {
        this.productCreateEmployeeId = productCreateEmployeeId == null ? null : productCreateEmployeeId.trim();
    }

    public String getProductModifyEmployeeId() {
        return productModifyEmployeeId;
    }

    public void setProductModifyEmployeeId(String productModifyEmployeeId) {
        this.productModifyEmployeeId = productModifyEmployeeId == null ? null : productModifyEmployeeId.trim();
    }

    public Date getProductCreateTimeUtc() {
        return productCreateTimeUtc;
    }

    public void setProductCreateTimeUtc(Date productCreateTimeUtc) {
        this.productCreateTimeUtc = productCreateTimeUtc;
    }

    public Date getProductModifyTimeUtc() {
        return productModifyTimeUtc;
    }

    public void setProductModifyTimeUtc(Date productModifyTimeUtc) {
        this.productModifyTimeUtc = productModifyTimeUtc;
    }

    public String getProductRemarks() {
        return productRemarks;
    }

    public void setProductRemarks(String productRemarks) {
        this.productRemarks = productRemarks == null ? null : productRemarks.trim();
    }

    public String getProductInventoryDetail() {
        return productInventoryDetail;
    }

    public void setProductInventoryDetail(String productInventoryDetail) {
        this.productInventoryDetail = productInventoryDetail == null ? null : productInventoryDetail.trim();
    }
}