package com.youyuan.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.youyuan.springcloud.OrderPlusService;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.ChannelOrderDto;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/7/23 11:06
 */
@RestController
@Slf4j
public class OrderController {

    private final OrderPlusService orderPlusService;

    public OrderController(OrderPlusService orderPlusService) {
        this.orderPlusService = orderPlusService;
    }

    @GetMapping("/order/engine")
    public void orderEngine(){
        BaseOrderDto orderDto=new ChannelOrderDto();
        orderDto.setChannelId(11);
        orderDto.setHotelCode("12356789");
        orderDto.setGoodsCode("10088787");
        orderDto.setJmcOrderNo("198888888888888888");
        ResultDto<OrderResponseDto> orderResponseDtoResultDto = orderPlusService.orderSubmit(orderDto);
        log.info("飞猪预订结果:"+ JSON.toJSONString(orderResponseDtoResultDto));
    }

}
