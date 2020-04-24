package com.youyuan.springcloud.controller;

import com.youyuan.springcloud.entities.CommonResult;
import com.youyuan.springcloud.entities.Payment;
import com.youyuan.springcloud.lb.LoadBanlce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangy
 * @version 1.0
 * @description 消费者控制类
 * @date 2020/3/29 15:43
 */
@RestController
@Slf4j
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";  //调用单机
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";  //调用集群

    @Autowired
    private DiscoveryClient discoveryClient;
    @Autowired
    private LoadBanlce loadBanlce;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info("consumer下单请求参数payment={}", payment);
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> get(@PathVariable("id") Long id) {
        log.info("consumer查询订单参数id={}", id);
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/lb")
    public String getLb() {
        ServiceInstance serviceInstance = loadBanlce.getServiceInstance(discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"));
        return restTemplate.getForObject(serviceInstance.getUri() + "/payment/lb", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin() {
        ServiceInstance serviceInstance = loadBanlce.getServiceInstance(discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE"));
        return restTemplate.getForObject(serviceInstance.getUri() + "/payment/zipkin", String.class);
    }

}
