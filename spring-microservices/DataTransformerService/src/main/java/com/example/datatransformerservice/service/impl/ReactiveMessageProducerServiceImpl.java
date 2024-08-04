package com.example.datatransformerservice.service.impl;

import com.example.datatransformerservice.configuration.RabbitConfiguration;
import com.example.datatransformerservice.dto.ReactiveMessageDTO;
import com.example.datatransformerservice.service.ReactiveMessageProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReactiveMessageProducerServiceImpl implements ReactiveMessageProducerService {
    private final RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = RabbitConfiguration.REACTIVE_QUEUE_REQUEST)
    public void receiveMessages(ReactiveMessageDTO reactiveMessageDTO) {
        reactiveMessageDTO.setProcessedTime(LocalDateTime.now());
        reactiveMessageDTO.setReactActive(true);
        rabbitTemplate.convertAndSend(RabbitConfiguration.REACTIVE_QUEUE_RESPONSE, reactiveMessageDTO);
    }


    @Override
    public void produce(String rabbitQueue, ReactiveMessageDTO reactiveMessageDTO) {
        reactiveMessageDTO.setSentTime(LocalDateTime.now());
        rabbitTemplate.convertAndSend(rabbitQueue, reactiveMessageDTO);
    }
}
