package com.guigu.springcloud.controller;


import com.guigu.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
//  有相關配置的 走自己的配置 沒有的走這個全局配置
/*@DefaultProperties(defaultFallback = "payment_GlobalHandler")*/
public class OrderHystirxController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @RequestMapping("/consumer/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "payment_OKHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    public String payment_TIMEOUT(@PathVariable("id") String id) {
        return paymentHystrixService.payment_TIMEOUT(id);
    }

    @RequestMapping("/consumer/hystrix/ok/{id}")
    /*@HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "2000")
    })*/
    public String payment_OK(@PathVariable("id") String id) {
        return paymentHystrixService.payment_OK(id);
    }

    public String payment_TimeOutHandler(String id) {
        return "线程池" + Thread.currentThread().getName() + "80paymentInfo_TimeOutHandler" + id + "O(∩_∩)O哈哈~  耗时" + "ms";
    }

    public String payment_OKHandler(String id) {
        return "线程池" + Thread.currentThread().getName() + "80paymentInfo_OKHandler" + id + "O(∩_∩)O哈哈~  耗时" + "ms";
    }

    public String payment_GlobalHandler(String id) {
        return "线程池" + Thread.currentThread().getName() + "80paymentInfo_OKHandler" + id + "O(∩_∩)O哈哈~  耗时" + "ms";
    }
}
