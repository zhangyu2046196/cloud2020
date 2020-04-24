package com.youyuan.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zhangy
 * @version 1.0
 * @description 账户feign接口
 * @date 2020/4/22 17:35
 */
@FeignClient("seata-account-service")
public interface AccountService {

    /**
     * 扣款
     *
     * @param userId
     * @param money
     */
    @PostMapping("/account/decrease")
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
