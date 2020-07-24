package com.youyuan.springcloud.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 类名称：ChannelOrderDto <br>
 * 类描述： 渠道预订数据dto <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/3 15:18<br>
 */
@Data
public class ChannelOrderDto extends BaseOrderDto implements Serializable {
    private static final long serialVersionUID = -6148396008669772579L;

    /**
     * 入住房间类型id
     */
    private String roomTypeId;
    /**
     * 早餐数量
     */
    private Integer breakfastNum;
}
