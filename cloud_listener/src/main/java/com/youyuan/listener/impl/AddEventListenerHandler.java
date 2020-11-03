package com.youyuan.listener.impl;

import com.youyuan.listener.EventInfo;
import com.youyuan.listener.EventListenerHandler;
import com.youyuan.source.EventSource;

/**
 * 类名称：AddEventListenerHandler <br>
 * 类描述： 事件监听器实现类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/3 16:50<br>
 */
public class AddEventListenerHandler implements EventListenerHandler {
    @Override
    public void handler(EventInfo eventInfo) {
        if(eventInfo==null){
            return;
        }
        if(eventInfo.getEventType().equals("add")){
            System.out.println("添加购物车事件。。。");
        }

        EventSource eventSource=(EventSource)eventInfo.getEventSource();
        int productCount=eventSource.getCount();
        System.out.println("购物车中现在有商品：" + productCount + "件");
    }
}
