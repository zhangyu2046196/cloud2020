package com.youyuan.springcloud.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderInfo {
    private Long id;

    private String orderNo;

    private String orderRoomNo;

    private String orderPmsNo;

    private String hotelCode;

    private String memberNo;

    private String memberCardNo;

    private Integer memberCardType;

    private String memberCardLevel;

    private Integer orderStatus;

    private Integer payStatus;

    private Integer refundStatus;

    private Integer ratePlanId;

    private BigDecimal originalAmount;

    private BigDecimal receivableAmount;

    private BigDecimal orderAmount;

    private BigDecimal memberDiscountAmount;

    private Integer payChannel;

    private Date payTime;

    private String userRemark;

    private Integer channelId;

    private Integer hotelChannelId;

    private String hotelChannelName;

    private Date cancelTime;

    private String cancelStatusCode;

    private String cancelStatucDesc;

    private Date arrivelHotelTime;

    private Date departureHotelTime;

    private String exceptArriveHotelTime;

    private String roomTypeId;

    private String roomTypeName;

    private Integer roomCount;

    private Integer roomNightCount;

    private String bookerName;

    private String bookerTelephone;

    private String recommendHotelCode;

    private String pmsCode;

    private Integer orderInfoHotelKeeperStatus;

    private Integer orderInfoConsumerStatus;

    private String guestStructure;

    private String bookerType;

    private String memberName;

    private String goodsId;

    private Date createdTime;

    private Integer priceMode;

    private BigDecimal commission;

    private BigDecimal commissionAmount;

    private BigDecimal crsCommission;

    private BigDecimal crsCommissionAmount;

    private BigDecimal settlementPrice;

    private BigDecimal crsSettlementPrice;

    private String jmcOrderNo;

    private String jmcChannelName;

    private Integer morningOrder;

    private String billMark;

    private Integer discountPkgId;

    private String discountPkgName;

    private Integer orderAdvanceStayStatus;

    private Date orderStatusOverTime;

    private Integer orderTag;

    private Boolean containsPromotion;

    private Long promotionId;

    private String promotionName;

    private Integer goodsTypeId;

    private Boolean overSaleTag;

    private Date updateTime;

    private Byte alitripPayStatus;

    private Byte alitripPayType;

    private BigDecimal roomFee;

    private BigDecimal fees;

    private BigDecimal oldReceivableAmount;
}