package com.youyuan.controller;

import com.youyuan.service.HandlerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 类名称：HandlerController <br>
 * 类描述： 控制类 <br>
 *
 * @author zhangyu
 * @version 1.0.0
 * @date 创建时间：2020/7/1 10:08<br>
 */
@RestController
public class HandlerController {

    private final HandlerService handlerService;

    public HandlerController(HandlerService handlerService) {
        this.handlerService = handlerService;
    }

    @GetMapping("/handler")
    public void handler() {
        handlerService.handler();
    }
}
