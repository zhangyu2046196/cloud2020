package com.youyuan.springcloud.alibaba.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/19 23:11
 */
@RestController
@Slf4j
public class SentinelController {

    @RequestMapping("/sentinel/testa")
    public String testA() {
        String result = Thread.currentThread().getName() + ".........." + IdUtil.simpleUUID() + "=======>> testA";
        log.info(result);
        return result;
    }

    @RequestMapping("/sentinel/testb")
    public String testB() {
        return IdUtil.simpleUUID() + "=======>> testB";
    }

    @RequestMapping("/sentinel/testc")
    public String testC() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return IdUtil.simpleUUID() + "----------->>>>> testC 测试RT";
    }

    @GetMapping("/sentinel/testd")
    public String testD() {
        int a = 10 / 0;
        return Thread.currentThread().getName() + " testD 测试异常比例";
    }

    @GetMapping("/sentinel/teste")
    public String testE() {
        int a = 10 / 0;
        return Thread.currentThread().getName() + " testD 测试异常数";
    }

    /**
     * 测试热点参数限流
     *
     * @param p1
     * @param p2
     * @return
     * @SentinelResource类似Hystrix中的@HystrixCommand注解,作用是指定兜底的方法,value是唯一名字用于配置热点参数限流的资源名,blockHandler指定兜底方法名
     */
    @RequestMapping("/sentinel/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
    public String testHotKey(String p1, String p2) {
        return "====== testHotKey,p1:" + p1 + " p2:" + p2;
    }

    public String deal_testHotKey(String p1, String p2, BlockException exception) {
        return "热点参数限流o(╥﹏╥)o";  //sentinel默认的系统异常信息   block by sentinel (flow limit)
    }
}
