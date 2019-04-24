package com.curou.oa.service;


import com.curou.oa.models.User;

/**
 * @author lxr
 * @version v0.01
 * @date ${date}
 * @email 200890949@qq.com
 */
public interface LoginService {

    Boolean check(String userName, String passWord);

    User getByAccount(String userName);
}
