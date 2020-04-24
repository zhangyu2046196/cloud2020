package com.youyuan.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.youyuan.springcloud.service.IMessageProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @author zhangy
 * @version 1.0
 * @description 发送消息实现类
 * @EnableBinding 把channel和exchange绑定到一起
 * @date 2020/4/17 8:02
 */
@EnableBinding(Source.class)
@Slf4j
public class MessageProviderImpl implements IMessageProvider {

    @Autowired
    private MessageChannel output;

    @Override
    public String send() {
        String UUID = IdUtil.simpleUUID();//发送的消息内容
        output.send(MessageBuilder.withPayload(UUID).build());//发送消息
        log.info("发送消息是={}", UUID);
        return null;
    }
}
