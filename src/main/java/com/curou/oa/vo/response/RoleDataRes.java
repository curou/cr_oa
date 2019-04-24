package com.curou.oa.vo.response;

import com.curou.oa.models.Role;

public class RoleDataRes extends Role {
    private String perm;

    private String permId;

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public String getPermId() {
        return permId;
    }

    public void setPermId(String permId) {
        this.permId = permId;
    }
}
