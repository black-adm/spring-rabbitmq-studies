package com.syscode42.pjms.listener;

import com.syscode42.pjms.dto.PixRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.syscode42.pjms.config.RabbitMQConfig.PJ_QUEUE;

@Component
public class PjListener {

    private final Logger logger = LoggerFactory.getLogger(PjListener.class);

    @RabbitListener(queues = PJ_QUEUE)
    public void listen(Message<PixRequestDto> message) {
        logger.info("PJ - Message Received: {}", message);
    }
}
