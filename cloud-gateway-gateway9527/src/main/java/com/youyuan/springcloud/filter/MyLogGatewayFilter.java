package com.youyuan.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zhangy
 * @version 1.0
 * @description 自定义过滤器
 * <p>
 * 模拟场景：
 * 过滤请求必须带着uname参数，然后打印日志
 * @date 2020/4/14 21:37
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //判断请求参数是否有uname
        if (!exchange.getRequest().getQueryParams().containsKey("uname")) {

            log.info("抱歉,请求失败,请求参数必须带着uname参数o(╥﹏╥)o");
            //设置响应状态码
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            //返回response
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    /**
     * 过滤器的优先级，值越小优先级越高
     *
     * @return
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
