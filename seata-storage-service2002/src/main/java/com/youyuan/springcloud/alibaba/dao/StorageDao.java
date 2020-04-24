package com.youyuan.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhangy
 * @version 1.0
 * @description 库存接口
 * @date 2020/4/23 14:23
 */
@Mapper
public interface StorageDao {

    public void decrease(@Param("productId") Long productId, @Param("count") Integer count);

}
