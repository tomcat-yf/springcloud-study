package com.guigu.springcloud.controller;


import com.guigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
public class PaymenController {


    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @RequestMapping("/payment/hystrix/ok/{id}")
    public String Payment_OK(@PathVariable("id") Integer id) {
        int age = 10 / 0;
        String str = paymentService.paymentInfo_OK(id);
        return str;
    }


    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String Payment_TIMEOUT(@PathVariable("id") Integer id) {
        String str = paymentService.paymentInfo_TimeOut(id);
        log.info(str);
        return str;
    }

}
