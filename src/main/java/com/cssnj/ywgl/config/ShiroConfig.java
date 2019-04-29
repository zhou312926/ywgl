package com.cssnj.ywgl.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.cssnj.ywgl.service.user.AppRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: duq
 * @Date: 2019/1/30 22:12
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private WebProperites webProperites;
    @Autowired
    private HttpProperties httpProperties;
    private String[] ignore = new String[0];
    private String[] permit = new String[0];
    private String[] authc = new String[0];

    @Bean
    public HashedCredentialsMatcher credentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(1);
        hashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
        return hashedCredentialsMatcher;
    }

    @Bean
    public AppRealm realm(HashedCredentialsMatcher hashedCredentialsMatcher) {
        AppRealm securityRealm = new AppRealm();
        securityRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        securityRealm.setCachingEnabled(false);
        return securityRealm;
    }

    @Bean
    public DefaultWebSecurityManager securityManager(AppRealm cssnjAuthorizingRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(cssnjAuthorizingRealm);  //加入自定义的安全领域
        return securityManager;
    }


//    @Bean
//    public CaptchaFormAuthenticationFilter  captchaFormAuthenticationFilter() {
//        return new CaptchaFormAuthenticationFilter();
//    }

//    @Bean
//    public CssnjAccessControlFilter cssnjAccessControlFilter() {
//        return new CssnjAccessControlFilter();
//    }
//
//    @Bean
//    public CssnjFormAuthenticationFilter cssnjFormAuthenticationFilter() {
//        return new CssnjFormAuthenticationFilter();
//    }


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        shiroFilterFactoryBean.setLoginUrl(httpProperties.getLogin());
        shiroFilterFactoryBean.setSuccessUrl(httpProperties.getSuccess());
        shiroFilterFactoryBean.setUnauthorizedUrl(httpProperties.getUnauthorized());

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
        if (!StringUtils.isEmpty(webProperites.getIgnore())) {
            ignore = webProperites.getIgnore().split(",");
        }
        for (int i = 0; i < ignore.length; i++) {
            filterChainDefinitionMap.put(ignore[i], "anon");
        }
        if (!StringUtils.isEmpty(httpProperties.getPermit())) {
            permit = httpProperties.getPermit().split(",");
        }
        for (int i = 0; i < permit.length; i++) {
            filterChainDefinitionMap.put(permit[i], "anon");
        }
        if (!StringUtils.isEmpty(httpProperties.getAuthc())) {
            authc = httpProperties.getAuthc().split(",");
        }
        for (int i = 0; i < authc.length; i++) {
            filterChainDefinitionMap.put(authc[i], "authc");
        }

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

//        Map<String, Filter> filters = new LinkedHashMap();
//        filters.put("cssnjCaptchaFilter", cssnjCaptchaFilter());
//        filters.put("cssnjAccessControlFilter", cssnjAccessControlFilter());
//        filters.put("captchaFormAuthenticationFilter", captchaFormAuthenticationFilter());
//        shiroFilterFactoryBean.setFilters(filters);
        return shiroFilterFactoryBean;
    }

    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
