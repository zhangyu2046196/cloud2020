package com.youyuan.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangy
 * @version 1.0
 * @description 自定义ribbon负载均衡算法 轮询
 * @date 2020/4/4 21:32
 */
@Component
public class MyLB implements LoadBanlce {

    //默认的服务器列表索引
    public AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 通过cas方式获取下一个服务器下标
     *
     * @return
     */
    public final int getAndIncurent() {
        //当前索引
        int current = 0;
        //下一个索引
        int next = 0;
        do {
            current=atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!atomicInteger.compareAndSet(current, next));
        System.out.println("这是第" + next + "访问");
        return next;
    }

    /**
     * 获取负载均衡后的服务器
     *
     * @param instances
     * @return
     */
    @Override
    public ServiceInstance getServiceInstance(List<ServiceInstance> instances) {
        return instances.get(getAndIncurent() % instances.size());
    }
}
