package com.youyuan.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/4 19:45
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule getRule() {
        return new RandomRule();
    }
}
