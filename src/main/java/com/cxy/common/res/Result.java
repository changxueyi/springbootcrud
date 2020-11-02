package com.cxy.common.res;

import com.cxy.common.enums.RpcStatus;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/2 11:13
 */
public class Result implements Serializable {

    /**
     * 结果标志
     */
    private boolean isSuccess;
    /**
     * 结果码
     */
    private String code;
    /**
     * 结果信息描述
     */
    private String msg;

    public Result(){
    }

    /**
     * 未发生异常
     * @param rpcStatus
     */
    public Result(RpcStatus rpcStatus) {
        this.code = rpcStatus.getCode();
        this.msg = rpcStatus.getMsg();
        this.setSuccess(RpcStatus.FAIL != rpcStatus);
    }


    /**
     * 自定义
     * @param code
     * @param msg
     */
    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.setSuccess(false);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
