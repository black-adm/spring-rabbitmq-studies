package com.syscode42.pixms.controller;

import com.syscode42.pixms.dto.PixRequestDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.syscode42.pixms.config.RabbitMQConfig.PIX_MADE_EXCHANGE;

@RestController
@RequestMapping("/api/pix")
public class PixController {

    private final RabbitTemplate rabbitTemplate;

    public PixController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> makePix(@RequestBody PixRequestDto request) {
        rabbitTemplate.convertAndSend(PIX_MADE_EXCHANGE, request.channel(), request);
        return ResponseEntity.accepted().build();
    }
}
