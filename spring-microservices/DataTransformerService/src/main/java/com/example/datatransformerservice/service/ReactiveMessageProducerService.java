package com.example.datatransformerservice.service;

import com.example.datatransformerservice.dto.ReactiveMessageDTO;

public interface ReactiveMessageProducerService {
    void produce(String rabbitQueue, ReactiveMessageDTO reactiveMessageDTO);
}
