package com.cxy.common.exception;

/**
 * @ClassName BaseErrException.java
 * @Description 非业务逻辑异常，未知异常，如空指针异常、数组越界异常等。需要添加监控的异常
 * @Author liufenglei
 * @Date 2018/9/14 10:26
 * @Version 1.0
 **/
public class BaseErrException extends BaseException {

    private static final long serialVersionUID = 1L;

    public BaseErrException(String errorMessage) {
        super(errorMessage);
    }

    public BaseErrException(String errorMessage, BaseErrException e) {
        super(errorMessage, e);
    }

    public BaseErrException(Throwable cause) {
        super(cause);
    }
}
