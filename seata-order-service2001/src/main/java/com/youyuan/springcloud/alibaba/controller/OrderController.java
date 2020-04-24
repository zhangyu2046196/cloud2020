package com.youyuan.springcloud.alibaba.controller;

import com.youyuan.springcloud.alibaba.domain.Order;
import com.youyuan.springcloud.alibaba.service.OrderService;
import com.youyuan.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/22 17:56
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单接口
     *
     * @param order
     * @return
     */
    @GetMapping("/order/create")
    public CommonResult create(@RequestBody Order order) {
        orderService.create(order);
        return new CommonResult("200", "创建订单成功");
    }
}
