package com.youyuan.springcloud.sentinel.feign.impl;

import cn.hutool.json.JSONUtil;
import com.youyuan.springcloud.sentinel.feign.FeignLoadBlanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2021/6/9 10:51
 */
@Slf4j
@RestController
@RequestMapping("/lb")
public class FeignLoadBlanceServiceImpl implements FeignLoadBlanceService {
    @Override
    @RequestMapping("/hand")
    public void handData(List<String> list) {
        log.info("处理数据参数={}", JSONUtil.toJsonStr(list));
    }
}
