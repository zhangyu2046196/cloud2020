package com.youyuan.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/23 14:59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    private static final long serialVersionUID = -3415764937218810834L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 用户
     */
    private Long userId;
    /**
     * 总额度
     */
    private BigDecimal total;
    /**
     * 使用额度
     */
    private BigDecimal used;
    /**
     * 剩余额度
     */
    private BigDecimal residue;
}
