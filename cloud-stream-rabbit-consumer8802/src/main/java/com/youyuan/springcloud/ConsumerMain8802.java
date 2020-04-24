package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/17 14:36
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerMain8802 {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain8802.class, args);
    }

}
