package com.youyuan.event;

import com.youyuan.domain.User;

/**
 * 类名称：UserEvent <br>
 * 类描述： 用户事件 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/6/30 21:10<br>
 */
public class UserEvent extends BaseEvent<User> {
    public UserEvent(Object source, User eventData) {
        super(source, eventData);
    }

    public UserEvent(User eventData) {
        super(eventData);
    }
}
