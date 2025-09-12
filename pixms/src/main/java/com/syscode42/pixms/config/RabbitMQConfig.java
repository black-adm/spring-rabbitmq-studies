package com.syscode42.pixms.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static String PIX_MADE_EXCHANGE = "pix-efetuado";

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public TopicExchange getPixMadeExchange() {
        return new TopicExchange(PIX_MADE_EXCHANGE);
    }
}
