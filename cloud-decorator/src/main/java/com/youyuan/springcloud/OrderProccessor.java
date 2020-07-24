package com.youyuan.springcloud;

import com.youyuan.springcloud.bean.BaseOrderDto;
import com.youyuan.springcloud.bean.OrderInfo;
import com.youyuan.springcloud.bean.OrderResponseDto;
import com.youyuan.springcloud.bean.ResultDto;

/**
 * 类名称：OrderProccessor <br>
 * 类描述： 预订流程接口 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/6 17:10<br>
 */
public interface OrderProccessor {

    /**
     * 方法名:  validateParam <br>
     * 方法描述: 基础参数校验 <br>
     *
     * @param orderDto 请求参数dto
     * @return {@link ResultDto<OrderResponseDto> 返回结果}
     * @date 创建时间: 2020/7/14 10:43 <br>
     * @author zhangyu
     */
    ResultDto<OrderResponseDto> validateParam(BaseOrderDto orderDto);

    /**
     * 方法名: verifyChannel  <br>
     * 方法描述: 验证渠道 <br>
     *
     * @param orderDto  请求参数dto
     * @param orderInfo 订单po
     * @return {@link ResultDto<OrderResponseDto> 返回结果}
     * @date 创建时间: 2020/7/6 17:14 <br>
     * @author zhangyu
     */
    ResultDto<OrderResponseDto> verifyChannel(BaseOrderDto orderDto, OrderInfo orderInfo);

    /**
     * 方法名:  deductionStorage <br>
     * 方法描述: 扣减库存 <br>
     *
     * @param orderDto  请求参数dto
     * @param orderInfo 订单po
     * @return {@link ResultDto<OrderResponseDto> 返回结果 }
     * @date 创建时间: 2020/7/6 17:16 <br>
     * @author zhangyu
     */
    ResultDto<OrderResponseDto> deductionStorage(BaseOrderDto orderDto, OrderInfo orderInfo);

    /**
     * 方法名: createOrderRoom  <br>
     * 方法描述: 保存订单/房单 <br>
     *
     * @param orderDto  请求参数dto
     * @param orderInfo 订单po
     * @return {@link ResultDto<OrderResponseDto> 返回结果 }
     * @date 创建时间: 2020/7/6 17:22 <br>
     * @author zhangyu
     */
    ResultDto<OrderResponseDto> createOrderRoom(BaseOrderDto orderDto, OrderInfo orderInfo);
}
