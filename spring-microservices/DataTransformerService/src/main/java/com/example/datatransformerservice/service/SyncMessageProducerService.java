package com.example.datatransformerservice.service;

import com.example.datatransformerservice.dto.SyncMessageDTO;

public interface SyncMessageProducerService {
    void produce(String rabbitQueue, SyncMessageDTO syncMessageDTO);
}
