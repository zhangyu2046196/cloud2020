package com.youyuan.springcloud.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderDayPriceDto {

    private String roomDay;//房间日期,格式：2020-01-03

    private BigDecimal roomPrice;//房间价格

    private BigDecimal previousRoomPrice;//房型升级前的房间价格

}
