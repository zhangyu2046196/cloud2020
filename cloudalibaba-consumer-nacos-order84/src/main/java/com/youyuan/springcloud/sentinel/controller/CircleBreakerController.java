package com.youyuan.springcloud.sentinel.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.youyuan.springcloud.entities.CommonResult;
import com.youyuan.springcloud.entities.Payment;
import com.youyuan.springcloud.sentinel.feign.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/21 22:21
 */
@RestController
@Slf4j
public class CircleBreakerController {

    private static final String SERVER_URL = "http://payment-service-nacos";

    @Autowired
    private PaymentFeignService paymentFeignService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/queryMysql/{id}")
//    @SentinelResource(value = "fallback")  //  无配置
//    @SentinelResource(value = "fallback", fallback = "handlerFallback")  //fallback只负责业务异常的兜底
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")  //blockHandler只负责sentinel控制台的配置违规兜底
    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler")
    //如果fallback和blockHandler两个都配置时blocakHandler的优先级高于fallback
//    @SentinelResource(value = "fallback", fallback = "handlerFallback", blockHandler = "blockHandler", exceptionsToIgnore = IllegalArgumentException.class)  // IllegalArgumentException 排除兜底比如访问id是4的连接不会报 IllegalArgumentException 异常内容信息
    public CommonResult<Payment> fallback(@PathVariable Long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVER_URL + "/payment/queryMysql/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException, 该ID没有对应记录，空指针异常");
        }
        return result;
    }

    /**
     * fallback的兜底方法  fallback只负责业务异常兜底
     *
     * @param id
     * @param e
     * @return
     */
    public CommonResult<Payment> handlerFallback(Long id, Throwable e) {
        return new CommonResult<>("444", "兜底的运行时异常" + e.getMessage(), new Payment(0L, IdUtil.simpleUUID()));
    }

    /**
     * blockHandler的兜底方法  blockHandler只负责sentinel控制台的违规配置
     *
     * @param id
     * @param e
     * @return
     */
    public CommonResult<Payment> blockHandler(Long id, BlockException e) {
        return new CommonResult<>("445", "sentinel控制台违规配置" + e.getMessage(), new Payment(0L, IdUtil.simpleUUID()));
    }

    @RequestMapping("/consumer/payment/feign/queryMysql/{id}")
    @SentinelResource(value = "feign_fallback", blockHandler = "feignFallback")
    public CommonResult<Payment> queryPaymentBySql(@PathVariable("id") Long id) {
        return paymentFeignService.queryPaymentBySql(id);
    }

    public CommonResult<Payment> feignFallback(Long id, BlockException e) {
        return new CommonResult<Payment>("446", "通过feign调用服务提供者服务限流", new Payment(id, IdUtil.simpleUUID()));
    }

}
