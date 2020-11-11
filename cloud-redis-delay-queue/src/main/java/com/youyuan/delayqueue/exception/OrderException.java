package com.youyuan.delayqueue.exception;

import lombok.Getter;

/**
 * 类名称：OrderException <br>
 * 类描述： 异常父类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 17:33<br>
 */
@Getter
public class OrderException extends RuntimeException {

    private int code;
    private String info;

    public OrderException(ExceptionCode exceptionCode) {
        super(exceptionCode.getInfo());
        this.code = exceptionCode.getCode();
        this.info = exceptionCode.getInfo();
    }
}
