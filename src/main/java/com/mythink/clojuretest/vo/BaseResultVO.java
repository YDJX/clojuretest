package com.mythink.clojuretest.vo;

/**
 * Created by SEELE on 2019/9/22.
 *
 * @author SEELE
 * @date 2019/9/22
 * @copyright Copyright 2017-2027 JD.COM All Right Reserved
 */
public class BaseResultVO<T>  {

    private boolean success;

    private int code;

    private String message;

    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseResultVO{" +
                "success=" + success +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
