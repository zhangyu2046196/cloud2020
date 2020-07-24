package com.youyuan.springcloud.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 类名称：BaseOrderDto <br>
 * 类描述： 订单预订dto基类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/2 20:00<br>
 */
@Data
public class BaseOrderDto implements Serializable {
    private static final long serialVersionUID = -6979952397359215359L;

    /**
     * 酒店编码
     */
    private String hotelCode;
    /**
     * 渠道id
     */
    private Integer channelId;
    /**
     * pms订单编号
     */
    private String orderPmsNo;
    /**
     * 产品编码
     */
    private String goodsCode;
    /**
     * 预订人手机号
     */
    private String bookerTelephone;
    /**
     * 区分是别样红PMS,还是别的PMS
     */
    private String pmsCode;
    /**
     * 入住房间数
     */
    private Integer roomCount;
    /**
     * 住店时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date arrivelHotelTime;
    /**
     * 离店时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date departureHotelTime;
    /**
     * 预计到店时间
     */
    private String exceptArriveHotelTime;
    /**
     * 应付金额
     */
    private BigDecimal receivableAmount;
    /**
     * 订单金额（实付金额）
     */
    private BigDecimal orderAmount;
    /**
     * 预订人类型
     */
    private String bookerType;
    /**
     * 会员编号
     */
    private String memberNo;
    /**
     * 渠道订单号
     */
    private String jmcOrderNo;
    /**
     * 客户备注
     */
    private String userRemark;
    /**
     * 凌晨房间，1是2否
     */
    private Integer morningOrder;

    /**
     * 库存需要
     * 每日房价
     */
    private List<OrderDayPriceDto> orderDayPriceDtos;

    /**
     *库存需要
     * 客源结构
     */
    private String guestStructure;

}
