package com.example.microservice.domain.port;

import com.example.microservice.domain.model.RequestDecision;

public interface QueuePublisher {

    void publishDecision(RequestDecision decision);

    void publishDecisionAsync(RequestDecision decision);
}
