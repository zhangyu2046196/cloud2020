package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/7/23 11:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApp {
    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
