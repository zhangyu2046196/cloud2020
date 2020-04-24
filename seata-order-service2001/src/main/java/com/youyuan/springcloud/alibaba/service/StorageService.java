package com.youyuan.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhangy
 * @version 1.0
 * @description  库存feign接口
 * @date 2020/4/22 17:30
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    @PostMapping("/storage/decrease")
    public void decrease(@RequestParam("productId") Long productId,@RequestParam("count") Integer count);
}
