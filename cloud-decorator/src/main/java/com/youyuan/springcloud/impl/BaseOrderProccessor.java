package com.youyuan.springcloud.impl;

import com.alibaba.fastjson.JSON;
import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 类名称：BaseOrderConfigService <br>
 * 类描述： 订单预订基础流程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/6 19:13<br>
 */
@Service
@Slf4j
public class BaseOrderProccessor implements OrderProccessor {


    @Override
    public ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto) {
        log.info("数据校验—基础");
        return ResultDto.success();
    }

    @Override
    public ResultDto<OrderResponseDto> verifyChannel(BaseOrderDto orderDto, OrderInfo orderInfo) {
        log.info("渠道校验—基础");
        return ResultDto.success();
    }

    @Override
    public ResultDto<OrderResponseDto> deductionStorage(BaseOrderDto orderDto, OrderInfo orderInfo) {
        log.info("扣减库存—基础");
        orderInfo.setOrderNo("999999999997777777777777");
        log.info("扣减库存基础orderInfo:"+orderInfo);
        return ResultDto.success();
    }

    @Override
    public ResultDto<OrderResponseDto> createOrderRoom(BaseOrderDto orderDto, OrderInfo orderInfo) {
        log.info("生成订单—基础");
        return new ResultDto<OrderResponseDto>("200", "成功", new OrderResponseDto(orderInfo.getOrderNo(), orderInfo
                .getJmcOrderNo(), 0, null));
    }
}
