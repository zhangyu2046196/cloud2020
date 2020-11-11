package com.youyuan.delayqueue.controller;

import com.alibaba.fastjson.JSON;
import com.youyuan.delayqueue.model.Job;
import com.youyuan.delayqueue.model.JobDie;
import com.youyuan.delayqueue.service.RedisDelayQueueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：DelayQueueJobController <br>
 * 类描述： job信息管理 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 17:35<br>
 */
@Slf4j
@RestController
public class DelayQueueJobController {

    private final RedisDelayQueueService redisDelayQueueService;

    public DelayQueueJobController(RedisDelayQueueService redisDelayQueueService) {
        this.redisDelayQueueService = redisDelayQueueService;
    }

    /**
    * 方法名: addJob <br>
    * 方法描述: 添加job <br>
    *
     * @param job job实体内容
    * @date 创建时间: 2020/11/11 17:36 <br>
    * @author zhangyu
    */
    @PostMapping(value = "/addJob")
    public void addJob(@Validated @RequestBody Job job) {
        log.info("DelayQueueJobController.addJob param is [{}]", JSON.toJSONString(job));
        redisDelayQueueService.addJob(job);
    }

    /**
    * 方法名: deleteJob <br>
    * 方法描述: 删除job <br>
    *
     * @param jobDie 删除job实体信息
    * @date 创建时间: 2020/11/11 17:36 <br>
    * @author zhangyu
    */
    @PostMapping(value = "/deleteJob")
    public void deleteJob(@Validated @RequestBody JobDie jobDie) {
        log.info("DelayQueueJobController.deleteJob param is [{}]", JSON.toJSONString(jobDie));
        redisDelayQueueService.deleteJob(jobDie);
    }
}
