package com.syscode42.auditms.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static  final String AUDIT_QUEUE = "auditoria";
    public static final String PIX_MADE_EXCHANGE = "pix-efetuado";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public Queue auditQueue() {
        return new Queue(AUDIT_QUEUE);
    }

    @Bean
    public TopicExchange getPixMadeExchange() {
        return new TopicExchange(PIX_MADE_EXCHANGE);
    }

    @Bean
    public Binding bindingQueueExchange(Queue auditQueue, TopicExchange pixMadeExchange) {
        return BindingBuilder
                .bind(auditQueue)
                .to(pixMadeExchange)
                .with("*");
    }
}
