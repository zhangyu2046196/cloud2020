package com.youyuan.service;

import com.youyuan.dao.PersonDao;
import com.youyuan.domain.Person;
import org.springframework.stereotype.Service;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/7/2 11:11
 */
@Service
public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void create(Person person) {
        personDao.create(person);
//        int ab = 10 / 0;
    }
}
