package com.youyuan.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2021/6/9 10:34
 */
@Component
@FeignClient(value = "cloud-order-feign-service")
public interface FeignLoadBlanceService {

    @GetMapping("/lb/hand")
    void handData(List<String> list);
}
