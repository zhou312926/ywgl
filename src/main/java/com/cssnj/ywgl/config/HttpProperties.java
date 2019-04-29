package com.cssnj.ywgl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Auther: duq
 * @Date: 2019/1/12 21:32
 */
@Component
@PropertySource("classpath:core.properties")
@ConfigurationProperties(prefix = "http")
public class HttpProperties {

    private String permit;
    private String index;
    private String authc;
    private String home;
    private String login;
    private String logout;
    private String success;
    private String unauthorized;

    public String getPermit() {
        return permit;
    }

    public void setPermit(String permit) {
        this.permit = permit;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getAuthc() {
        return authc;
    }

    public void setAuthc(String authc) {
        this.authc = authc;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getUnauthorized() {
        return unauthorized;
    }

    public void setUnauthorized(String unauthorized) {
        this.unauthorized = unauthorized;
    }
}
