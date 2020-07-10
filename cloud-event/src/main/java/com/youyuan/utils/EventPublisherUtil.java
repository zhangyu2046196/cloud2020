package com.youyuan.utils;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

/**
 * 类名称：EventPublisherUtil <br>
 * 类描述： 事件发布工具类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/6/30 21:12<br>
 */
@Component
public class EventPublisherUtil implements ApplicationEventPublisherAware{
    private static ApplicationEventPublisher eventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        if(eventPublisher == null){
            eventPublisher = applicationEventPublisher;
        }
    }

    /**
    * 方法名:  publishEvent <br>
    * 方法描述: 发布事件 <br>
    * 
    * @return {@link }
    * @date 创建时间: 2020/6/30 21:12 <br>
    * @author zhangyu
    */
    public void publishEvent(ApplicationEvent event){
        eventPublisher.publishEvent(event);
    }
}
