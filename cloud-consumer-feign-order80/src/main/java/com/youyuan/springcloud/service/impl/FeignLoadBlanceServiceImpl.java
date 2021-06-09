package com.youyuan.springcloud.service.impl;

import cn.hutool.json.JSONUtil;
import com.youyuan.springcloud.service.FeignLoadBlanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2021/6/9 10:36
 */
@Slf4j
@RestController
@RequestMapping("/lb")
public class FeignLoadBlanceServiceImpl implements FeignLoadBlanceService {
    @Override
    @GetMapping("/hand")
    public void handData(List<String> list) {
        log.info("接收数据={}", JSONUtil.toJsonStr(list));
    }
}
