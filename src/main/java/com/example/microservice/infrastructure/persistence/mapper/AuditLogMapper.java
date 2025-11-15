package com.example.microservice.infrastructure.persistence.mapper;

import com.example.microservice.application.dto.AuditLogDTO;
import com.example.microservice.domain.model.AuditLog;
import com.example.microservice.domain.model.TransactionType;
import com.example.microservice.infrastructure.persistence.entity.AuditLogEntity;
import org.springframework.stereotype.Component;

@Component
public class AuditLogMapper {

    public AuditLog toDomain(AuditLogEntity entity) {
        return new AuditLog(
                entity.getTransactionId(),
                entity.getRequestId(),
                entity.getUserId(),
                entity.getActorType(),
                TransactionType.valueOf(entity.getTransactionType()),
                entity.getTimestamp(),
                entity.getMetadata(),
                entity.getPreviousState());
    }

    public AuditLogEntity toEntity(AuditLog auditLog) {
        AuditLogEntity entity = new AuditLogEntity();
        entity.setTransactionId(auditLog.getTransactionId());
        entity.setRequestId(auditLog.getRequestId());
        entity.setUserId(auditLog.getUserId());
        entity.setActorType(auditLog.getActorType());
        entity.setTransactionType(auditLog.getTransactionType().toString());
        entity.setTimestamp(auditLog.getTimestamp());
        entity.setMetadata(auditLog.getMetadata());
        entity.setPreviousState(auditLog.getPreviousState());
        return entity;
    }

    public AuditLogDTO toDTO(AuditLog auditLog) {
        return new AuditLogDTO(
                auditLog.getTransactionId(),
                auditLog.getRequestId(),
                auditLog.getUserId(),
                auditLog.getActorType(),
                auditLog.getTransactionType().toString(),
                auditLog.getTimestamp(),
                auditLog.getMetadata(),
                auditLog.getPreviousState());
    }
}
