package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/15 19:11
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3366.class, args);
    }

}
