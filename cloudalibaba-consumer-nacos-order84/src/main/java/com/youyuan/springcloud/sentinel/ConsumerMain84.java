package com.youyuan.springcloud.sentinel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/21 22:20
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerMain84 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain84.class, args);
    }

}
