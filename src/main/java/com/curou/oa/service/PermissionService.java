package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Permission;
import com.curou.oa.vo.request.PermissionDataReq;

import java.util.List;


public interface PermissionService {

    Boolean add(Permission permission);

    List<Permission> getList(SearchBase searchBase);

    Permission getById(String id);

    List<Permission> getAll();

    Boolean update(Permission permission);

    Boolean del(List<String> permissionIds);

    Boolean checkName(Permission permission);

    Boolean checkFlag(Permission permission);

}
