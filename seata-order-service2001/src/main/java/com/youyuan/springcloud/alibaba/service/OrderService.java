package com.youyuan.springcloud.alibaba.service;

import com.youyuan.springcloud.alibaba.domain.Order;

/**
 * @author zhangy
 * @version 1.0
 * @description  订单接口
 * @date 2020/4/22 17:28
 */
public interface OrderService {

    /**
     * 保存订单
     * @param order
     */
    public void create(Order order);
}
