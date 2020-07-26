package com.guigu.springcloud.service.impl;

import com.guigu.springcloud.dao.PaymentDao;
import com.guigu.springcloud.entity.Payment;
import com.guigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentDao.findPaymentById(id);
    }
}
