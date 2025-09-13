package com.syscode42.auditms.listener;

import com.syscode42.auditms.dto.PixRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.syscode42.auditms.config.RabbitMQConfig.AUDIT_QUEUE;

@Component
public class AuditListener {

    private final Logger logger = LoggerFactory.getLogger(AuditListener.class);

    @RabbitListener(queues = AUDIT_QUEUE)
    public void listen(Message<PixRequestDto> message) {
        logger.info("AUDIT - Message Received: {}", message);
    }
}
