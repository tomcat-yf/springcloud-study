package com.guigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    DiscoveryClient discoveryClient;

    @GetMapping("/payment/zk")
    public Object discovery() {
        // 获取所有的注册服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        // 获得自定的服务实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            instance.getUri();
        }
        return this.discoveryClient;
    }

}
