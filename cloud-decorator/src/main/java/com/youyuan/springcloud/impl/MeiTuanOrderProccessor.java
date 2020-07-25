package com.youyuan.springcloud.impl;

import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderInfo;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类名称：MeiTuanOrderProccessor <br>
 * 类描述： 美团预订流程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/6 17:43<br>
 */
@Service
@Slf4j
public class MeiTuanOrderProccessor extends DecoratorOrderProccessor {

    private final OrderProccessor channelOrderProccessor;

    public MeiTuanOrderProccessor(OrderProccessor channelOrderProccessor) {
        super(channelOrderProccessor);
        this.channelOrderProccessor = channelOrderProccessor;
    }

    @Override
    public ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto) {
        log.info("美团");
        super.validateParam(orderDto);

        return null;
    }

    @Override
    public ResultDto<OrderResponseDto> verifyChannel(BaseOrderDto orderDto, OrderInfo orderInfo) {
        super.verifyChannel(orderDto, orderInfo);
        return null;
    }

    @Override
    public ResultDto<OrderResponseDto> deductionStorage(BaseOrderDto orderDto, OrderInfo orderInfo) {
        super.deductionStorage(orderDto,orderInfo);

        return null;
    }

    @Override
    public ResultDto<OrderResponseDto> createOrderRoom(BaseOrderDto orderDto,OrderInfo orderInfo) {
        super.createOrderRoom(orderDto,orderInfo);

        return null;
    }

}
