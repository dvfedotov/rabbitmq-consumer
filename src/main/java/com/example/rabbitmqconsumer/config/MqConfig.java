package com.example.rabbitmqconsumer.config;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MqConfig {

    public static final String MESSAGE_QUEUE_3 = "message_queue_3";
    public static final String MESSAGE_QUEUE_4 = "message_queue_4";
    public static final String MESSAGE_EXCHANGE_2 = "message_exchange_2";
    public static final String MESSAGE_ROUTING_KEY_1 = "info";
    public static final String MESSAGE_ROUTING_KEY_2 = "error";

    @Bean
    public Queue queue1() {
        return new Queue(MESSAGE_QUEUE_3);
    }

    @Bean
    public Queue queue2() {
        return new Queue(MESSAGE_QUEUE_4);
    }
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(MESSAGE_EXCHANGE_2);
    }

    @Bean
    public Binding binding1() {
        return BindingBuilder
            .bind(queue1())
            .to(exchange())
            .with(MESSAGE_ROUTING_KEY_1);
    }

    @Bean
    public Binding binding2() {
        return BindingBuilder
            .bind(queue2())
            .to(exchange())
            .with(MESSAGE_ROUTING_KEY_2);
    }

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter());
        return template;
    }
}
