package com.youyuan.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/21 21:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProviderMain9006 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMain9006.class, args);
    }

}
