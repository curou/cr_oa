package com.curou.oa.vo.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/3/29 0029
 * @email 200890949@qq.com
 */
public class PermissionDataReq {

    @ApiModelProperty("id")
    private String permissionId;

    @ApiModelProperty("权限名")
    private String permissionName;

    @ApiModelProperty("权限code")
    private String permissionKey;

    @ApiModelProperty("权限描述")
    private String permissionDecription;

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionDecription() {
        return permissionDecription;
    }

    public void setPermissionDecription(String permissionDecription) {
        this.permissionDecription = permissionDecription;
    }
}
