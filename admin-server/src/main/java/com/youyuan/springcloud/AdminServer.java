package com.youyuan.springcloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/5/29 10:30
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableAdminServer
public class AdminServer {

    public static void main(String[] args) {
        SpringApplication.run(AdminServer.class, args);
    }
}
