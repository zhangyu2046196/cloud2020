package com.youyuan.springcloud.controller;

import cn.hutool.json.JSONUtil;
import com.youyuan.springcloud.feign.FeignLoadBlanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2021/6/9 11:11
 */
@RestController
@Slf4j
public class LbController {

    @Autowired
    private FeignLoadBlanceService feignLoadBlanceService;

    @RequestMapping("/lb/data")
    public void data() {
        List<List<String>> listList = new ArrayList<>();
        listList.add(Arrays.asList("1", "2", "3"));
        listList.add(Arrays.asList("a", "b", "c"));

        for (List<String> list : listList) {
            log.info("处理数据10012,list={}", JSONUtil.toJsonStr(list));
            feignLoadBlanceService.handData(list);
        }
    }
}
