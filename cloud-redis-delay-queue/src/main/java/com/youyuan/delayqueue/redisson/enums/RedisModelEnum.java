package com.youyuan.delayqueue.redisson.enums;

/**
 * 类名称：RedisModelEnum <br>
 * 类描述： redisson模式枚举 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:19<br>
 */
public enum RedisModelEnum {
    //哨兵
    SENTINEL,
    //主从
    MASTERSLAVE,
    //单例
    SINGLE,
    //集群
    CLUSTER,
    //云托管模式
    REPLICATED
}
