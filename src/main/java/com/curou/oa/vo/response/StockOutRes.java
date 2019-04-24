package com.curou.oa.vo.response;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/4/2 0002
 * @email 200890949@qq.com
 */
public class StockOutRes {


    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("产品名称")
    private String proName;

    @ApiModelProperty("产品规格")
    private String productSpec;

    @ApiModelProperty("产品单位")
    private String unit;

    @ApiModelProperty("产品数量")
    private Long count;

    @ApiModelProperty("仓库id")
    private String stockId;


    @ApiModelProperty("仓库名")
    private String stockName;

    private Date createTimeUtc;

    private Date modifyTimeUtc;

    @ApiModelProperty("创建人")
    private String createEmployeeId;

    private String modifyEmployeeId;

    public Date getCreateTimeUtc() {
        return createTimeUtc;
    }

    public void setCreateTimeUtc(Date createTimeUtc) {
        this.createTimeUtc = createTimeUtc;
    }

    public Date getModifyTimeUtc() {
        return modifyTimeUtc;
    }

    public void setModifyTimeUtc(Date modifyTimeUtc) {
        this.modifyTimeUtc = modifyTimeUtc;
    }

    public String getCreateEmployeeId() {
        return createEmployeeId;
    }

    public void setCreateEmployeeId(String createEmployeeId) {
        this.createEmployeeId = createEmployeeId;
    }

    public String getModifyEmployeeId() {
        return modifyEmployeeId;
    }

    public void setModifyEmployeeId(String modifyEmployeeId) {
        this.modifyEmployeeId = modifyEmployeeId;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProductSpec() {
        return productSpec;
    }

    public void setProductSpec(String productSpec) {
        this.productSpec = productSpec;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
