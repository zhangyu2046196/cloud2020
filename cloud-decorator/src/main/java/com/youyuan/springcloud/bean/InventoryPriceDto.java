package com.youyuan.springcloud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 类名称：InventoryPriceDto <br>
 * 类描述： 库存信息预订返回集合数据 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/14 11:28<br>
 */
@Data
public class InventoryPriceDto implements Serializable {
    private static final long serialVersionUID = -6213648661262134124L;

    /**
     * 产品Code
     */
    private String goodsCode;

    /**
     * 销售日，格式:yyyy-MM-dd
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private String sellDate;

    /**
     * 剩余库存量
     */
    private Integer skuNum;

    /**
     * 价格
     */
    private BigDecimal price;
}
