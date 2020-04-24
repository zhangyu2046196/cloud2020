package com.youyuan.springcloud.sentinel.feign;

import com.youyuan.springcloud.entities.CommonResult;
import com.youyuan.springcloud.entities.Payment;
import com.youyuan.springcloud.sentinel.feign.impl.PaymentFeignServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/22 8:15
 */
@FeignClient(value = "payment-service-nacos", fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeignService {

    @RequestMapping("/payment/queryMysql/{id}")
    public CommonResult<Payment> queryPaymentBySql(@PathVariable("id") Long id);
}
