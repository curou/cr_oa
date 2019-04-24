package com.curou.oa.service;

import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Role;
import com.curou.oa.vo.request.RoleDataReq;
import com.curou.oa.vo.response.RoleDataRes;

import java.util.List;


public interface RoleService {

    Boolean checkName(RoleDataReq roleDataReq);

    List<Role> getAll(SearchBase searchBase);

    List<RoleDataRes> getAllWithPerm(SearchBase searchBase);

    Boolean update(RoleDataReq dataRes);

    Boolean add(RoleDataReq dataRes);

    Boolean del(List<String> list);

}
