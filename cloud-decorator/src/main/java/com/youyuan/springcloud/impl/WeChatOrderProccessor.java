package com.youyuan.springcloud.impl;

import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderInfo;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import org.springframework.stereotype.Service;

/**
 * 类名称：WeChatOrderProccessor <br>
 * 类描述： 小程序预订流程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/6 19:55<br>
 */
@Service
public class WeChatOrderProccessor extends DecoratorOrderProccessor {

    private final OrderProccessor channelOrderProccessor;

    public WeChatOrderProccessor(OrderProccessor channelOrderProccessor) {
        super(channelOrderProccessor);
        this.channelOrderProccessor = channelOrderProccessor;
    }

    @Override
    public ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto) {
        super.validateParam(orderDto);
        //TODO 1.手机号校验
        //TODO 2.超级会员优惠券校验
        //TODO 3.订单金额校验
        System.out.println("手机号校验");
        System.out.println("超级会员优惠券校验");

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

        return null;
    }
}
