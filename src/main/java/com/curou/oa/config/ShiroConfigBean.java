package com.curou.oa.config;

import com.curou.oa.entity.CuRouShiroRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro配置Bean
 */
@Configuration
public class ShiroConfigBean {

    @Bean
    public ShiroFilterFactoryBean shirFilter(DefaultWebSecurityManager securityManager) {
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器.
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 设置login URL

        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接 SrpingMVC的优先级别比较高 所以这个跳转没有用
        shiroFilterFactoryBean.setSuccessUrl("/");
        // 未授权的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        // src="jquery/jquery-3.2.1.min.js" 生效
        /**
         * anon不需要验证,authc需要验证
         * 顺序执行 从上往下 如果要在view的子文件不需要验证访问 必须写在("/view/**", "authc")前
         */
        filterChainDefinitionMap.put("/css/*", "anon");
        filterChainDefinitionMap.put("/formSelects/*", "anon");
        filterChainDefinitionMap.put("/layui/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        // 设置登录的URL为匿名访问，因为一开始没有用户验证
        filterChainDefinitionMap.put("/login", "anon");

        filterChainDefinitionMap.put("/lmRegistrationCode/check", "anon");
        filterChainDefinitionMap.put("/checkLogin", "anon");

        filterChainDefinitionMap.put("/Exception.class", "anon");
        // 我写的url一般都是xxx.action，根据你的情况自己修改
        filterChainDefinitionMap.put("/sys/**", "authc");
        // 退出系统的过滤器
        filterChainDefinitionMap.put("/logout", "logout");
        // 现在资源的角色
        filterChainDefinitionMap.put("/admin.html", "roles[admin]");
        // filterChainDefinitionMap.put("/user.ftl", "roles[user]");
        // 最后一班都，固定格式
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /*
     * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * 所以我们需要修改下doGetAuthenticationInfo中的代码; )
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");// 散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1);// 散列的次数，比如散列两次，相当于md5(md5(""));
        return hashedCredentialsMatcher;
    }

    @Bean
    public CuRouShiroRealm myShiroRealm() {
        CuRouShiroRealm cuRouShiroRealm = new CuRouShiroRealm();
        cuRouShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return cuRouShiroRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入自定义的realm;
        securityManager.setRealm(myShiroRealm());
        // 注入缓存管理器;
        securityManager.setCacheManager(ehCacheManager());

        return securityManager;
    }

    /*
     * 开启shiro aop注解支持 使用代理方式;所以需要开启代码支持;
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
     */
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }

    /*
     * shiro缓存管理器;
     * 需要注入对应的其它的实体类中-->安全管理器：securityManager可见securityManager是整个shiro的核心；
     */
    @Bean
    @DependsOn("lifecycleBeanPostProcessor")
    public EhCacheManager ehCacheManager() {
        System.out.println("ShiroConfiguration.getEhCacheManager()");
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        return cacheManager;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }



}
