package com.youyuan.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangy
 * @version 1.0
 * @description feign调用服务提供者
 * @date 2020/4/9 22:13
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-HYSTRIX-SERVICE", fallback = PaymentServiceImpl.class)
public interface PaymentService {

    /**
     * 服务正常返回
     *
     * @param id
     * @return
     */
    @RequestMapping("/payment/hystrix/ok/{id}")
    public String paymentinfo_ok(@PathVariable("id") Integer id);

    /**
     * 服务熔断返回
     *
     * @param id
     * @return
     */
    @RequestMapping("/payment/hystrix/fail/{id}")
    public String paymentinfo_fail(@PathVariable("id") Integer id);

}
