package com.guigu;

import com.guigu.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLb implements LoadBalancer {

    private AtomicInteger acInteger = new AtomicInteger(0);

    public final int getIncrement() {
        int current;
        int next;
        do {
            current = this.acInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.acInteger.compareAndSet(current, next));
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> list) {

        int index = getIncrement() % list.size();
        return list.get(index);
    }
}
