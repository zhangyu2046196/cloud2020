package com.youyuan.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/1 21:42
 */
@RestController
public class ConsumerController {

    //远程服务地址
    private static final String INVOKE_URL = "http://cloud-provider-service";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/zk")
    public String query() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/zk", String.class);
    }
}
