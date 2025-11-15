package com.example.microservice.domain.port;

import com.example.microservice.domain.model.RequestDecision;

public interface RequestDecisionHandler {

    RequestDecision handleAcceptDecision(
            String requestId,
            String ofertantId,
            String customerId,
            String decidedBy,
            String reason);

    RequestDecision handleDenyDecision(
            String requestId,
            String ofertantId,
            String customerId,
            String decidedBy,
            String reason);
}
