package com.youyuan.springcloud.impl;

import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderInfo;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名称：DecoratorOrderProccessor <br>
 * 类描述： 订单预订装饰者处理器 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/6 17:40<br>
 */
public class DecoratorOrderProccessor implements OrderProccessor {

    private OrderProccessor orderProccessor;

    @Autowired
    private ConfirmServiceImpl confirmServiceImpl;

    public DecoratorOrderProccessor(OrderProccessor orderProccessor) {
        this.orderProccessor = orderProccessor;
    }


    @Override
    public ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto) {
        return orderProccessor.validateParam(orderDto);
    }

    @Override
    public ResultDto<OrderResponseDto> verifyChannel(BaseOrderDto orderDto, OrderInfo orderInfo) {
        return orderProccessor.verifyChannel(orderDto, orderInfo);
    }

    @Override
    public ResultDto<OrderResponseDto> deductionStorage(BaseOrderDto orderDto, OrderInfo orderInfo) {
        return orderProccessor.deductionStorage(orderDto, orderInfo);
    }

    @Override
    public ResultDto<OrderResponseDto> createOrderRoom(BaseOrderDto orderDto, OrderInfo orderInfo) {
        return orderProccessor.createOrderRoom(orderDto, orderInfo);
    }

    public Boolean isConfirm() {
        confirmServiceImpl.teConfirm();
        return Boolean.TRUE;
    }
}
