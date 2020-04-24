package com.youyuan.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/19 15:23
 */
@RestController
@RefreshScope
@Slf4j
public class ConfigController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/config/info/{id}")
    public String getConfigInfo(@PathVariable("id") Long id) {
        return "从配置中心获取配置信息,configinfo:" + configInfo + " id:" + id;
    }
}
