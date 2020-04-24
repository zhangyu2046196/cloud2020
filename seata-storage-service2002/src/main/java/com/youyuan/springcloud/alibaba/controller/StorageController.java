package com.youyuan.springcloud.alibaba.controller;

import com.youyuan.springcloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/23 14:38
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     *
     * @param productId
     * @param count
     */
    @PostMapping("/storage/decrease")
    public void decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
    }
}
