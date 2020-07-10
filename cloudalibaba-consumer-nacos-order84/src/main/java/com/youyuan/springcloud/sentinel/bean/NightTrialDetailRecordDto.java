package com.youyuan.springcloud.sentinel.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 类名称：NightTrialDetailRecordDto <br>
 * 类描述：夜审步骤详单 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/6/6 16:05<br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NightTrialDetailRecordDto implements Serializable {
    private static final long serialVersionUID = 4292626347766180506L;

    /**
     * 序号
     */
    private Integer num;
    /**
     * 消息内容
     */
    private String msg;
    /**
     * 预留字段
     */
    private String reserved;
}
