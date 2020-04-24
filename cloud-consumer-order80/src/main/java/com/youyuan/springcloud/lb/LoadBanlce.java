package com.youyuan.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description 自定义ribbon负载均衡接口
 * @date 2020/4/4 21:31
 */
public interface LoadBanlce {

    public ServiceInstance getServiceInstance(List<ServiceInstance> instances);
}
