package com.youyuan.springcloud.impl;

import com.youyuan.springcloud.OrderPlusService;
import com.youyuan.springcloud.OrderProccessor;
import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类名称：OrderServiceImpl <br>
 * 类描述： 订单预订接口实现类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/7 14:27<br>
 */
@Service
@Slf4j
public class OrderPlusServiceImpl implements OrderPlusService {

    private final OrderProccessor pmsOrderProccessor;
    private final OrderProccessor meiTuanOrderProccessor;
    private final OrderProccessor fliggyOrderProccessor;
    private final OrderProccessor weChatOrderProccessor;

    public OrderPlusServiceImpl(OrderProccessor pmsOrderProccessor, OrderProccessor meiTuanOrderProccessor,
                                OrderProccessor fliggyOrderProccessor, OrderProccessor weChatOrderProccessor) {
        this.pmsOrderProccessor = pmsOrderProccessor;
        this.meiTuanOrderProccessor = meiTuanOrderProccessor;
        this.fliggyOrderProccessor = fliggyOrderProccessor;
        this.weChatOrderProccessor = weChatOrderProccessor;
    }


    @Override
    public ResultDto<OrderResponseDto> orderSubmit(BaseOrderDto orderDto) {
        return orderTransmit(orderDto);
    }

    /**
     * 方法名:  orderTransmit <br>
     * 方法描述: 预订转发 <br>
     *
     * @param orderDto 预订入参数
     * @return {@link ResultDto<OrderResponseDto> 返回预订结果}
     * @date 创建时间: 2020/7/7 14:44 <br>
     * @author zhangyu
     */
    private ResultDto<OrderResponseDto> orderTransmit(BaseOrderDto orderDto) {
        switch (orderDto.getChannelId()) {
            case 1:
                return weChatOrderProccessor.validateParam(orderDto);
            case 3:
                return pmsOrderProccessor.validateParam(orderDto);
            case 8:
                return meiTuanOrderProccessor.validateParam(orderDto);
            case 11:
                return fliggyOrderProccessor.validateParam(orderDto);
            default:
                return null;
        }
    }
}
