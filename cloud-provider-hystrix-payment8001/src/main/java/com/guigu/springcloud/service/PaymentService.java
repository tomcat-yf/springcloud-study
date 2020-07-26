package com.guigu.springcloud.service;

import ch.qos.logback.core.util.TimeUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import io.micrometer.core.instrument.util.TimeUtils;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    @HystrixCommand(fallbackMethod = "payment_OKHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_OK(Integer id) {
        int age = 10 / 0;
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OK" + id + "O(∩_∩)O哈哈~";
    }


    @HystrixCommand(fallbackMethod = "payment_TimeOutHandler", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        Long timeout = 5L;
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOut" + id + "O(∩_∩)O哈哈~  耗时" + timeout + "s";
    }

    public String payment_TimeOutHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_TimeOutHandler" + id + "O(∩_∩)O哈哈~  耗时" + "ms";
    }

    public String payment_OKHandler(Integer id) {
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_OKHandler" + id + "O(∩_∩)O哈哈~  耗时" + "ms";
    }

}
