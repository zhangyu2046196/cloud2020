package com.youyuan.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

/**
 * 类名称：BaseEvent <br>
 * 类描述： 事件基类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/6/30 21:03<br>
 */
@Data
public abstract class BaseEvent<T extends Serializable> extends ApplicationEvent {
    private static final long serialVersionUID = -6692847200664278768L;

    protected T eventData;

    public BaseEvent(Object source, T eventData) {
        super(source);
        this.eventData = eventData;
    }

    public BaseEvent(T eventData) {
        super(eventData);
    }
}
