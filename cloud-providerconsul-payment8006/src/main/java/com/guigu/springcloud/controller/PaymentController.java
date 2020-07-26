package com.guigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;


    @GetMapping("/payment/consul")
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
        return "当前springcloud  with consul的端口为" + port;
    }

}
