package com.youyuan.springcloud.impl;

import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类名称：ChannelOrderProccessor <br>
 * 类描述： 渠道侧公共特有预订流程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/7 11:02<br>
 */
@Service
@Slf4j
public class ChannelOrderProccessor extends DecoratorOrderProccessor {

    private final OrderProccessor baseOrderProccessor;

    public ChannelOrderProccessor(OrderProccessor baseOrderProccessor) {
        super(baseOrderProccessor);
        this.baseOrderProccessor = baseOrderProccessor;
    }

    @Override
    public ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto) {
        log.info("数据校验—渠道");
        return super.validateParam(orderDto);
    }

    @Override
    public ResultDto<OrderResponseDto> verifyChannel(BaseOrderDto orderDto, OrderInfo orderInfo) {
        log.info("渠道校验—渠道");
        ResultDto<OrderResponseDto> orderResponseDtoResultDto = super.verifyChannel(orderDto, orderInfo);
        return orderResponseDtoResultDto;
    }

    @Override
    public ResultDto<OrderResponseDto> deductionStorage(BaseOrderDto orderDto, OrderInfo orderInfo) {
        log.info("扣减库存—渠道");
        super.deductionStorage(orderDto, orderInfo);
        orderInfo.setOrderNo("090909090900878787");
        log.info("扣减库存渠道orderInfo:"+orderInfo);
        return ResultDto.success();
    }

    @Override
    public ResultDto<OrderResponseDto> createOrderRoom(BaseOrderDto orderDto, OrderInfo orderInfo) {
        log.info("生成订单—渠道");
        super.createOrderRoom(orderDto, orderInfo);
        return new ResultDto<OrderResponseDto>("200", "成功", new OrderResponseDto(orderInfo.getOrderNo(), orderInfo
                .getJmcOrderNo(), 2, null));
    }

}
