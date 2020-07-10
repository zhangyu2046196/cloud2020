package com.youyuan.listener;

import com.youyuan.domain.Person;
import com.youyuan.domain.User;
import com.youyuan.event.PersonEvent;
import com.youyuan.event.UserEvent;
import com.youyuan.service.PersonService;
import com.youyuan.service.UserService;
import com.youyuan.utils.EventPublisherUtil;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 类名称：ListenerEvent <br>
 * 类描述： 监听事件 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/1 9:58<br>
 */
@Component
public class ListenerEvent {

    private final EventPublisherUtil eventPublisherUtil;
    private final UserService userService;
    private final PersonService personService;

    public ListenerEvent(EventPublisherUtil eventPublisherUtil, UserService userService, PersonService personService) {
        this.eventPublisherUtil = eventPublisherUtil;
        this.userService = userService;
        this.personService = personService;
    }

    @EventListener
    public void listener1(UserEvent event) {
        User user = event.getEventData();
        userService.create(user);
        System.out.println(System.currentTimeMillis() + "—1111111 线程名:" + Thread.currentThread().getName() + " 监听到UserEvent事件:" + user);
    }

    @EventListener
    public void listener2(PersonEvent event) {
        Person person = event.getEventData();
        personService.create(person);
        System.out.println(System.currentTimeMillis() + "—2222222 线程名:" + Thread.currentThread().getName() + " 监听到UserEvent事件:" + person);
    }
}
