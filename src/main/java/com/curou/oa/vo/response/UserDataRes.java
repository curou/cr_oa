package com.curou.oa.vo.response;

import com.curou.oa.models.User;
import io.swagger.annotations.ApiModel;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/3/25 0025
 * @email 200890949@qq.com
 */
@ApiModel(value="添加用户")
public class UserDataRes extends User {

    private String department;

    private String roleId;


    private String role;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
