package com.youyuan.springcloud.controller;

import com.youyuan.springcloud.entities.CommonResult;
import com.youyuan.springcloud.entities.Payment;
import com.youyuan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangy
 * @version 1.0
 * @description 订单控制类
 * @date 2020/3/29 12:23
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;  //通过DiscoveryClient可以获取eureka上注册的服务列表以及每个服务下的实例列表

    /**
     * 保存订单
     *
     * @param payment 订单实体bean
     * @return
     */
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        log.info("provider下单请求参数payment={}", payment);
        int result = paymentService.create(payment);
        if (result > 0) {
            return new CommonResult("200", "插入数据库成功,serverport:" + port, result);
        } else {
            return new CommonResult("500", "插入数据库失败", null);
        }
    }

    /**
     * 根据主键查询
     *
     * @param id 主键
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("provider查询订单参数id={}", id);
        if (payment != null) {
            return new CommonResult("200", "查询数据成功,serverport:" + port, payment);
        } else {
            return new CommonResult("500", "查询数据不存在,id:" + id, null);
        }
    }

    @GetMapping(value = "/eureka/discovery")
    public Object findServices() {
        List<String> services = discoveryClient.getServices();
        services.forEach(serivce -> log.info("eureka上的服务列表{}\t", serivce));

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");  //获取指定微服务CLOUD-PAYMENT-SERVICE在eureka上的实例列表
        instances.forEach(instance -> log.info("CLOUD-PAYMENT-SERVICE服务在eureka上的实例名={},ip={},port={},uri={}", instance.getServiceId(), instance.getHost(), instance.getPort(), instance.getUri()));

        return discoveryClient;

    }

    @GetMapping("/payment/lb")
    public String getLb() {
        return port;
    }

    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

    /**
     * 测试sleuth+zipkin全链路追踪
     * @return
     */
    @GetMapping("/payment/zipkin")
    public String paymentZipkin() {
        return "hi，i`am payment zipkin server fall back, welcome to cqvie";
    }
}
