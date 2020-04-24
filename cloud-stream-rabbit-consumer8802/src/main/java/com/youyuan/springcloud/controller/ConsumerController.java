package com.youyuan.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author zhangy
 * @version 1.0
 * @description 基于springcloud stream消息驱动的消费者
 * @date 2020/4/17 14:37
 */
@Component
@Slf4j
@EnableBinding(Sink.class)
public class ConsumerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        log.info("消费者1,消费到的消息是:" + message.getPayload() + " 端口号:" + serverPort);
    }
}
