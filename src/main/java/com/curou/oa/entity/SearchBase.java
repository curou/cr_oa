package com.curou.oa.entity;


import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SearchBase {

    private  String id;

    private Integer page=1;

    private Integer limit=10;

    private String orderBy;

    private String keyword;

    private String beginStr;

    private String endStr;

    private Date beginDate;

    private Date endDate;

    private String dateType = "yyyy-MM-dd HH:mm:ss";

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }


    public Date getBeginDate() {
        SimpleDateFormat format =new SimpleDateFormat(this.dateType);
        if(StringUtils.isEmpty(this.beginStr)){
            return null;
        }
        //必须捕获异常
        Date date = null;
        try {
            date = format.parse(this.beginStr);
        } catch(ParseException px) {
            px.printStackTrace();
        }
        return date;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        SimpleDateFormat format =new SimpleDateFormat(this.dateType);
        if(StringUtils.isEmpty(this.endStr)){
            return null;
        }
        //必须捕获异常
        Date date = null;
        try {
            date = format.parse(this.endStr);
        } catch(ParseException px) {
            px.printStackTrace();
        }
        return date;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getBeginStr() {
        return beginStr;
    }

    public void setBeginStr(String beginStr) {
        this.beginStr = beginStr;
    }

    public String getEndStr() {
        return endStr;
    }

    public void setEndStr(String endStr) {
        this.endStr = endStr;
    }

    public String getId() {
        if(StringUtils.isEmpty(this.id)){
            return null;
        }
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getKeyword() {
        if(StringUtils.isEmpty(this.keyword)){
            return null;
        }
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
