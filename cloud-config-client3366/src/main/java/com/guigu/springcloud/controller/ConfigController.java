package com.guigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("config")
@RefreshScope
public class ConfigController {

    @Value("#{server.port}")
    String port;

    @Value("#{config.info}")
    String info;

    @RequestMapping("getInfo")
    public String getInfo() {
        return "ServerPort :  " + port + "---------" + "Config-Info :    " + info;
    }
}
