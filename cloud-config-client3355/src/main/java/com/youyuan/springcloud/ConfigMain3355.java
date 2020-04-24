package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/15 15:13
 */
@SpringBootApplication
@EnableEurekaClient
public class ConfigMain3355 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigMain3355.class, args);
    }

}
