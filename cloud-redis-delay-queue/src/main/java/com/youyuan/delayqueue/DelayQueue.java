package com.youyuan.delayqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/7/23 11:19
 */
@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
public class DelayQueue {
    public static void main(String[] args) {
        SpringApplication.run(DelayQueue.class, args);
    }
}
