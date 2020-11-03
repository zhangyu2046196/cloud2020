package com.youyuan.test;

import com.youyuan.listener.EventListenerHandler;
import com.youyuan.listener.impl.AddEventListenerHandler;
import com.youyuan.source.EventSource;

/**
 * 类名称：Client <br>
 * 类描述： 客户端测试 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/3 17:16<br>
 */
public class Client {

    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        EventListenerHandler addEventListenerHandler = new AddEventListenerHandler();
        eventSource.registryEventListenerHandler(addEventListenerHandler);
        //eventSource.removeEventListenerHandler(addEventListenerHandler);
        eventSource.addCar();
        eventSource.addCar();
    }
}
