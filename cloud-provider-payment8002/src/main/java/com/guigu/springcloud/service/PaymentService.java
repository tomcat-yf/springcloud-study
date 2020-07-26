package com.guigu.springcloud.service;

import com.guigu.springcloud.entity.Payment;

public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);

}
