package com.youyuan.springcloud.controller;

import com.youyuan.springcloud.service.IMessageProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangy
 * @version 1.0
 * @description
 * @date 2020/4/17 8:07
 */
@RestController
public class ProviderController {

    @Autowired
    private IMessageProvider messageProvider;

    @RequestMapping("/message/send")
    public void send() {
        messageProvider.send();
    }
}
