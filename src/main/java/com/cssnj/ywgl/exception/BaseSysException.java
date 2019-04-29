package com.cssnj.ywgl.exception;

/**
 * @Auther: duq
 * @Date: 2019/2/13 13:43
 */
public class BaseSysException extends BaseException {
    public BaseSysException() {
    }

    public BaseSysException(String message) {
        super(message);
    }

    public BaseSysException(String errorCode, String message) {
        super(errorCode, message);
    }

    public BaseSysException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public BaseSysException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BaseSysException(String errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode, message, cause, enableSuppression, writableStackTrace);
    }
}
