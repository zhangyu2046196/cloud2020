package com.youyuan.controller;

import com.alibaba.fastjson.JSON;
import com.youyuan.domain.User;
import com.youyuan.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 类名称：UserController <br>
 * 类描述： 用户控制类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/7/31 15:15<br>
 */
@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 方法名: save <br>
     * 方法描述: 保存用户信息 <br>
     *
     * @param user 用户请求参数
     * @return {@link Boolean true成功 false失败}
     * @date 创建时间: 2021/7/31 15:17 <br>
     * @author zhangyu
     */
    @PostMapping("/save")
    public Boolean save(@RequestBody User user) {
        log.info("保存用户信息请求参数={}", JSON.toJSONString(user));
        return userService.save(user);
    }

    /**
     * 方法名: findById <br>
     * 方法描述: 根据主键查询 <br>
     *
     * @param id 主键参数信息
     * @return {@link User 返回查询结果 }
     * @date 创建时间: 2021/7/31 15:19 <br>
     * @author zhangyu
     */
    @GetMapping("/findById")
    public User findById(@RequestParam("id") Long id) {
        log.info("查询用户信息请求参数={}", id);
        return userService.findById(id);
    }
}
