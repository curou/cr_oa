package com.curou.oa.service.impl;

import com.curou.oa.dao.UserRolesMapper;
import com.curou.oa.dao.extend.UserExtendMapper;
import com.curou.oa.entity.UserSearch;
import com.curou.oa.models.User;
import com.curou.oa.models.UserExample;
import com.curou.oa.models.UserRoles;
import com.curou.oa.models.UserRolesExample;
import com.curou.oa.service.UserService;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.utils.ListUtils;
import com.curou.oa.vo.request.UserDataReq;
import com.curou.oa.vo.response.UserDataRes;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserExtendMapper mapper;

    @Autowired
    private UserRolesMapper userRolesMapper;

    @Override
    public List<UserDataRes> list(UserSearch search) {
        return mapper.list(search);
    }

    @Override
    public Boolean add(UserDataReq userDataReq) {
        User user = new User();
        BeanUtils.copyProperties(userDataReq,user);
        String userId = UUID.randomUUID().toString();
        user.setId(userId);
        user.setCreateTimeUtc(new Date());
        user.setModifyTimeUtc(new Date());

        //用户角色关联表
        List<String> roles = userDataReq.getRoles();
        for (String role : roles) {
            UserRoles userRoles = new UserRoles();
            userRoles.setCreateTimeUtc(new Date());
            userRoles.setModifyTimeUtc(new Date());
            userRoles.setId(UUID.randomUUID().toString());
            userRoles.setUserId(userId);
            userRoles.setRoleId(role);
            userRolesMapper.insert(userRoles);
        }
        try {
            mapper.insert(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Boolean checkAccount(UserDataReq user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(user.getAccount());
        if(StringUtils.isNotBlank(user.getId())){
            criteria.andIdNotEqualTo(user.getId());
        }
        List<User> list = mapper.selectByExample(example);
        if(ListUtils.isNotNullOrEmpty(list)){
            return false;
        }
        return true;
    }

    @Override
    public Boolean update(UserDataReq userDataReq) {
        User user = new User();
        BeanUtils.copyProperties(userDataReq,user);
        user.setModifyTimeUtc(new Date());
        try {
            mapper.updateByPrimaryKeySelective(user);
            //删除原有角色
            UserRolesExample example = new UserRolesExample();
            UserRolesExample.Criteria criteria = example.createCriteria();
            criteria.andUserIdEqualTo(userDataReq.getId());
            userRolesMapper.deleteByExample(example);

            //用户角色关联表
            List<String> roles = userDataReq.getRoles();
            for (String role : roles) {
                UserRoles userRoles = new UserRoles();
                userRoles.setCreateTimeUtc(new Date());
                userRoles.setModifyTimeUtc(new Date());
                userRoles.setId(UUID.randomUUID().toString());
                userRoles.setUserId(userDataReq.getId());
                userRoles.setRoleId(role);
                userRolesMapper.insert(userRoles);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public UserDataRes getById(String userId) throws AjaxException {
        User user = mapper.selectByPrimaryKey(userId);
        if (user==null){
            throw new AjaxException("用户不存在");
        }
        UserDataRes udr = new UserDataRes();
        BeanUtils.copyProperties(user,udr);
        return udr;
    }

    @Override
    public Boolean del(List<String> ids) throws AjaxException {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        try {
            mapper.deleteByExample(example);
            for (String id : ids) {
                UserRolesExample example2 = new UserRolesExample();
                UserRolesExample.Criteria criteria1 = example2.createCriteria();
                criteria1.andUserIdEqualTo(id);
                userRolesMapper.deleteByExample(example2);
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<User> searchUser(UserSearch search) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
//        if (StringUtils.isNoneBlank(search.getUserName())){
//            criteria.andNameLike("%"+search.getUserName()+"%");
//        }
//        if (StringUtils.isNoneBlank(search.getUserMobilePhone())){
//            criteria.andMobilePhoneLike("%"+search.getUserMobilePhone()+"%");
//        }


        example.setOrderByClause("user_sort asc,user_update_time desc");
        return mapper.selectByExample(example);
    }

    @Override
    public Boolean updStatus(UserDataReq userDataReq) {
        User user = new User();
        BeanUtils.copyProperties(userDataReq,user);
        try {
            mapper.updateByPrimaryKeySelective(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public Boolean updRole(String id) {
        User user = mapper.selectByPrimaryKey(id);
        if (user==null){
            throw new AjaxException("用户不存在");
        }
//        user.setUserRole(null);
        try {
            mapper.updateByPrimaryKey(user);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public User getByAccount(String account) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(account);
        List<User> users = mapper.selectByExample(example);
        User user = new User();
        if (ListUtils.isNotNullOrEmpty(users)){
            user=users.get(0);
        }
        return user;
    }

    @Override
    public List<String> getPermsByUserAccount(String account){
        return mapper.getPermsByUserAccount(account);
    }
}
