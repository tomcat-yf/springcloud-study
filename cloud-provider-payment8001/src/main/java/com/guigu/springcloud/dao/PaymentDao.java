package com.guigu.springcloud.dao;

import com.guigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    int create(Payment payment);

    Payment findPaymentById(@Param("id") Long id);

}
