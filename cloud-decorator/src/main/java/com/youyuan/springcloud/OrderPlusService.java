package com.youyuan.springcloud;


import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;

/**
 * 类名称：OrderPlusService <br>
 * 类描述： 订单预订业务接口 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/7 14:25<br>
 */
public interface OrderPlusService {

    /**
     * 方法名: orderSubmit  <br>
     * 方法描述: 订单预订 <br>
     *
     * @param orderDto 预订请求参数dto
     * @return {@link ResultDto<OrderResponseDto> 返回结果}
     * @date 创建时间: 2020/7/7 14:26 <br>
     * @author zhangyu
     */
    public ResultDto<OrderResponseDto> orderSubmit(BaseOrderDto orderDto);
}
