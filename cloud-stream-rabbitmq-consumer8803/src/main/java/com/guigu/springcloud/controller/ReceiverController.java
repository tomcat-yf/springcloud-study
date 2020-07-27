package com.guigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@EnableBinding(Sink.class)
@Component
public class ReceiverController {

    @Value("${server.port}")
    String port;

    @StreamListener(Sink.INPUT)
    public void receiver(Message<String> message) {
        System.out.println("ServerPort    :    " + port + "Message" + message.getPayload());
    }

}
