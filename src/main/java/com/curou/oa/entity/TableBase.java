package com.curou.oa.entity;

import java.util.List;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/3/25 0025
 * @email 200890949@qq.com
 */
public class TableBase<T> {

    private Integer code;
    private String msg;
    private Long count;
    private List<T> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
