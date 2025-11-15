package com.example.microservice.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.UUID;

public class AuditLogDTO {

    @JsonProperty("transactionId")
    private UUID transactionId;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("userId")
    private String userId;

    @JsonProperty("actorType")
    private String actorType;

    @JsonProperty("transactionType")
    private String transactionType;

    @JsonProperty("timestamp")
    private LocalDateTime timestamp;

    @JsonProperty("metadata")
    private String metadata;

    @JsonProperty("previousState")
    private String previousState;

    public AuditLogDTO() {
    }

    public AuditLogDTO(
            UUID transactionId,
            String requestId,
            String userId,
            String actorType,
            String transactionType,
            LocalDateTime timestamp,
            String metadata,
            String previousState) {
        this.transactionId = transactionId;
        this.requestId = requestId;
        this.userId = userId;
        this.actorType = actorType;
        this.transactionType = transactionType;
        this.timestamp = timestamp;
        this.metadata = metadata;
        this.previousState = previousState;
    }

    // Getters and Setters
    public UUID getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(UUID transactionId) {
        this.transactionId = transactionId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getActorType() {
        return actorType;
    }

    public void setActorType(String actorType) {
        this.actorType = actorType;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public String getPreviousState() {
        return previousState;
    }

    public void setPreviousState(String previousState) {
        this.previousState = previousState;
    }
}
