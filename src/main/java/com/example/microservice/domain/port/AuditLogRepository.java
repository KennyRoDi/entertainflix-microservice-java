package com.example.microservice.domain.port;

import com.example.microservice.domain.model.AuditLog;
import java.util.List;
import java.util.UUID;

public interface AuditLogRepository {

    AuditLog save(AuditLog auditLog);

    AuditLog findByTransactionId(UUID transactionId);

    List<AuditLog> findByRequestId(String requestId);

    List<AuditLog> findByUserId(String userId);

    List<AuditLog> findAll();
}
