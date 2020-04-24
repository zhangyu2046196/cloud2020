package com.youyuan.springcloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangy
 * @version 1.0
 * @description 通过编码方式配置gateway路由
 * <p>
 * 测试案例通过自己路由访问百度外网
 * @date 2020/4/13 21:10
 */
@Configuration
public class RouteConfig {

    @Bean
    public RouteLocator getRoute1(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("gateway_youyuan_guonei", f -> f.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator getRoute2(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("gateway_youyuan_guoji", f -> f.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();
    }

}
