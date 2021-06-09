package com.youyuan.springcloud.sentinel.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2021/6/9 10:49
 */
@FeignClient(value = "cloudalibaba-sentinel-service")
public interface FeignLoadBlanceService {

    @RequestMapping("/lb/hand")
    void handData(List<String> list);
}
