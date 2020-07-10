package com.youyuan.event;

import com.youyuan.domain.Person;
import lombok.Data;

/**
 * 类名称：PersonEvent <br>
 * 类描述： 人员事件 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/1 10:33<br>
 */
@Data
public class PersonEvent extends BaseEvent<Person> {
    public PersonEvent(Object source, Person eventData) {
        super(source, eventData);
    }

    public PersonEvent(Person eventData) {
        super(eventData);
    }
}
