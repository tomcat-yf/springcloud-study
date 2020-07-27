package com.guigu.springcloud.service.impl;

import com.guigu.springcloud.service.IMessageConsumer;
import org.springframework.messaging.Message;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;

public class MessageConsumerImpl implements IMessageConsumer {

    @Override
    public String receiver(Message<String> message) {
        return message.getPayload();
    }
}
