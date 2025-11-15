package com.example.microservice.infrastructure.persistence.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "audit_logs", indexes = {
    @Index(name = "idx_request_id", columnList = "request_id"),
    @Index(name = "idx_user_id", columnList = "user_id"),
    @Index(name = "idx_timestamp", columnList = "timestamp")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuditLogEntity {

    @Id
    @Column(name = "transaction_id")
    private UUID transactionId;

    @Column(name = "request_id", nullable = false)
    private String requestId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "actor_type")
    private String actorType;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "metadata", columnDefinition = "TEXT")
    private String metadata;

    @Column(name = "previous_state", columnDefinition = "TEXT")
    private String previousState;
}
