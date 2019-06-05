package com.curou.oa.vo.request;

import com.curou.oa.models.LmRegistrationCode;

public class LmRegistrationCodeReq extends LmRegistrationCode {

    Integer count;

    Integer random;

    Long time;

    String msg;

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
