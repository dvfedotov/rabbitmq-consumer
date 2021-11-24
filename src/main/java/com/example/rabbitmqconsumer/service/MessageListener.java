package com.example.rabbitmqconsumer.service;

import com.example.rabbitmqconsumer.config.MqConfig;
import com.example.rabbitmqconsumer.domain.LoggingOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageListener {

    @RabbitListener(queues = MqConfig.MESSAGE_QUEUE_3)
    public void listener3(LoggingOrder order) {
        log.info("Received accepted  order from {}", order.toString());
    }

    @RabbitListener(queues = MqConfig.MESSAGE_QUEUE_4)
    public void listener4(LoggingOrder order) {
        log.info("Received canceled order from {}", order.toString());
    }

}
