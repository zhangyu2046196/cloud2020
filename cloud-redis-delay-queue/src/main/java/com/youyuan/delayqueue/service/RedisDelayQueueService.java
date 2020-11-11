package com.youyuan.delayqueue.service;

import com.youyuan.delayqueue.model.Job;
import com.youyuan.delayqueue.model.JobDie;

/**
 * 类名称：延时队列接口 <br>
 * 类描述： RedisDelayQueueService <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:35<br>
 */
public interface RedisDelayQueueService {

    /**
     * 方法名: addJob <br>
     * 方法描述: 添加job元信息 <br>
     *
     * @return {@link Boolean true添加成功 false添加失败}
     * @date 创建时间: 2020/11/11 18:35 <br>
     * @author zhangyu
     */
    Boolean addJob(Job job);


    /**
     * 方法名: deleteJob <br>
     * 方法描述: 删除job信息 <br>
     *
     * @return {@link Boolean true删除成功 false删除失败}
     * @date 创建时间: 2020/11/11 18:36 <br>
     * @author zhangyu
     */
    Boolean deleteJob(JobDie jobDie);
}
