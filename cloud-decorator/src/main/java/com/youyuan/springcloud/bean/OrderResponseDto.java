package com.youyuan.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 类名称：OrderResponseDto <br>
 * 类描述： 预订返回值 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/14 14:11<br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto implements Serializable {
    private static final long serialVersionUID = -7962888162660216226L;

    /**
     * 轻住订单编号
     */
    private String orderNo;
    /**
     * 渠道订单编号
     */
    private String jmcOrderNo;
    /**
     * 订单状态
     */
    private Integer orderStatus;
    /**
     * 预订返回库存附加数据
     */
    private List<InventoryPriceDto> inventoryPriceDtos;

}
