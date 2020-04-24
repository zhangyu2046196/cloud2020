package com.youyuan.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangy
 * @version 1.0
 * @description 配置类
 * @date 2020/3/29 15:42
 */
@Configuration
public class ApplicationConfig {

    @Bean
    //@LoadBalanced  //通过RestTemplate加负载均衡功能
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
