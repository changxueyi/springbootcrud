package com.cxy.common.enums;

/**
 * @ClassName RpcStatus
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/10/29 14:45
 */
public enum  RpcStatus {
    SUCCESS("0000","成功"),
    FAIL("00001","失败");

    public String code;
    public String msg;

    private RpcStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}