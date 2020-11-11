package com.youyuan.delayqueue.service.impl;

import com.youyuan.delayqueue.service.ConsumerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类名称：ConsumerServiceImpl <br>
 * 类描述： 消费者类，对ReadyQueue中的消息进行消费 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:42<br>
 */
@Slf4j
@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public Boolean consumerMessage(String body) {
        try {
            log.info("消费者消费的内容={}", body);
            return Boolean.TRUE;
        } catch (Exception e) {
            log.error("consumerMessage error", e);
        }
        return Boolean.FALSE;
    }

}
