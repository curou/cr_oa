package com.curou.oa.vo.request;

import com.curou.oa.models.Role;

import java.util.List;


public class RoleDataReq extends Role {

    private List<String> permList;

    public List<String> getPermList() {
        return permList;
    }

    public void setPermList(List<String> permList) {
        this.permList = permList;
    }
}
