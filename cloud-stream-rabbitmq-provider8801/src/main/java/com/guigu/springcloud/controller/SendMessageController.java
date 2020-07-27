package com.guigu.springcloud.controller;

import com.guigu.springcloud.service.IMessageProvider;
import com.guigu.springcloud.service.impl.MessageProviderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("stream")
public class SendMessageController {

    @Resource
    IMessageProvider messageProvider;

    @RequestMapping("send")
    public String sendMessage() {
        return messageProvider.send();
    }

}
