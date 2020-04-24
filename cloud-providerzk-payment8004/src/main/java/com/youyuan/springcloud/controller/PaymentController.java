package com.youyuan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhangy
 * @version 1.0
 * @description  controller
 * @date 2020/3/31 22:40
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/zk")
    public String get(){
        return "Spring cloud with zookeeper port:"+port +"  "+ UUID.randomUUID();
    }
}
