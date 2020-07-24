package com.youyuan.springcloud.impl;

import com.alibaba.fastjson.JSON;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import io.netty.util.internal.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类名称：OrderValidateService <br>
 * 类描述： 订单预订校验 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/14 15:59<br>
 */
@Service
@Slf4j
public class OrderValidateService {

    /**
     * 方法名: checkTime <br>
     * 方法描述: 入离时间校验 <br>
     *
     * @param orderDto 预订请求参数
     * @return {@link ResultDto<OrderResponseDto> 返回校验结果 }
     * @date 创建时间: 2020/7/14 19:39 <br>
     * @author zhangyu
     */
    public final ResultDto<OrderResponseDto> checkTime(BaseOrderDto orderDto) {
        log.info("请求参数={}", JSON.toJSONString(orderDto));
        return ResultDto.success();
    }

    /**
     * 方法名: validateResult <br>
     * 方法描述: 解析校验结果 <br>
     *
     * @param resultDto 校验结果
     * @return {@link Boolean 返回结果 true校验通过 false校验失败 }
     * @date 创建时间: 2020/7/20 11:13 <br>
     * @author zhangyu
     */
    public final Boolean validateResult(ResultDto<OrderResponseDto> resultDto) {
        if (resultDto!=null && "200".equals(resultDto.getCode())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
