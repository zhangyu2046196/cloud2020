package com.youyuan.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.youyuan.springcloud.entities.CommonResult;

/**
 * @author zhangy
 * @version 1.0
 * @description 自定义服务降级处理
 * @date 2020/4/20 23:23
 */
public class CustomerHandler {

    /**
     * 自定义服务降级处理方法 必须是静态方法 入参必须有BlockException
     *
     * @param exception
     * @return
     */
    public static CommonResult customerHandler1(BlockException exception) {
        return new CommonResult("402", "自定义服务降级处理方法1," + exception.getMessage());
    }

    /**
     * 自定义服务降级处理方法 必须是静态方法 入参必须有BlockException
     *
     * @param exception
     * @return
     */
    public static CommonResult customerHandler2(BlockException exception) {
        return new CommonResult("403", "自定义服务降级处理方法2," + exception.getMessage());
    }
}
