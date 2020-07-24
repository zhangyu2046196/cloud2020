package com.youyuan.springcloud.bean;

import java.io.Serializable;

/**
 * @author mingyang.ma created on 2019-09-21
 * @version 1.0.0
 * @description 各个服务之间返回值
 */
public class ResultDto<T> implements Serializable {
    private static final long serialVersionUID = -1119984211132832602L;
    /**
     * 状态码
     */
    private String code;

    /**
     * 返回信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public ResultDto() {
    }

    public ResultDto(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDto(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static ResultDto success() {
        return new ResultDto("200", "成功");
    }


    public static <T> ResultDto<T> success(T data) {
        return new ResultDto<T>("200", "成功", data);
    }

    public static <T> ResultDto<T> successForData(String code, String message, T data) {
        return new ResultDto<>(code, message, data);
    }

    public static ResultDto failed() {
        return new ResultDto("500", "错误异常");
    }

    public static <T> ResultDto<T> failed(T data) {
        return new ResultDto<T>("500", "错误异常", data);
    }

    public static <T> ResultDto<T> failedWithMessage(String message){
        return new ResultDto<T>("500", message, null);
    }

    public static <T> ResultDto failedForData(String code, String message, T data) {
        return new ResultDto<>(code, message, data);
    }

    /**
     * 请求成功
     *
     * @param code 状态码
     * @param msg  消息信息
     * @param data 返回对象
     * @param <T>  类型
     * @return ResultDto
     */
    public <T> ResultDto success(String code, String msg, T data) {
        return new ResultDto<>(code, msg, data);
    }

    /**
     * 请求失败
     *
     * @param code 状态码
     * @param msg  消息信息
     * @param data 返回对象
     * @param <T>  类型
     * @return ResultDto
     */

    public <T> ResultDto error(String code, String msg, T data) {
        return new ResultDto<>(code, msg, data);
    }

    public String getCode() {
        return code;
    }

    public ResultDto<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ResultDto<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResultDto<T> setData(T data) {
        this.data = data;
        return this;
    }
}
