package com.youyuan.listener.impl;

import com.youyuan.listener.EventInfo;

import java.util.EventObject;

/**
 * 类名称：AddEvent <br>
 * 类描述： 事件接口实现类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/3 16:53<br>
 */
public class AddEvent extends EventObject implements EventInfo {

    private final String eventType="add";
    public AddEvent(Object source){
        super(source);
    }
    @Override
    public String getEventType() {
        return eventType;
    }

    @Override
    public Object getEventSource() {
        return getSource();
    }
}
