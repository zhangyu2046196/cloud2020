package com.youyuan.listener;

/**
 * 方法名: EventInfo <br>
 * 方法描述: 事件接口 <br>
 *
 * @author zhangyu
 * @date 创建时间: 2020/11/3 16:43 <br>
 */
public interface EventInfo {

    /**
     * 方法名: getEventType <br>
     * 方法描述: 获取事件类型 <br>
     *
     * @return {@link String 返回事件类型 }
     * @date 创建时间: 2020/11/3 16:44 <br>
     * @author zhangyu
     */
    String getEventType();

    /**
     * 方法名: getEventSource <br>
     * 方法描述: 查询事件源 <br>
     *
     * @return {@link Object 返回事件源 }
     * @date 创建时间: 2020/11/3 16:44 <br>
     * @author zhangyu
     */
    Object getEventSource();
}
