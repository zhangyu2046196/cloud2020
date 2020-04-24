package com.youyuan.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/23 15:08
 */
public interface AccountService {

    /**
     * 扣减金额
     * @param userId
     * @param money
     */
    public void decrease(Long userId, BigDecimal money);
}
