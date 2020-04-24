package com.youyuan.springcloud.service;

import com.youyuan.springcloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhangy
 * @version 1.0
 * @description  openfeign接口
 * @date 2020/4/7 21:44
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 调用服务提供者
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * 测试feign调用服务超时
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout();

}
