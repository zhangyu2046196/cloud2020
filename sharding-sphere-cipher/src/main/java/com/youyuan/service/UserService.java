package com.youyuan.service;

import com.youyuan.domain.User;

/**
 * 类名称：UserService <br>
 * 类描述： 用户信息接口 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/7/31 15:11<br>
 */
public interface UserService {

    /**
     * 方法名: save <br>
     * 方法描述: 保存用户信息 <br>
     *
     * @param user 用户
     * @return {@link Boolean true成功 false失败}
     * @date 创建时间: 2021/7/31 15:11 <br>
     * @author zhangyu
     */
    Boolean save(User user);

    /**
     * 方法名: findById <br>
     * 方法描述: 根据主键查询用户 <br>
     *
     * @param id 主键
     * @return {@link User 查询用户结果 }
     * @date 创建时间: 2021/7/31 15:12 <br>
     * @author zhangyu
     */
    User findById(Long id);

}
