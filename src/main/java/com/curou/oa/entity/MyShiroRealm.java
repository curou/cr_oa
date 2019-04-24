package com.curou.oa.entity;

import com.curou.oa.models.User;
import com.curou.oa.service.LoginService;
import com.curou.oa.service.PermissionService;
import com.curou.oa.service.RoleService;
import com.curou.oa.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * realm实现类,用于实现具体的验证和授权方法
 * @author Bean
 *
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permisService;

    /**
     * 方面用于认证 加密 参数：AuthenticationToken是从表单穿过来封装好的对象
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo:" + token);

        // 将AuthenticationToken强转为AuthenticationToken对象
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;

        // 获得从表单传过来的用户名
        String username = upToken.getUsername();

        // 如果用户不存在，抛此异常
        User user = loginService.getByAccount(username);
//        if (user.getUserStatus().equals("1")){
//            throw new AjaxException("该用户已被禁用 请联系管理员");
//        }
        if (user==null) {
            throw new UnknownAccountException("无此用户名！");
        }else{
            //放到session
            SecurityUtils.getSubject().getSession().setAttribute("user",user);
            return new SimpleAuthenticationInfo(username,"",super.getName());
        }

/*        // 认证的实体信息，可以是username，也可以是用户的实体类对象，这里用的用户名
        Object principal = username;
        // 从数据库中查询的密码
        Object credentials = userService.selectPassword(username);
        // 颜值加密的颜，可以用用户名
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        // 当前realm对象的名称，调用分类的getName()
        String realmName = this.getName();

        // 创建SimpleAuthenticationInfo对象，并且把username和password等信息封装到里面
        // 用户密码的比对是Shiro帮我们完成的
        SimpleAuthenticationInfo info = null;
        info = new SimpleAuthenticationInfo(principal, credentials, credentialsSalt, realmName);
        return info;*/

//        return null;
    }

    // 用于授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        User user = userService.getByAccount(principals.getPrimaryPrincipal().toString());
        SimpleAuthorizationInfo sai  = new SimpleAuthorizationInfo();
        //根据角色分配 权限之后再完善
//        if (user.getUserRole()!=null){
//            List<String> roleIds = Arrays.asList(user.getUserRole().split(","));
//            for (String roleId:
//                 roleIds) {
//                Role role = roleService.getById(roleId);
//                if (role==null){
//                    return sai;
//                }
//                List<String> permisId = Arrays.asList(role.getRolePermission().split(","));
//                for (String id:
//                     permisId) {
//                    Permission permission = permisService.getById(id);
//                    sai.addStringPermission(permission.getPermissionKey());
//                }
//                sai.addRole(role.getRoleKey());
        //}
        return sai;

    }

}
