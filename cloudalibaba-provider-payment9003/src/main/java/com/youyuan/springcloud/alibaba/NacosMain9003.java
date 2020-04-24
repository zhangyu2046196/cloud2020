package com.youyuan.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/18 22:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosMain9003 {

    public static void main(String[] args) {
        SpringApplication.run(NacosMain9003.class, args);
    }

}
