package com.youyuan.dao;

import com.youyuan.domain.Person;
import com.youyuan.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhangy
 * @version 1.0
 * @description 订单接口类
 * @date 2020/3/29 11:58
 */
@Mapper
public interface PersonDao {

    /**
     * 方法名:   <br>
     * 方法描述: TODO <br>
     *
     * @return {@link }
     * @date 创建时间: 2020/7/1 11:50 <br>
     * @author zhangyu
     */
    public int create(Person person);

}
