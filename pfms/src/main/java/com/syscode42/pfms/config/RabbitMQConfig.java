package com.syscode42.pfms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static  final String PF_QUEUE = "pf-queue";
    public static  final String PF_ROUTING_KEY = "pf";
    public static final String PIX_MADE_EXCHANGE = "pix-efetuado";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue pfQueue() {
        return new Queue(PF_QUEUE);
    }

    @Bean
    public TopicExchange getPixMadeExchange() {
        return new TopicExchange(PIX_MADE_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue pfQueue, TopicExchange pixMadeExchange) {
        return BindingBuilder
                .bind(pfQueue)
                .to(pixMadeExchange)
                .with(PF_ROUTING_KEY);
    }
}
