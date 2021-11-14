package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.config.MqConfig;
import com.example.rabbitmqconsumer.domain.CustomMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = MqConfig.MESSAGE_QUEUE_1)
    public void listener1(CustomMessage message) {
        log.info("Received first from {}",message.toString());
    }

    @RabbitListener(queues = MqConfig.MESSAGE_QUEUE_2)
    public void listener2(CustomMessage message) {
        log.info("Received second from {}",message.toString());
    }

}
