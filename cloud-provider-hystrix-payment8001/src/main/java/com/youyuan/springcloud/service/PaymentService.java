package com.youyuan.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/9 21:22
 */
@Service
@Slf4j
public class PaymentService {

    /**
     * 服务正常返回
     *
     * @param id
     * @return
     */
    public String paymentinfo_ok(Integer id) {
        return "服务正常返回paymentinfo_ok,id:" + id + "\tO(∩_∩)O哈哈~";
    }

    /**
     * 超时访问
     * HystrixCommand:一旦调用服务方法失败并抛出了错误信息后,会自动调用@HystrixCommand标注好的fallbckMethod调用类中的指定方法
     * execution.isolation.thread.timeoutInMilliseconds:线程超时时间3秒钟
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentinfo_fail_handler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentinfo_fail(Integer id) {
        log.info("调用服务端O(∩_∩)O哈哈~");
        try {
            //模拟业务需要处理5秒钟，默认openfeign调用服务的时候超时时间默认1秒
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + "服务降级返回paymentinfo_fail,id:" + id + "\tO(∩_∩)O哈哈~";
    }

    /**
     * 服务熔断返回
     *
     * @param id
     * @return
     */
    public String paymentinfo_fail_handler(Integer id) {
        return "服务降级返回paymentinfo_fail,id:" + id + "\to(╥﹏╥)o";
    }


    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler", commandProperties = {
            // 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            // 请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            // 时间窗口
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            // 失败率达到多少
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("输出参数不合法");
        }
        String idStr = IdUtil.simpleUUID();
        return "服务正常返回 idStr:" + idStr;
    }

    public String paymentCircuitBreakerHandler(@PathVariable("id") Integer id) {
        return "服务熔断返回 id:" + id + " o(╥﹏╥)o";
    }
}
