package com.guigu.springcloud.service;

import com.guigu.springcloud.entity.CommonResult;
import com.guigu.springcloud.entity.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String payment_TIMEOUT(String id) {
        return "超时 payment_TIMEOUT";
    }

    @Override
    public String payment_OK(String id) {
        return "OK payment_OK";
    }

}
