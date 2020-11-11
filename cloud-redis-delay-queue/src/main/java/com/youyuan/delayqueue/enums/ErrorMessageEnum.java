package com.youyuan.delayqueue.enums;

import com.youyuan.delayqueue.exception.ExceptionCode;

/**
 * 类名称：ErrorMessageEnum <br>
 * 类描述： 错误码枚举 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 17:29<br>
 */
public enum ErrorMessageEnum implements ExceptionCode {

    ACQUIRE_LOCK_FAIL(10010, "获取分布式锁失败"),
    JOB_ALREADY_EXIST(10020, "JOB信息已存在"),

    ;

    private int code;

    private String info;

    ErrorMessageEnum(int code, String info) {
        this.code = code;
        this.info = info;
    }

    /**
     * 获取异常编码
     *
     * @return 异常码
     */
    @Override
    public int getCode() {
        return code;
    }

    /**
     * 获取异常信息
     *
     * @return 异常信息
     */
    @Override
    public String getInfo() {
        return info;
    }
}
