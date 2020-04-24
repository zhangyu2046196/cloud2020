package com.youyuan.springcloud.service;

import com.youyuan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangy
 * @version 1.0
 * @description  订单接口类
 * @date 2020/3/29 12:21
 */
public interface PaymentService {

    /**
     * 保存订单
     * @param payment  订单实体bean
     * @return
     */
    public int create(Payment payment);

    /**
     * 根据主键查询
     * @param id  主键
     * @return
     */
    public Payment getPaymentById(Long id);
}
