package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/17 7:59
 */
@SpringBootApplication
@EnableEurekaClient
public class ProviderMain8801 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMain8801.class, args);
    }

}
