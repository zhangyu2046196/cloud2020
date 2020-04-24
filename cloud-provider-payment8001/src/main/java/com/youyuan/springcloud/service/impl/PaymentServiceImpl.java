package com.youyuan.springcloud.service.impl;

import com.youyuan.springcloud.dao.PaymentDao;
import com.youyuan.springcloud.entities.Payment;
import com.youyuan.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/3/29 12:22
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
