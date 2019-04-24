package com.curou.oa.config;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * @author lxr
 * @version v0.01
 * @date 2019/3/30 0030
 * @email 200890949@qq.com
 */
@Component
public class ShiroTagFreeMarkerConfigurer implements InitializingBean {
    @Autowired
    private Configuration configuration;

    @Autowired
    private FreeMarkerViewResolver resolver;

    @Override
    public void afterPropertiesSet() throws Exception {
        // 加上这句后，可以在页面上使用shiro标签
        configuration.setSharedVariable("shiro", new ShiroTags());

    }
}
