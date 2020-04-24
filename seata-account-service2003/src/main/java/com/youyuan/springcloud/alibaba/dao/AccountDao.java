package com.youyuan.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author zhangy
 * @version 1.0
 * @description  用户账户接口
 * @date 2020/4/23 15:03
 */
@Mapper
public interface AccountDao {

    /**
     * 扣减资金
     * @param userId
     * @param money
     */
    public void decrease(@Param("userId") Long userId,@Param("money") BigDecimal money);
}
