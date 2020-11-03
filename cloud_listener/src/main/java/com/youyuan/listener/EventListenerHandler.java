package com.youyuan.listener;

import com.youyuan.listener.EventInfo;

import java.util.EventListener;

/**
 * 类名称：EventListenerHandler <br>
 * 类描述： 事件监听器接口 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/3 16:48<br>
 */
public interface EventListenerHandler extends EventListener {

    /**
     * 方法名: handler <br>
     * 方法描述: 处理器 <br>
     *
     * @return {@link }
     * @date 创建时间: 2020/11/3 16:49 <br>
     * @author zhangyu
     */
    void handler(EventInfo eventInfo);
}
