package com.youyuan.service;

import com.youyuan.domain.User;
import com.youyuan.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 类名称：UserServiceImpl <br>
 * 类描述： 用户接口实现类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/7/31 15:13<br>
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public Boolean save(User user) {
        return userMapper.save(user) > 0;
    }

    @Override
    public User findById(Long id) {
        return userMapper.findById(id);
    }
}
