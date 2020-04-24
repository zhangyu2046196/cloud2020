package com.youyuan.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/23 14:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Storage implements Serializable {
    private static final long serialVersionUID = -8093558511534514640L;

    /**
     * 主键
     */
    private Long id;
    /**
     * 产品id
     */
    private Long productId;
    /**
     * 总库存数
     */
    private Integer total;
    /**
     * 使用库存
     */
    private Integer used;
    /**
     * 剩余库存
     */
    private Integer residue;
}
