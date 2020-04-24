package com.youyuan.springcloud.sentinel.feign.impl;

import com.youyuan.springcloud.entities.CommonResult;
import com.youyuan.springcloud.entities.Payment;
import com.youyuan.springcloud.sentinel.feign.PaymentFeignService;
import org.springframework.stereotype.Component;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/22 8:19
 */
@Component
public class PaymentFeignServiceImpl implements PaymentFeignService
{
    @Override
    public CommonResult<Payment> queryPaymentBySql(Long id) {
        return new CommonResult<Payment>("446","通过feign调用服务提供者服务熔断",new Payment(id,"error serial"));
    }
}
