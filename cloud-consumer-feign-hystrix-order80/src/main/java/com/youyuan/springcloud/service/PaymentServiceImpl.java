package com.youyuan.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author zhangy
 * @version 1.0
 * @description  统一服务降级实现类
 * @date 2020/4/10 22:41
 */
@Component
public class PaymentServiceImpl implements PaymentService {
    @Override
    public String paymentinfo_ok(Integer id) {
        return "调用feign服务接口paymentinfo_ok服务降级";
    }

    @Override
    public String paymentinfo_fail(Integer id) {
        return "调用feign服务接口paymentinfo_fail服务降级";
    }
}
