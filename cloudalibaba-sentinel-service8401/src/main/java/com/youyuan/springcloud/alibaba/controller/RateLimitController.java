package com.youyuan.springcloud.alibaba.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.youyuan.springcloud.alibaba.handler.CustomerHandler;
import com.youyuan.springcloud.entities.CommonResult;
import com.youyuan.springcloud.entities.Payment;
import io.micrometer.core.instrument.Meter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description 测试@SentinelResource注解
 * @date 2020/4/20 21:43
 */
@RestController
@Slf4j
public class RateLimitController {

    /**
     * 基于资源名限流
     * <p>
     * 如果触发限流会调用blockHandler指定的byResource方法做降级
     *
     * @return
     */
    @RequestMapping("/sentinel/byResource")
    @SentinelResource(value = "byResource", blockHandler = "byResource")
    public CommonResult<Payment> limitByResource() {
        return new CommonResult<>("200", "测试基于资源名限流ok", new Payment(1L, IdUtil.simpleUUID()));
    }

    public CommonResult<Payment> byResource(BlockException exception) {
        return new CommonResult<>("201", "基于资源名限流兜底," + exception.getMessage(), new Payment(2L, "============"));
    }

    /**
     * 基于访问url限流
     *
     * 因为@SentinelResource没有配置blockHandler所以达到阈值后走的是系统默认的兜底方法
     *
     * @return
     */
    @RequestMapping("/sentinel/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<Payment> limitByUrl() {
        return new CommonResult<>("200", "测试基于访问url限流ok", new Payment(3L, IdUtil.simpleUUID()));
    }

    /**
     * 自定义限流类
     *
     * @SentinelResource  value：资源名称  blockHandlerClass：自定义限流类   blockHandler：自定义限流类里面方法
     *
     * @return
     */
    @RequestMapping("/sentinel/customerHandler")
    @SentinelResource(value = "customerHandler",blockHandlerClass = CustomerHandler.class,blockHandler = "customerHandler1")
    public CommonResult customH(){
        return new CommonResult<>("200", "测试自定义限流ok", new Payment(9L, IdUtil.simpleUUID()));
    }

}
