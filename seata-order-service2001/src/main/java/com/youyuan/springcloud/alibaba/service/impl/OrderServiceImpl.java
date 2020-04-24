package com.youyuan.springcloud.alibaba.service.impl;

import com.youyuan.springcloud.alibaba.dao.OrderDao;
import com.youyuan.springcloud.alibaba.domain.Order;
import com.youyuan.springcloud.alibaba.service.AccountService;
import com.youyuan.springcloud.alibaba.service.OrderService;
import com.youyuan.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description 订单接口实现类
 * @date 2020/4/22 17:33
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;

    @Autowired
    private AccountService accountService;

    @GlobalTransactional
    @Override
    public void create(Order order) {
        log.info("下单参数信息:" + order);
        //1、保存订单
        log.info("保存订单开始");
        orderDao.create(order);
        log.info("保存订单结束");
        //2、通过feign调用库存系统减库存
        log.info("扣减库存开始");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("扣减库存结束");
        //3、通过feign调用账户系统扣款
        log.info("账户扣款开始");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("账户扣款结束");
        //4、修改订单状态
        log.info("修改订单状态开始");
        orderDao.update(order.getId(), 0);
        log.info("修改订单状态结束");
    }
}
