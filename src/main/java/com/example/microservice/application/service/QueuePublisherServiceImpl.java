package com.example.microservice.application.service;

import com.example.microservice.domain.event.RequestDecisionEvent;
import com.example.microservice.domain.port.QueuePublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class QueuePublisherServiceImpl implements QueuePublisherService {

    private final QueuePublisher queuePublisher;
    private final ObjectMapper objectMapper;

    @Autowired
    public QueuePublisherServiceImpl(
            QueuePublisher queuePublisher,
            ObjectMapper objectMapper) {
        this.queuePublisher = queuePublisher;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publishEvent(RequestDecisionEvent event) {
        try {
            String eventJson = objectMapper.writeValueAsString(event);
            // Will be implemented by infrastructure layer
        } catch (Exception e) {
            throw new RuntimeException(
                    "Error serializing event: " + e.getMessage(), e);
        }
    }

    @Override
    @Async
    public void publishEventAsync(RequestDecisionEvent event) {
        publishEvent(event);
    }
}
