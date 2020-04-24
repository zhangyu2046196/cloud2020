package com.youyuan.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.youyuan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/9 22:15
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "gloabFallBack")
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 服务正常返回
     *
     * @param id
     * @return
     */
    @RequestMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id) {
        return paymentService.paymentinfo_ok(id);
    }

    /**
     * 服务熔断返回
     *
     * @param id
     * @return
     */
//    @HystrixCommand(fallbackMethod = "paymentinfo_fail_handler", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
//    })
    @HystrixCommand
    @RequestMapping("/consumer/payment/hystrix/fail/{id}")
    public String paymentinfo_fail(@PathVariable("id") Integer id) {
        log.info("test rollback request param id={}", id);
        int a = 10 / 0;
        String fail = paymentService.paymentinfo_fail(id);
        log.info("服务端返回结果");
        return fail;
    }

    public String paymentinfo_fail_handler(@PathVariable("id") Integer id) {
        return "我是80接口,现在由于运行时异常或系统异常导致服务降级，请5秒后重试";
    }

    /**
     * 全局服务降级方法
     * @return
     */
    public String gloabFallBack() {
        return "全局服务降级方法";
    }

}
