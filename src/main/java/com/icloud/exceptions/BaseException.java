package com.icloud.exceptions;

public class BaseException extends RuntimeException {

    private String excetionCode;

    public BaseException() {

    }

    public BaseException(String message) {
        super(message);
    }
    public BaseException(String excetionCode,String message) {
        super(message);
        this.excetionCode = excetionCode;
    }
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getExcetionCode() {
        return excetionCode;
    }

    public void setExcetionCode(String excetionCode) {
        this.excetionCode = excetionCode;
    }
}
