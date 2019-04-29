package com.cssnj.ywgl.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * @Auther: duq
 * @Date: 2019/2/6 09:57
 */
public class IncompleteUserException extends AuthenticationException {


    public IncompleteUserException() {
    }

    public IncompleteUserException(String message) {
        super(message);
    }

    public IncompleteUserException(Throwable cause) {
        super(cause);
    }

    public IncompleteUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
