package com.curou.oa.entity;

import com.curou.oa.models.User;
import com.curou.oa.service.LoginService;
import com.curou.oa.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CuRouShiroRealm extends AuthorizingRealm {
    @Autowired
    LoginService loginService;

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("调用醋肉自定义授权");
        User user = userService.getByAccount(principalCollection.getPrimaryPrincipal().toString());
        //从数据库或者缓存中获取权限数据
        List<String> perms = userService.getPermsByUserAccount(user.getAccount());
        Set<String> pSet = new HashSet<>(perms);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(pSet);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("调用Curou自定义REALM");

        // 将AuthenticationToken强转为AuthenticationToken对象
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 获得从表单传过来的用户名
        String username = upToken.getUsername();

        // 如果用户不存在，抛此异常
        User user = loginService.getByAccount(username);

        if (user==null) {
            throw new UnknownAccountException("无此用户名！");
        }else{
            SecurityUtils.getSubject().getSession().setAttribute("user",user);
            return new SimpleAuthenticationInfo(username,user.getPassword(),super.getName());
        }
    }
}
