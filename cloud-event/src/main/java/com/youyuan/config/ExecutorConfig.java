package com.youyuan.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 类名称：ExecutorConfig <br>
 * 类描述：线程池配置类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/2 11:30<br>
 */
@Slf4j
@Configuration
@EnableAsync
public class ExecutorConfig {

    /**
    * 方法名:  eventExecutor <br>
    * 方法描述: 事件线程池 <br>
    * 
    * @return {@link }
    * @date 创建时间: 2020/7/2 11:30 <br>
    * @author zhangyu
    */
    @Bean
    public Executor eventExecutor() {
        log.info("init eventExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(8);
        //配置最大线程数
        executor.setMaxPoolSize(20);
        //配置队列大小
        executor.setQueueCapacity(5000);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-event-");

        // 设置拒绝策略：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}