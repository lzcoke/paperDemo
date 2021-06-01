package com.lzcoke.utils;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("结果参数")
public class ResultUtils<T> {
    @ApiModelProperty(required = true, notes = "结果码", example = "200")
    private int code = 404;

    @ApiModelProperty(required = true, notes = "返回信息说明", example = "SUCCESS")
    private String message = "success";

    @ApiModelProperty(required = true, notes = "返回数据")
    private T data;

    public ResultUtils() {
    }

    public ResultUtils(int code, String message, T data) {
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
        return "ResultUtils{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
