package com.youyuan.service;

import com.youyuan.dao.UserDao;
import com.youyuan.domain.Person;
import com.youyuan.domain.User;
import com.youyuan.event.PersonEvent;
import com.youyuan.utils.EventPublisherUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/7/2 10:55
 */
@Service
public class UserService {

    private final UserDao userDao;
    private final EventPublisherUtil eventPublisherUtil;

    public UserService(UserDao userDao, EventPublisherUtil eventPublisherUtil) {
        this.userDao = userDao;
        this.eventPublisherUtil = eventPublisherUtil;
    }

    @Async("eventExecutor")
    public void create(User user) {
        userDao.create(user);
        Person person = new Person(2L, "上海");
        eventPublisherUtil.publishEvent(new PersonEvent(this, person));
        System.out.println(System.currentTimeMillis() + "—发布PersonEvent事件内容：" + person);
    }
}
