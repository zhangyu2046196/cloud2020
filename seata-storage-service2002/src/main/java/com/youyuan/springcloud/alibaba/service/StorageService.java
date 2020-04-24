package com.youyuan.springcloud.alibaba.service;

import org.apache.ibatis.annotations.Param;

/**
 * @author zhangy
 * @version 1.0
 * @description 库存接口
 * @date 2020/4/23 14:36
 */
public interface StorageService {

    /**
     * 减库存
     * @param productId
     * @param count
     */
    public void decrease(Long productId, Integer count);
}
