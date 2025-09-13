package com.syscode42.pfms.listener;

import com.syscode42.pfms.dto.PixRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.syscode42.pfms.config.RabbitMQConfig.PF_QUEUE;

@Component
public class PfListener {

    private final Logger logger = LoggerFactory.getLogger(PfListener.class);

    @RabbitListener(queues = PF_QUEUE)
    public void listen(Message<PixRequestDto> message) {
        logger.info("PJ - Message Received: {}", message);
    }
}
