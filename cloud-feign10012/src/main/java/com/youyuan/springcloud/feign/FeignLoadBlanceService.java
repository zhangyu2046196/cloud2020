package com.youyuan.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2021/6/9 10:49
 */
@Component
@FeignClient(value = "cloud-feign")
public interface FeignLoadBlanceService {

    @RequestMapping("/lb/hand")
    void handData(@RequestParam("list")List<String> list);
}
