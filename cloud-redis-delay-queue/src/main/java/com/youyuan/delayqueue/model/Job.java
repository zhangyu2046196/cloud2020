package com.youyuan.delayqueue.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 类名称：Job <br>
 * 类描述： 消息结构 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 17:40<br>
 */
@Data
public class Job implements Serializable {

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

    /**
     * Job需要延迟的时间。单位：秒。（服务端会将其转换为绝对时间）
     */
    private Long delay;

    /**
     * Job的内容，供消费者做具体的业务处理，以json格式存储
     */
    @NotBlank
    private String body;

    /**
     * 失败重试次数
     */
    private int retry = 0;

    /**
     * 消息来源信息
     */
    private Integer sourceType;
}
