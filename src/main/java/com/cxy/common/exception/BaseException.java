package com.cxy.common.exception;


import com.cxy.common.enums.ResponseStatus;

/**
 * @ClassName BaseException.java
 * @Description 异常处理类
 * @Author liufenglei
 * @Date 2018/9/14 10:27
 * @Version 1.0
 **/
public abstract class BaseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMessage;

    /**
     * 异常触发原因
     */
    private Throwable cause;

    public BaseException() {
    }

    public BaseException(String errorMessage) {
        this.cause = new Throwable(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = ResponseStatus.FAIL_COMMOM.code;
    }

    public BaseException(ResponseStatus responseStatus) {
        this.errorCode = responseStatus.code;
        this.errorMessage = responseStatus.msg;
        this.cause = new Throwable(responseStatus.msg + ". [errCode:" + responseStatus.code + "]");
    }

    public BaseException(ResponseStatus responseStatus, Throwable cause) {
        this.errorCode = responseStatus.code;
        this.errorMessage = responseStatus.msg;
        this.cause = cause;
    }

    public BaseException(String errorMessage, BaseException e) {
        String causeErrMsg = "";
        if(null != e) {
            if (null != e.getCause()) {
                causeErrMsg = " Caused by :" + e.getCause().getMessage();
            }
            this.errorCode = e.getErrorCode();
            this.errorMessage = errorMessage + causeErrMsg;
            this.cause = e.getCause();
        } else {
            this.errorMessage = errorMessage;
            this.errorCode = ResponseStatus.FAIL_COMMOM.code;
            this.cause = new Throwable(errorMessage + "[errCode:" + ResponseStatus.FAIL_COMMOM.code + "]");
        }
    }

    public BaseException(Throwable cause) {
        super(cause);
    }


    public BaseException(String errorCode, String errorMessage) {
        // super(showMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * Description:获取异常信息
     *
     * @return
     */
    @Override
    public String getMessage() {
        String msg = super.getMessage();
        String causeMsg = null;
        if (this.cause != null) {
            causeMsg = this.cause.getMessage();
        }
        if (msg != null) {
            if (causeMsg != null) {
                return msg + " caused by: " + causeMsg;
            }
            return msg;
        }
        return causeMsg;
    }

}
