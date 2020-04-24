package com.youyuan.springcloud.controller;

import cn.hutool.core.util.IdUtil;
import com.youyuan.springcloud.entities.CommonResult;
import com.youyuan.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/21 21:52
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    private static Map<Long, Payment> paymentMap = new HashMap<>();

    static {
        paymentMap.put(1L, new Payment(1L, IdUtil.simpleUUID()));
        paymentMap.put(2L, new Payment(2L, IdUtil.simpleUUID()));
        paymentMap.put(3L, new Payment(3L, IdUtil.simpleUUID()));
    }

    /**
     * 模拟从数据库查询
     *
     * @param id
     * @return
     */
    @RequestMapping("/payment/queryMysql/{id}")
    public CommonResult<Payment> findPaymentById(@PathVariable("id") Long id) {
        return new CommonResult<Payment>("200", "查询成功=" + serverPort, paymentMap.get(id));
    }

}
