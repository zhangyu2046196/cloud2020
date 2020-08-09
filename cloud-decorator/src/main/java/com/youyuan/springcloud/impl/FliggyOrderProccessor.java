package com.youyuan.springcloud.impl;

import com.alibaba.fastjson.JSON;
import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderInfo;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类名称：FliggyOrderProccessor <br>
 * 类描述： 飞猪订单预订流程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/6 19:53<br>
 */
@Service
@Slf4j
public class FliggyOrderProccessor extends DecoratorOrderProccessor {

    private final OrderProccessor channelOrderProccessor;
    private final OrderValidateService orderValidateService;

    public FliggyOrderProccessor(OrderProccessor channelOrderProccessor, OrderValidateService orderValidateService) {
        super(channelOrderProccessor);
        this.channelOrderProccessor = channelOrderProccessor;
        this.orderValidateService = orderValidateService;
    }


    @Override
    public ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto) {
        log.info("飞猪");
        isConfirm();
        ResultDto<OrderResponseDto> orderResponseDtoResultDto = super.validateParam(orderDto);
        //执行验证渠道逻辑
        if (orderValidateService.validateResult(orderResponseDtoResultDto)) {
            //初始化订单实体
            OrderInfo orderInfo = new OrderInfo();
            orderResponseDtoResultDto = verifyChannel(orderDto, orderInfo);
        }
        log.info("飞猪预订请求参数={},返回结果={}", JSON.toJSONString(orderDto), JSON
                .toJSONString(orderResponseDtoResultDto));
        return orderResponseDtoResultDto;
    }

    @Override
    public ResultDto<OrderResponseDto> verifyChannel(BaseOrderDto orderDto, OrderInfo orderInfo) {
        ResultDto<OrderResponseDto> orderResponseDtoResultDto = super.verifyChannel(orderDto, orderInfo);
        //执行扣减库存逻辑
        if (orderValidateService.validateResult(orderResponseDtoResultDto)) {
            orderResponseDtoResultDto = deductionStorage(orderDto, orderInfo);
        }
        return orderResponseDtoResultDto;
    }

    @Override
    public ResultDto<OrderResponseDto> deductionStorage(BaseOrderDto orderDto, OrderInfo orderInfo) {
        ResultDto<OrderResponseDto> orderResponseDtoResultDto = super.deductionStorage(orderDto, orderInfo);
        //执行保存订单/房单逻辑
        if (orderValidateService.validateResult(orderResponseDtoResultDto)) {
            orderResponseDtoResultDto = createOrderRoom(orderDto, orderInfo);
        }
        return orderResponseDtoResultDto;
    }
}
