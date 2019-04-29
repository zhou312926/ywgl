package com.cssnj.ywgl.exception;

/**
 * @Auther: duq
 * @Date: 2019/2/13 13:43
 */
public class BaseBizException extends BaseException {
    public BaseBizException() {
    }

    public BaseBizException(String message) {
        super(message);
    }

    public BaseBizException(String errorCode, String message) {
        super(errorCode, message);
    }

    public BaseBizException(String errorCode, String message, Throwable cause) {
        super(errorCode, message, cause);
    }

    public BaseBizException(String errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BaseBizException(String errorCode, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(errorCode, message, cause, enableSuppression, writableStackTrace);
    }
}
