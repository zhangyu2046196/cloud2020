package com.youyuan.delayqueue.task;

/**
 * 类名称：IFutureTask <br>
 * 类描述： 任务接口 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/11/11 18:42<br>
 */
public interface IFutureTask<T> {

    /**
    * 方法名: 执行任务  <br>
    * 方法描述: doTask <br>
    *
    * @return {@link T 执行任务返回值 }
    * @date 创建时间: 2020/11/11 18:43 <br>
    * @author zhangyu
    */
    T doTask();
}
