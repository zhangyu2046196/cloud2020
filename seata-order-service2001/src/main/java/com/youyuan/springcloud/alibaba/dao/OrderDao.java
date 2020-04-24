package com.youyuan.springcloud.alibaba.dao;

import com.youyuan.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangy
 * @version 1.0
 * @description  接口
 * @date 2020/4/22 13:01
 */
@Mapper
public interface OrderDao {

    /**
     * 保存订单
     * @param order
     */
    public void create(Order order);

    /**
     * 更新订单状态
     * @param id
     * @param status
     */
    public void update(@Param("id") Long id, @Param("status") Integer status);
}
