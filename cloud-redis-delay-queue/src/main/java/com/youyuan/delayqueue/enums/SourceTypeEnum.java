package com.youyuan.delayqueue.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 类名称：消息来源枚举 <br>
 * 类描述： SourceTypeEnum <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 17:41<br>
 */
@Getter
@AllArgsConstructor
public enum SourceTypeEnum {

    SELF_SERVICE_ORDER(1,"自助机订单");

    /**
     * 消息来源类型
     */
    private Integer type;
    /**
     * 消息来源描述
     */
    private String msg;
}
