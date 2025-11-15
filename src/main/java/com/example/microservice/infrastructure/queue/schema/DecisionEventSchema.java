package com.example.microservice.infrastructure.queue.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DecisionEventSchema {

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("ofertantId")
    private String ofertantId;

    @JsonProperty("customerId")
    private String customerId;

    @JsonProperty("newStatus")
    private String newStatus;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("reason")
    private String reason;

    public DecisionEventSchema() {
    }

    public DecisionEventSchema(
            String requestId,
            String ofertantId,
            String customerId,
            String newStatus,
            String timestamp,
            String reason) {
        this.requestId = requestId;
        this.ofertantId = ofertantId;
        this.customerId = customerId;
        this.newStatus = newStatus;
        this.timestamp = timestamp;
        this.reason = reason;
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

    public String getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(String newStatus) {
        this.newStatus = newStatus;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
