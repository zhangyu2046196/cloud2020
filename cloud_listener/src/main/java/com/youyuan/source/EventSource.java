package com.youyuan.source;

import com.youyuan.listener.EventInfo;
import com.youyuan.listener.EventListenerHandler;
import com.youyuan.listener.impl.AddEvent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 类名称：EventSource <br>
 * 类描述： 事件源 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/3 16:55<br>
 */
public class EventSource {

    private Collection<EventListenerHandler> eventListenerHandlers = null;
    private int count = 0;

    public int getCount() {
        return count;
    }

    /**
     * 方法名: registryEventListenerHandler <br>
     * 方法描述: 往事件源上注册监听器 <br>
     *
     * @param eventListenerHandler 监听器处理器
     * @date 创建时间: 2020/11/3 16:56 <br>
     * @author zhangyu
     */
    public void registryEventListenerHandler(EventListenerHandler eventListenerHandler) {
        if (eventListenerHandlers == null) {
            eventListenerHandlers = new HashSet<EventListenerHandler>();
            eventListenerHandlers.add(eventListenerHandler);
        }
    }

    /**
     * 方法名: removeEventListenerHandler <br>
     * 方法描述: 从事件源中删除监听器 <br>
     *
     * @date 创建时间: 2020/11/3 16:56 <br>
     * @author zhangyu
     */
    public void removeEventListenerHandler(EventListenerHandler eventListenerHandler) {
        if (eventListenerHandlers != null) {
            eventListenerHandlers.remove(eventListenerHandler);
        }
    }

    /**
     * 方法名: addCar <br>
     * 方法描述: 添加购物车 <br>
     * <p>
     * 测试场景模拟购物车操作场景
     *
     * @date 创建时间: 2020/11/3 16:57 <br>
     * @author zhangyu
     */
    public void addCar() {
        ++count;
        if (eventListenerHandlers != null) {
            EventInfo eventInfo = new AddEvent(this);
            notifies(eventInfo);
        }
        System.out.println("向购物车添加商品成功...");
    }

    /**
     * 方法名: notifies <br>
     * 方法描述: 通知事件监听器处理事件 <br>
     *
     * @param eventInfo 事件
     * @date 创建时间: 2020/11/3 16:58 <br>
     * @author zhangyu
     */
    private void notifies(EventInfo eventInfo) {
        Iterator iterator = eventListenerHandlers.iterator();
        while (iterator.hasNext()) {
            ((EventListenerHandler) iterator.next()).handler(eventInfo);
        }
    }

}
