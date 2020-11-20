package com.cxy.controller.Es;

import java.util.List;

/**
 * @ClassName Result
 * @Description TODO
 * @Author changxueyi
 * @Date 2020/11/20 19:16
 */
class ResultEs {

    public String code;
    public Object data;
    public String msg;

    public static ResultEs success(Object data) {
        ResultEs baseResult = new ResultEs();
        baseResult.setCode("200");
        baseResult.setMsg("成功");
        baseResult.setData(data);
        return baseResult;
    }
    public static ResultEs success(List<Object> data) {
        ResultEs baseResult = new ResultEs();
        baseResult.setCode("200");
        baseResult.setMsg("成功");
        baseResult.setData(data);
        return baseResult;
    }

    public static ResultEs success() {
        ResultEs baseResult = new ResultEs();
        baseResult.setCode("200");
        baseResult.setMsg("成功");
        return baseResult;
    }

    public static ResultEs error() {
        ResultEs baseResult = new ResultEs();
        baseResult.setCode("404");
        baseResult.setMsg("失败");
        return baseResult;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ResultEs{" +
                "code='" + code + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}