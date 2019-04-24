package com.curou.oa.service.impl;

import com.curou.oa.dao.extend.UserExtendMapper;
import com.curou.oa.models.User;
import com.curou.oa.models.UserExample;
import com.curou.oa.service.LoginService;
import com.curou.oa.utils.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lxr
 * @version v0.01
 * @date ${date}
 * @email 200890949@qq.com
 */
@SuppressWarnings("ALL")
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserExtendMapper mapper;

    @Override
    public Boolean check(String userName, String passWord) {

        Boolean result = false;

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(userName);
        criteria.andPasswordEqualTo(passWord);
        List<User> list = mapper.selectByExample(example);
        if (ListUtils.isNotNullOrEmpty(list)){
            result = true;
        }
        return result;
    }

    @Override
    public User getByAccount(String userName) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andAccountEqualTo(userName);
        List<User> list = mapper.selectByExample(example);
        if (ListUtils.isNotNullOrEmpty(list)){
            User user = list.get(0);
            return user;
        }
        return null;
    }
}
