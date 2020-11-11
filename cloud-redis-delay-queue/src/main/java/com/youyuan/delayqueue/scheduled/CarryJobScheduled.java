package com.youyuan.delayqueue.scheduled;

import com.youyuan.delayqueue.constant.RedisQueueKey;
import com.youyuan.delayqueue.enums.ErrorMessageEnum;
import com.youyuan.delayqueue.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 类名称：CarryJobScheduled <br>
 * 类描述： 搬运线程 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:33<br>
 */
@Slf4j
@Component
public class CarryJobScheduled {

    private final RedissonClient redissonClient;

    public CarryJobScheduled(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
    }

    /**
    * 方法名: carryJobToQueue <br>
    * 方法描述: 启动定时开启搬运JOB信息 <br>
    *
    * @return {@link }
    * @date 创建时间: 2020/11/11 18:34 <br>
    * @author zhangyu
    */
    @Scheduled(cron = "*/1 * * * * *")
    public void carryJobToQueue() {
        RLock lock = redissonClient.getLock(RedisQueueKey.CARRY_THREAD_LOCK);
        try {
            boolean lockFlag = lock.tryLock(RedisQueueKey.LOCK_WAIT_TIME, RedisQueueKey.LOCK_RELEASE_TIME, TimeUnit
                    .SECONDS);
            if (!lockFlag) {
                throw new BusinessException(ErrorMessageEnum.ACQUIRE_LOCK_FAIL);
            }
            RScoredSortedSet<Object> bucketSet = redissonClient.getScoredSortedSet(RedisQueueKey.RD_ZSET_BUCKET_PRE);
            Collection<Object> jobCollection = bucketSet.valueRange(0, false, System.currentTimeMillis(), true);
            List<String> jobList = jobCollection.stream().map(String::valueOf).collect(Collectors.toList());
            RList<String> readyQueue = redissonClient.getList(RedisQueueKey.RD_LIST_TOPIC_PRE);
            readyQueue.addAll(jobList);
            bucketSet.removeAllAsync(jobList);
        } catch (InterruptedException e) {
            log.error("carryJobToQueue error", e);
        } finally {
            if (lock != null) {
                lock.unlock();
            }
        }
    }
}
