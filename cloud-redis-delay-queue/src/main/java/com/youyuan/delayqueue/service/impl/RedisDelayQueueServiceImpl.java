package com.youyuan.delayqueue.service.impl;

import com.youyuan.delayqueue.constant.RedisQueueKey;
import com.youyuan.delayqueue.enums.ErrorMessageEnum;
import com.youyuan.delayqueue.exception.BusinessException;
import com.youyuan.delayqueue.model.Job;
import com.youyuan.delayqueue.model.JobDie;
import com.youyuan.delayqueue.service.RedisDelayQueueService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


/**
 * 类名称：RedisDelayQueueServiceImpl <br>
 * 类描述： 延时队列接口实现类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:39<br>
 */
@Slf4j
@Service
public class RedisDelayQueueServiceImpl implements RedisDelayQueueService {

    private final RedissonClient redissonClient;

    public RedisDelayQueueServiceImpl(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }


    /**
     * 添加job元信息
     *
     * @param job 元信息
     */
    @Override
    public Boolean addJob(Job job) {

        RLock lock = redissonClient.getLock(RedisQueueKey.ADD_JOB_LOCK + job.getJobId());
        try {
            boolean lockFlag = lock.tryLock(RedisQueueKey.LOCK_WAIT_TIME, RedisQueueKey.LOCK_RELEASE_TIME, TimeUnit.SECONDS);
            if (!lockFlag) {
                throw new BusinessException(ErrorMessageEnum.ACQUIRE_LOCK_FAIL);
            }
            String topicId = RedisQueueKey.getTopicId(job.getTopic(), job.getJobId());

            // 1. 将job添加到 JobPool中
            RMap<String, Job> jobPool = redissonClient.getMap(RedisQueueKey.JOB_POOL_KEY);
            if (jobPool.get(topicId) != null) {
                throw new BusinessException(ErrorMessageEnum.JOB_ALREADY_EXIST);
            }

            jobPool.put(topicId, job);

            log.info("添加job的元数据={}",job);

            // 2. 将job添加到 DelayBucket中
            RScoredSortedSet<Object> delayBucket = redissonClient.getScoredSortedSet(RedisQueueKey.RD_ZSET_BUCKET_PRE);

            return delayBucket.add(System.currentTimeMillis()+job.getDelay()*1000, topicId);
        } catch (InterruptedException e) {
            log.error("addJob error", e);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return Boolean.FALSE;
    }


    @Override
    public Boolean deleteJob(JobDie jobDie) {

        RLock lock = redissonClient.getLock(RedisQueueKey.DELETE_JOB_LOCK + jobDie.getJobId());
        try {
            boolean lockFlag = lock.tryLock(RedisQueueKey.LOCK_WAIT_TIME, RedisQueueKey.LOCK_RELEASE_TIME, TimeUnit
                    .SECONDS);
            if (!lockFlag) {
                throw new BusinessException(ErrorMessageEnum.ACQUIRE_LOCK_FAIL);
            }
            String topicId = RedisQueueKey.getTopicId(jobDie.getTopic(), jobDie.getJobId());

            RMap<String, Job> jobPool = redissonClient.getMap(RedisQueueKey.JOB_POOL_KEY);
            jobPool.remove(topicId);

            RScoredSortedSet<Object> delayBucket = redissonClient.getScoredSortedSet(RedisQueueKey.RD_ZSET_BUCKET_PRE);
            return delayBucket.remove(topicId);
        } catch (InterruptedException e) {
            log.error("addJob error", e);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
        return Boolean.FALSE;
    }
}
