package com.curou.oa.service.impl;

import com.curou.oa.dao.PermissionMapper;
import com.curou.oa.entity.SearchBase;
import com.curou.oa.models.Permission;
import com.curou.oa.models.PermissionExample;
import com.curou.oa.service.PermissionService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.utils.ListUtils;
import com.curou.oa.vo.request.PermissionDataReq;
import freemarker.template.utility.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper mapper;

    @Override
    public Boolean add(Permission permission) {
        permission.setId(UUID.randomUUID().toString());
        permission.setCreateTimeUtc(new Date());
        permission.setModifyTimeUtc(new Date());
        try {
            mapper.insert(permission);
        }catch (Exception e){
            throw new AjaxException("出现错误 请重试");
        }
        return true;
    }

    @Override
    public List<Permission> getList(SearchBase searchBase) {
        PermissionExample example =new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(searchBase.getKeyword())) {
            criteria.andNameLike("%"+searchBase.getKeyword()+"%");
        }
        List<Permission> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public List<Permission> getAll() {
        PermissionExample example =new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        List<Permission> list = mapper.selectByExample(example);
        return list;
    }

    @Override
    public Permission getById(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public Boolean update(Permission permission) {
        permission.setModifyTimeUtc(new Date());
        try {
            mapper.updateByPrimaryKeySelective(permission);
        }catch (Exception e){
            throw new AjaxException("出现错误,请重试");
        }
        return true;
    }

    @Override
    public Boolean del(List<String> list) {
        try {
            for (String str : list) {
                mapper.deleteByPrimaryKey(str);
            }
        }catch (Exception e){
            throw new AjaxException("出现错误,请重试");
        }
        return true;
    }

    @Override
    public Boolean checkName(Permission permission) {
        PermissionExample example = new PermissionExample();
        PermissionExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(permission.getId())) {
            criteria.andIdNotEqualTo(permission.getId());
        }
        criteria.andNameEqualTo(permission.getName());
        List<Permission> list = mapper.selectByExample(example);
        if (ListUtils.isNotNullOrEmpty(list)){
            return false;
        }
        return true;
    }


}
