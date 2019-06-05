package com.curou.oa.entity;

public class LmRegistrationCodeSearch extends SearchBase {

    private Integer status;

    private String cardType;

    private String proType;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }
}
