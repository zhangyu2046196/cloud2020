package com.youyuan.service;

import com.youyuan.domain.Person;
import com.youyuan.domain.User;
import com.youyuan.event.PersonEvent;
import com.youyuan.event.UserEvent;
import com.youyuan.utils.EventPublisherUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * 类名称：HandlerService <br>
 * 类描述： 处理业务逻辑 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/1 10:04<br>
 */
@Service
public class HandlerService {

    @Autowired

    private final EventPublisherUtil eventPublisherUtil;

    public HandlerService(EventPublisherUtil eventPublisherUtil) {
        this.eventPublisherUtil = eventPublisherUtil;
    }

    @Transactional(rollbackFor = Exception.class)
    public void handler() {
        User user = new User(1L, "北京", 26, new Date());
        eventPublisherUtil.publishEvent(new UserEvent(this, user));
        System.out.println(System.currentTimeMillis() + "—发布UserEvent事件内容：" + user);
    }
}
