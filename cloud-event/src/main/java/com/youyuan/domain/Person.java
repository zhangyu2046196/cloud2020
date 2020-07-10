package com.youyuan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/7/1 10:32
 */
@Data
@AllArgsConstructor
public class Person implements Serializable {
    private static final long serialVersionUID = 5335593325028733963L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
}
