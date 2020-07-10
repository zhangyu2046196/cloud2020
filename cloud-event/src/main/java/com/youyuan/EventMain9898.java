package com.youyuan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/6/30 20:06
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class EventMain9898 {
    public static void main(String[] args) {
        SpringApplication.run(EventMain9898.class, args);
    }
}
