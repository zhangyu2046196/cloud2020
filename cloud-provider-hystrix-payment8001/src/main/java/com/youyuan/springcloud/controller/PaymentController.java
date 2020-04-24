package com.youyuan.springcloud.controller;

import com.youyuan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/9 21:27
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 服务正常返回
     *
     * @param id
     * @return
     */
    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id) {
        return paymentService.paymentinfo_ok(id);
    }

    /**
     * 服务熔断返回
     *
     * @param id
     * @return
     */
    @RequestMapping("/payment/hystrix/fail/{id}")
    public String paymentinfo_fail(@PathVariable("id") Integer id) {
        return paymentService.paymentinfo_fail(id);
    }

    /**
     * 测试服务熔断及链路自动恢复
     *
     * @param id
     * @return
     */
    @RequestMapping("/payment/hystrix/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        return paymentService.paymentCircuitBreaker(id);
    }
}
