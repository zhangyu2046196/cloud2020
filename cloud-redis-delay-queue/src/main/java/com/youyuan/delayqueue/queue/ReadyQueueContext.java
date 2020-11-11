package com.youyuan.delayqueue.queue;

import com.youyuan.delayqueue.constant.RedisQueueKey;
import com.youyuan.delayqueue.enums.RetryStrategyEnum;
import com.youyuan.delayqueue.model.Job;
import com.youyuan.delayqueue.service.ConsumerService;
import com.youyuan.delayqueue.task.TaskManager;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * 类名称：ReadyQueueContext <br>
 * 类描述： 消费消息信息 <br>
 * Ready Queue存放处于Ready状态的Job（这里只存放Job Id），以供消费程序消费
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:07<br>
 */
@Slf4j
@Component
public class ReadyQueueContext {

    private final RedissonClient redissonClient;
    private final ConsumerService consumerService;

    public ReadyQueueContext(RedissonClient redissonClient, ConsumerService consumerService) {
        this.redissonClient = redissonClient;
        this.consumerService = consumerService;
    }

    /**
     * 方法名: startTopicConsumer <br>
     * 方法描述: TOPIC消费线程 <br>
     *
     * @date 创建时间: 2020/11/11 18:09 <br>
     * @author zhangyu
     */
    @PostConstruct
    public void startTopicConsumer() {
        TaskManager.doTask(this::runTopicThreads, "开启TOPIC消费线程");
    }

    /**
     * 方法名: runTopicThreads <br>
     * 方法描述: 开启消费线程 <br>
     * 开启TOPIC消费线程
     * 将所有可能出现的异常全部catch住，确保While(true)能够不中断
     *
     * @date 创建时间: 2020/11/11 18:10 <br>
     * @author zhangyu
     */
    @SuppressWarnings("InfiniteLoopStatement")
    private void runTopicThreads() {
        while (true) {
            RLock lock = null;
            try {
                lock = redissonClient.getLock(RedisQueueKey.CONSUMER_TOPIC_LOCK);
                if (lock == null) {
                    continue;
                }
                // 分布式锁时间比Blpop阻塞时间多1S，避免出现释放锁的时候，锁已经超时释放，unlock报错
                boolean lockFlag = lock.tryLock(RedisQueueKey.LOCK_WAIT_TIME, RedisQueueKey.LOCK_RELEASE_TIME,
                        TimeUnit.SECONDS);
                if (!lockFlag) {
                    continue;
                }
            } catch (Exception e) {
                log.error("runTopicThreads getLock error", e);
            }
            try {
                // 1. 获取ReadyQueue中待消费的数据
                RBlockingQueue<String> queue = redissonClient.getBlockingQueue(RedisQueueKey.RD_LIST_TOPIC_PRE);
                String topicId = queue.poll(60, TimeUnit.SECONDS);
                if (StringUtils.isEmpty(topicId)) {
                    continue;
                }

                // 2. 获取job元信息内容
                RMap<String, Job> jobPoolMap = redissonClient.getMap(RedisQueueKey.JOB_POOL_KEY);
                Job job = jobPoolMap.get(topicId);

                log.info("消费这消息初始内容={}", job);

                // 3. 消费
                FutureTask<Boolean> taskResult = TaskManager.doFutureTask(() -> consumerService.consumerMessage(job
                        .getBody()), job.getTopic() + "-->消费JobId-->" + job.getJobId());
                if (taskResult.get()) {
                    // 3.1 消费成功，删除JobPool和DelayBucket的job信息
                    jobPoolMap.remove(topicId);
                } else {
                    int retrySum = job.getRetry() + 1;
                    // 3.2 消费失败，则根据策略重新加入Bucket

                    // 如果重试次数大于5，则将jobPool中的数据删除，持久化到DB
                    if (retrySum > RetryStrategyEnum.RETRY_FIVE.getRetry()) {
                        jobPoolMap.remove(topicId);
                        continue;
                    }
                    job.setRetry(retrySum);
                    long nextTime = job.getDelay() + RetryStrategyEnum.getDelayTime(job.getRetry()) * 1000;
                    log.info("next retryTime is [{}]", nextTime);
                    RScoredSortedSet<Object> delayBucket = redissonClient.getScoredSortedSet(RedisQueueKey
                            .RD_ZSET_BUCKET_PRE);
                    delayBucket.add(nextTime, topicId);
                    // 3.3 更新元信息失败次数
                    jobPoolMap.put(topicId, job);
                }
            } catch (Exception e) {
                log.error("runTopicThreads error", e);
            } finally {
                if (lock != null) {
                    try {
                        lock.unlock();
                    } catch (Exception e) {
                        log.error("runTopicThreads unlock error", e);
                    }
                }
            }
        }
    }


}
