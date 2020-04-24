package com.youyuan.springcloud.alibaba.controller;

import com.youyuan.springcloud.alibaba.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/23 15:12
 */
@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account/decrease")
    public void decrease(Long userId, BigDecimal money) {
        accountService.decrease(userId, money);
    }
}
