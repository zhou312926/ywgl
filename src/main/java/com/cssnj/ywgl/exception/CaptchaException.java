package com.cssnj.ywgl.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Auther: duq
 * @Date: 2019/2/6 09:57
 */
public class CaptchaException extends AuthenticationException {


    public CaptchaException() {
    }

    public CaptchaException(String message) {
        super(message);
    }

    public CaptchaException(Throwable cause) {
        super(cause);
    }

    public CaptchaException(String message, Throwable cause) {
        super(message, cause);
    }
}
