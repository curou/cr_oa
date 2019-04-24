package com.curou.oa.service.impl;

import com.curou.oa.dao.RoleMapper;
import com.curou.oa.dao.RolesPermissionsMapper;
import com.curou.oa.dao.extend.RoleExtendMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Role;
import com.curou.oa.models.RoleExample;
import com.curou.oa.models.RolesPermissions;
import com.curou.oa.models.RolesPermissionsExample;
import com.curou.oa.service.RoleService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.utils.ListUtils;
import com.curou.oa.vo.request.RoleDataReq;
import com.curou.oa.vo.response.RoleDataRes;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleExtendMapper mapper;

    @Autowired
    private RolesPermissionsMapper rolesPermissionsMapper;

    @Override
    public List<Role> getAll(SearchBase searchBase) {
        RoleExample example = new RoleExample();
        return mapper.selectByExample(example);
    }

    @Override
    public List<RoleDataRes> getAllWithPerm(SearchBase searchBase) {
        return mapper.list(searchBase);
    }

    public Boolean checkName(RoleDataReq roleDataReq) {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(roleDataReq.getId())) {
            criteria.andIdNotEqualTo(roleDataReq.getId());
        }
        criteria.andNameEqualTo(roleDataReq.getName());
        List<Role> list = mapper.selectByExample(example);
        if (ListUtils.isNotNullOrEmpty(list)) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean add(RoleDataReq dataRes) {
        Role role = new Role();
        BeanUtils.copyProperties(dataRes, role);
        String roleId = UUID.randomUUID().toString();
        role.setId(roleId);
        role.setCreateTimeUtc(new Date());
        role.setModifyTimeUtc(new Date());


        try {
            //角色权限关联表
            List<String> roles = dataRes.getPermList();
            for (String perm : roles) {
                RolesPermissions rolesPermissions = new RolesPermissions();
                rolesPermissions.setCreateTimeUtc(new Date());
                rolesPermissions.setModifyTimeUtc(new Date());
                rolesPermissions.setId(UUID.randomUUID().toString());
                rolesPermissions.setRoleId(roleId);
                rolesPermissions.setPermId(perm);
                rolesPermissionsMapper.insert(rolesPermissions);
            }

            mapper.insert(role);
        } catch (Exception e) {
            throw new AjaxException("出现错误 请重试");
        }
        return true;
    }

    @Override
    public Boolean update(RoleDataReq dataRes) {
        RolesPermissionsExample example = new RolesPermissionsExample();
        RolesPermissionsExample.Criteria criteria = example.createCriteria();
        criteria.andRoleIdEqualTo(dataRes.getId());
        List<RolesPermissions> oldList = rolesPermissionsMapper.selectByExample(example);
        List<String> list = dataRes.getPermList();
        for (RolesPermissions oldPerm : oldList) {
            int temp = 0;
            for (String newPerm : list) {
                if (oldPerm.getPermId().equals(newPerm)) {
                    temp++;
                    break;
                }
            }
            if (temp == 0) {
                rolesPermissionsMapper.deleteByPrimaryKey(oldPerm.getId());
            }
        }
        for (String newPerm : list) {
            int temp = 0;
            for (RolesPermissions oldPerm : oldList) {
                if (oldPerm.getPermId().equals(newPerm)) {
                    temp++;
                    break;
                }
            }
            if (temp == 0) {
                RolesPermissions rolesPermissions = new RolesPermissions();
                rolesPermissions.setRoleId(dataRes.getId());
                rolesPermissions.setCreateTimeUtc(new Date());
                rolesPermissions.setModifyTimeUtc(new Date());
                rolesPermissions.setPermId(newPerm);
                rolesPermissions.setId(UUID.randomUUID().toString());
                rolesPermissionsMapper.insert(rolesPermissions);
            }
        }

        Role role = new Role();
        BeanUtils.copyProperties(dataRes, role);
        role.setModifyTimeUtc(new Date());
        try {
            mapper.updateByPrimaryKeySelective(role);
        } catch (Exception e) {
            throw new AjaxException("出现错误,请重试");
        }
        return true;
    }

    @Override
    public Boolean del(List<String> list) {
        try {
            for (String str : list) {
                mapper.deleteByPrimaryKey(str);
                RolesPermissionsExample example = new RolesPermissionsExample();
                RolesPermissionsExample.Criteria criteria = example.createCriteria();
                criteria.andRoleIdEqualTo(str);
                rolesPermissionsMapper.deleteByExample(example);
            }

        }catch (Exception e){
            throw new AjaxException("出现错误,请重试");
        }
        return true;
    }
}
