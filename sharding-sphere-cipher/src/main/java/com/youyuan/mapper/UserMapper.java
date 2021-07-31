package com.youyuan.mapper;

import com.youyuan.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 类名称：UserMapper <br>
 * 类描述： 用户mapper接口 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/7/31 15:07<br>
 */
@Mapper
public interface UserMapper {

    /**
     * 方法名: save <br>
     * 方法描述: 保存用户信息 <br>
     *
     * @param user 请求参数信息
     * @return {@link int>0 返回成功信息 }
     * @date 创建时间: 2021/7/31 15:08 <br>
     * @author zhangyu
     */
    int save(User user);

    /**
     * 方法名: findById <br>
     * 方法描述: 根据主键查询用户信息 <br>
     *
     * @param id 主键
     * @return {@link User 返回查询用户 }
     * @date 创建时间: 2021/7/31 15:09 <br>
     * @author zhangyu
     */
    User findById(Long id);

}
