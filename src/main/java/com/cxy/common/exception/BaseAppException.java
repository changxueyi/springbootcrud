package com.cxy.common.exception;


import com.cxy.common.enums.ResponseStatus;

/**
 * @ClassName BaseAppException.java
 * @Description 经判断业务逻辑不符的异常，如：参数不正常，更新数据非法（已存在）等。不需要添加监控的异常
 * @Author liufenglei
 * @Date 2018/9/14 10:24
 * @Version 1.0
 **/
public class BaseAppException extends BaseException {

    public BaseAppException() {
        super();
    }

    public BaseAppException(String errorMessage) {
        super(errorMessage);
    }

    public BaseAppException(ResponseStatus responseStatus) {
        super(responseStatus);
    }

    public BaseAppException(ResponseStatus responseStatus, Throwable cause) {
        super(responseStatus, cause);
    }

    public BaseAppException(String errorMessage, BaseAppException e) {
        super(errorMessage, e);
    }

    public BaseAppException(Throwable cause) {
        super(cause);
    }


    public BaseAppException(String errorCode, String errorMessage) {
        super(errorCode,errorMessage);
    }

}
