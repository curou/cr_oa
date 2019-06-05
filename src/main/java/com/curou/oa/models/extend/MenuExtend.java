package com.curou.oa.models.extend;

import com.curou.oa.models.Menu;

import java.util.List;

public class MenuExtend extends Menu {
    private Integer sort;

    private String permissionName;

    private List<MenuExtend> list;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public List<MenuExtend> getList() {
        return list;
    }

    public void setList(List<MenuExtend> list) {
        this.list = list;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
