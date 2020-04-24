package com.youyuan.springcloud.alibaba.service.impl;

import com.youyuan.springcloud.alibaba.dao.StorageDao;
import com.youyuan.springcloud.alibaba.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description 扣减库存接口实现类
 * @date 2020/4/23 14:36
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        log.info("库存系统扣减库存开始");
        storageDao.decrease(productId, count);
        log.info("库存系统扣减库存结束");
    }
}
