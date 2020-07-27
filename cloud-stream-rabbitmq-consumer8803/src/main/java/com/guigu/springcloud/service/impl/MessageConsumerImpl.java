package com.guigu.springcloud.service.impl;

import com.guigu.springcloud.service.IMessageConsumer;
import org.springframework.messaging.Message;

public class MessageConsumerImpl implements IMessageConsumer {

    @Override
    public String receiver(Message<String> message) {
        return message.getPayload();
    }
}
