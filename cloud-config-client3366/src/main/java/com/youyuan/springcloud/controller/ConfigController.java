package com.youyuan.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description 测试配置中心
 * @RefreshScope注解用于实现配置中心修改后自动刷新业务服务的配置内容
 * @date 2020/4/15 15:11
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${config.info}")
    private String configInfoData;

    @Value("${server.port}")
    private String port;

    /**
     * 获取配置中心内容
     *
     * @return
     */
    @RequestMapping("/config/info")
    public String configInfo() {
        return "server port:" + port + " config info:" + configInfoData;
    }

}
