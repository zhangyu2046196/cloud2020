package com.youyuan.springcloud.impl;

import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderInfo;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import org.springframework.stereotype.Service;

/**
 * 类名称：PmsOrderProccessor <br>
 * 类描述： pms侧预订流程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/6 19:54<br>
 */
@Service
public class PmsOrderProccessor extends DecoratorOrderProccessor {

    private final OrderProccessor baseOrderProccessor;

    public PmsOrderProccessor(OrderProccessor baseOrderProccessor) {
        super(baseOrderProccessor);
        this.baseOrderProccessor = baseOrderProccessor;
    }

    @Override
    public ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto) {
        super.validateParam(orderDto);
        //TODO 1.房费校验
        //TODO 2.协议单位校验
        //TODO 3.价格日历校验
        //TODO 4.手机号校验
        //TODO 5.订单金额校验
        System.out.println("房费校验");
        System.out.println("协议单位校验");
        System.out.println("价格日历校验");
        System.out.println("手机号校验");
        return null;
    }

    @Override
    public ResultDto<OrderResponseDto> verifyChannel(BaseOrderDto orderDto, OrderInfo orderInfo) {
        super.verifyChannel(orderDto, orderInfo);
        return null;
    }

    @Override
    public ResultDto<OrderResponseDto> deductionStorage(BaseOrderDto orderDto, OrderInfo orderInfo) {
        super.deductionStorage(orderDto, orderInfo);

        return null;
    }

    @Override
    public ResultDto<OrderResponseDto> createOrderRoom(BaseOrderDto orderDto, OrderInfo orderInfo) {
        super.createOrderRoom(orderDto, orderInfo);
        //TODO 保存入住人(散客步入)

        System.out.println("保存入住人(散客步入)");
        return null;
    }
}
