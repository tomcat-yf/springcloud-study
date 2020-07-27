package com.guigu.springcloud.service;


import org.springframework.messaging.Message;

public interface IMessageConsumer {
    String receiver(Message<String> message);
}
