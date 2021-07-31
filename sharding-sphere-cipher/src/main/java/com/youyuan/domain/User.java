package com.youyuan.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 类名称：User <br>
 * 类描述： 用户表映射实体 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2021/7/31 15:05<br>
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;


}
