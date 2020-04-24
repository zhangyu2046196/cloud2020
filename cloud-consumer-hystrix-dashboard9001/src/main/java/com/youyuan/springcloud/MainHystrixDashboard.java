package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/12 21:21
 */
@SpringBootApplication
@EnableHystrixDashboard
public class MainHystrixDashboard {

    public static void main(String[] args) {
        SpringApplication.run(MainHystrixDashboard.class, args);
    }

}
