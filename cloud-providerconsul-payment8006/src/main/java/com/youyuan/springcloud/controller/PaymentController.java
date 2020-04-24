package com.youyuan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/4 17:10
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/payment/consul")
    public String paymentConsul(){
        return "Spring cloud with consul port "+port+" UUID "+ UUID.randomUUID();
    }
}
