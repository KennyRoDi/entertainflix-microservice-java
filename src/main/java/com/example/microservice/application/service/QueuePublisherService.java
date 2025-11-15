package com.example.microservice.application.service;

import com.example.microservice.domain.event.RequestDecisionEvent;

public interface QueuePublisherService {

    void publishEvent(RequestDecisionEvent event);

    void publishEventAsync(RequestDecisionEvent event);
}
