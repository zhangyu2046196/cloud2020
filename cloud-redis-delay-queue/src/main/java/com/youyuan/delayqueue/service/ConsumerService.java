package com.youyuan.delayqueue.service;


/**
 * 类名称：ConsumerService <br>
 * 类描述： 消费者类，对ReadyQueue中的消息进行消费 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:37<br>
 */
public interface ConsumerService {

    /**
     * 方法名: consumerMessage <br>
     * 方法描述: 消费ReadyQueue的消息 <br>
     *
     * @param body 消息内容信息
     * @return {@link Boolean true消费消息成功 false消费消息失败}
     * @date 创建时间: 2020/11/11 18:38 <br>
     * @author zhangyu
     */
    Boolean consumerMessage(String body);
}
