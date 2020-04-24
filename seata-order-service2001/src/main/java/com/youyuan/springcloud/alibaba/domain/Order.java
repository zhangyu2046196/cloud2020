package com.youyuan.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author zhangy
 * @version 1.0
 * @description  订单类与数据库映射
 * @date 2020/4/22 12:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态0- 创建， 1-完成
     */
    private Integer status;
}
