package com.youyuan.delayqueue.task;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.function.Supplier;


/**
 * 类名称：TaskManager <br>
 * 类描述： 任务执行管理 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:44<br>
 */
@Slf4j
public class TaskManager {

    private TaskManager() {
    }

    /**
     * 创建一个可重用固定线程数的线程池
     */
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    /**
     * 方法名: doTask <br>
     * 方法描述: 异步执行任务 <br>
     *
     * @param task  任务
     * @param title 标题
     * @date 创建时间: 2020/11/11 18:45 <br>
     * @author zhangyu
     */
    public static void doTask(final ITask task, String title) {
        executorService.execute(() -> SpeedTimeLogSuit.wrap((Supplier<Void>) () -> {
            try {
                task.doTask();
            } catch (Exception e) {
                log.error("TaskManager doTask execute error.", e);
            }
            return null;
        }, title));
    }

    /**
     * 方法名: doFutureTask <br>
     * 方法描述: 带有返回值的task <br>
     *
     * @param task  任务
     * @param title 标题
     * @return {@link FutureTask<T> 返回值 }
     * @date 创建时间: 2020/11/11 18:45 <br>
     * @author zhangyu
     */
    public static <T> FutureTask<T> doFutureTask(final IFutureTask<T> task, String title) {
        FutureTask<T> future = new FutureTask<>(() -> SpeedTimeLogSuit.wrap((task::doTask), title));
        executorService.execute(future);
        return future;
    }
}
