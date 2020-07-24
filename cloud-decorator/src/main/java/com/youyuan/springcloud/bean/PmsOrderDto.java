package com.youyuan.springcloud.bean;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 类名称：PmsOrderDto <br>
 * 类描述： pms侧预订dto<br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/2 21:25<br>
 */
@Data
public class PmsOrderDto extends BaseOrderDto implements Serializable {
    private static final long serialVersionUID = 1779189735351501440L;

    /**
     * 订单类型
     */
    private Integer orderType;
    /**
     * 团队类型
     */
    private String teamType;
    /**
     * 团队名称
     */
    private String teamName;
    /**
     * 合同编号
     */
    private String contractNo;
    /**
     * 订单标签
     */
    private int orderTag;
    /**
     * 押金
     */
    private BigDecimal depositAmount;
    /**
     * 班次
     */
    private String classes;
    /**
     * 押金付款方式编码
     */
    private String depositModeCode;
    /**
     * pms入住房间类型id
     */
    private String pmsRoomTypeId;
    /**
     * 协议单位id
     */
    private String protocolCompany;
}
