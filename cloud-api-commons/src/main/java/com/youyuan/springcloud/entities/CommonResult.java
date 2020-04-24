package com.youyuan.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangy
 * @version 1.0
 * @description  通用返回实体
 * @date 2020/3/29 11:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> implements Serializable {
    private static final long serialVersionUID = -6324806468901149687L;

    public CommonResult(String code, String msg) {
        this(code,msg,null);
    }

    /**
     * 状态码
     */
    private String code;
    /**
     * 状态描述
     */
    private String msg;
    /**
     * 业务类
     */
    private T data;

}
