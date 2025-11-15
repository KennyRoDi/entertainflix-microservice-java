package com.example.microservice.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class AuditLog {

    private final UUID transactionId;
    private final String requestId;
    private final String userId;
    private final String actorType;
    private final TransactionType transactionType;
    private final LocalDateTime timestamp;
    private final String metadata;
    private final String previousState;

    public AuditLog(
            UUID transactionId,
            String requestId,
            String userId,
            String actorType,
            TransactionType transactionType,
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

    public UUID getTransactionId() {
        return transactionId;
    }

    public String getRequestId() {
        return requestId;
    }

    public String getUserId() {
        return userId;
    }

    public String getActorType() {
        return actorType;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMetadata() {
        return metadata;
    }

    public String getPreviousState() {
        return previousState;
    }
}
