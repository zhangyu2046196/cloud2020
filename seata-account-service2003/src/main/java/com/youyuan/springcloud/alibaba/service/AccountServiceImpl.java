package com.youyuan.springcloud.alibaba.service;

import com.youyuan.springcloud.alibaba.dao.AccountDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/23 15:11
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("扣减用户库存开始");
        accountDao.decrease(userId, money);
        log.info("扣减用户库存结束");
    }
}
