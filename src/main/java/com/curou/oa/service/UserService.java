package com.curou.oa.service;

import com.curou.oa.entity.UserSearch;
import com.curou.oa.models.User;
import com.curou.oa.utils.Exception.AjaxException;
import com.curou.oa.vo.request.UserDataReq;
import com.curou.oa.vo.response.UserDataRes;

import java.util.List;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/3/21 0021
 * @email 200890949@qq.com
 */
public interface UserService {

    List<UserDataRes> list(UserSearch search);

    Boolean add(UserDataReq userDataReq);

    Boolean checkAccount(UserDataReq user);

    Boolean update(UserDataReq userDataReq);

    UserDataRes getById(String userId) throws AjaxException;

    Boolean del(List<String> userIds) throws AjaxException;

    List<User> searchUser(UserSearch search);

    Boolean updStatus(UserDataReq userDataReq);

    Boolean updRole(String id);

    User getByAccount(String account);

    List<String> getPermsByUserAccount(String account);
}
