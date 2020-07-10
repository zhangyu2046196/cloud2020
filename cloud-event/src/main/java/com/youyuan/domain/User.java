package com.youyuan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 类名称：User <br>
 * 类描述： 用户 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/6/30 21:05<br>
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -5400575090584431032L;

    /**
     * id
     */
    private Long id;
    /**
     * 用户
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 时间
     */
    private Date addTime;

}
