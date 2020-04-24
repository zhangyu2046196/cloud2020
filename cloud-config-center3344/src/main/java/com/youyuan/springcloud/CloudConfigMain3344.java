package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/14 22:32
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfigMain3344 {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigMain3344.class, args);
    }

}
