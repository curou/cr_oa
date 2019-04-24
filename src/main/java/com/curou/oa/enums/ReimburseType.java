package com.curou.oa.enums;

public enum ReimburseType {

    IN_TRANSIT("0", "在途"),
    OVERRULED("1","驳回"),
    COMPLETE("2","完成");

    private String type;

    private String desc;

    private ReimburseType(String type, String desc) {
        this.type = type;
        this.desc = desc;

    }

    public String getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }





}
