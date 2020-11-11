package com.youyuan.delayqueue.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;

import java.util.function.Supplier;

/**
 * 类名称：SpeedTimeLogSuit <br>
 * 类描述： 记录运行时间 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:43<br>
 */
@Slf4j
public class SpeedTimeLogSuit {

    private SpeedTimeLogSuit() {
    }

    /**
     * 方法名: wrap  <br>
     * 方法描述: 执行并打印执行时间 <br>
     *
     * @param supplier 执行方法
     * @param title    标题
     * @param <T>      返回值类型
     * @return {@link T 返回值}
     * @date 创建时间: 2020/11/11 18:44 <br>
     * @author zhangyu
     */
    public static <T> T wrap(Supplier<T> supplier, String title) {
        log.info("SPEED_TIME_LOG:[{}], start to run", title);
        StopWatch watch = new StopWatch();
        watch.start();
        T result = supplier.get();
        watch.stop();
        log.info("SPEED_TIME_LOG:[{}] run completed in {} ms", title, watch.getTotalTimeMillis());
        return result;
    }
}
