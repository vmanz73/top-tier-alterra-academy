package com.vmanmedia.books.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class VmanQueueConsumer {
    @RabbitListener(queues = {"${queue.name}"})
    public void process(@Payload String message) {
        System.out.println("Data => "+message);

    }
}
