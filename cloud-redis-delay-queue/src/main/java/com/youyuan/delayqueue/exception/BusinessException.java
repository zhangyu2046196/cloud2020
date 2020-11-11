package com.youyuan.delayqueue.exception;

import lombok.Getter;

/**
 * 类名称：BusinessException <br>
 * 类描述： 业务异常父类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 17:33<br>
 */
@Getter
public class BusinessException extends OrderException {

    public BusinessException(ExceptionCode exceptionCode) {
        super(exceptionCode);
    }
}
