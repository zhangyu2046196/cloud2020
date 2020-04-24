package com.youyuan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/16 9:14
 */
@RestController
@RefreshScope
public class OrderController {

    @Value("${order.prefix}")
    private String orderPrefix;

    @RequestMapping("/order/prefix")
    public String orderPrefixInfo() {
        return orderPrefix;
    }
}
