package com.cssnj.ywgl.dto.user;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @Auther: duq
 * @Date: 2019/2/6 09:51
 */
public class CaptchaToken extends UsernamePasswordToken {

    private String captchaCode;

    public CaptchaToken() {
        super.setRememberMe(false);
    }

    public CaptchaToken(String username, char[] password, String captchaCode) {
        super(username, (char[]) password, false, (String) null);
        this.captchaCode = captchaCode;
    }

    public CaptchaToken(String username, String password, String captchaCode) {
        super(username, (char[]) (password != null ? password.toCharArray() : null), false, (String) null);
        this.captchaCode = captchaCode;
    }

    public CaptchaToken(String username, char[] password, String captchaCode, String host) {
        super(username, password, false, host);
        this.captchaCode = captchaCode;
    }

    public CaptchaToken(String username, String password, String captchaCode, String host) {
        super(username, password != null ? password.toCharArray() : null, false, host);
        this.captchaCode = captchaCode;
    }

    public CaptchaToken(String username, char[] password, String captchaCode, boolean rememberMe) {
        super(username, (char[]) password, rememberMe, (String) null);
        this.captchaCode = captchaCode;
    }

    public CaptchaToken(String username, String password, String captchaCode, boolean rememberMe) {
        super(username, (char[]) (password != null ? password.toCharArray() : null), rememberMe, (String) null);
        this.captchaCode = captchaCode;
    }

    public CaptchaToken(String username, char[] password, String captchaCode, boolean rememberMe, String host) {
        super.setRememberMe(false);
        super.setUsername(username);
        super.setPassword(password);
        super.setRememberMe(rememberMe);
        super.setHost(host);
        this.captchaCode = captchaCode;
    }

    public CaptchaToken(String username, String password, String captchaCode, boolean rememberMe, String host) {
        super(username, password != null ? password.toCharArray() : null, rememberMe, host);
        this.captchaCode = captchaCode;
    }

    public String getUsername() {
        return super.getUsername();
    }

    public void setUsername(String username) {
        super.setUsername(username);
        ;
    }

    public char[] getPassword() {
        return super.getPassword();
    }

    public void setPassword(char[] password) {
        super.setPassword(password);
    }

    public Object getPrincipal() {
        return super.getUsername();
    }

    public Object getCredentials() {
        return super.getPassword();
    }

    public String getHost() {
        return super.getHost();
    }

    public void setHost(String host) {
        super.setHost(host);
    }

    public boolean isRememberMe() {
        return super.isRememberMe();
    }

    public void setRememberMe(boolean rememberMe) {
        super.setRememberMe(rememberMe);
    }

    public String getCaptchaCode() {
        return captchaCode;
    }

    public void setCaptchaCode(String captchaCode) {
        this.captchaCode = captchaCode;
    }

    public void clear() {
        super.clear();
        this.captchaCode = null;

    }

    public String toString() {
        return super.toString();
    }
}
