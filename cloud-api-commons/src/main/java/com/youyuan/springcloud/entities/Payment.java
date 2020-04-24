package com.youyuan.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangy
 * @version 1.0
 * @description  支付流水类
 * @date 2020/3/29 10:42
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable{
    private static final long serialVersionUID = 4012591638241573687L;
    /**
     * 主键
     */
    private Long id;
    /**
     * 流水号
     */
    private String serial;
}
