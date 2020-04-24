package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/17 15:02
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8803.class, args);
    }

}
