package com.example.microservice.domain.event;

import com.example.microservice.domain.model.DecisionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;

public class RequestDecisionEvent {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("ofertantId")
    private String ofertantId;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("newStatus")
    private DecisionStatus newStatus;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("reason")
    private String reason;

    public RequestDecisionEvent(
            String requestId,
            String ofertantId,
            String customerId,
            DecisionStatus newStatus,
            LocalDateTime timestamp,
            String reason) {
        this.requestId = requestId;
        this.ofertantId = ofertantId;
        this.customerId = customerId;
        this.newStatus = newStatus;
        this.timestamp = timestamp;
        this.reason = reason;
    }

    public RequestDecisionEvent() {
    }

    // Getters and Setters
    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getOfertantId() {
        return ofertantId;
    }

    public void setOfertantId(String ofertantId) {
        this.ofertantId = ofertantId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public DecisionStatus getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(DecisionStatus newStatus) {
        this.newStatus = newStatus;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
