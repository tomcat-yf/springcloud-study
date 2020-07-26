package com.guigu.springcloud.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT", fallback = PaymentFallbackService.class)
public interface PaymentHystrixService {

    @RequestMapping("/payment/hystrix/timeout/{id}")
    String payment_TIMEOUT(@PathVariable("id") String id);

    @RequestMapping("/payment/hystrix/ok/{id}")
    String payment_OK(@PathVariable("id") String id);


}
