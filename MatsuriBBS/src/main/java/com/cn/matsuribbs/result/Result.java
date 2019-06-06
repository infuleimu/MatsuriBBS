package com.cn.matsuribbs.result;

/**
 * @description 统一 API响应结果封装
 * @memo 控制Result权限，构建结果Result对象统一使用ResultFactory工厂类来创建
 */
public class Result {
    private int code;    //响应状态码
    private String message;    //响应提示信息
    private Object data;    //响应结果对象

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getmessage() {
        return message;
    }

    public void setmessage(String message) {
        this.message = message;
    }
}
