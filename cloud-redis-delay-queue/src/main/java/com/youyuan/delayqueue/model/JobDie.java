package com.youyuan.delayqueue.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 类名称：JobDie <br>
 * 类描述： 删除消息结构 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:04<br>
 */
@Data
public class JobDie implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Job的唯一标识。用来检索和删除指定的Job信息
     */
    @NotBlank
    private String jobId;


    /**
     * Job类型。可以理解成具体的业务名称
     */
    @NotBlank
    private String topic;
}
