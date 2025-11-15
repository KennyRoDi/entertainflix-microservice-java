package com.example.microservice.infrastructure.persistence.repository;

import com.example.microservice.domain.model.AuditLog;
import com.example.microservice.domain.port.AuditLogRepository;
import com.example.microservice.infrastructure.persistence.entity.AuditLogEntity;
import com.example.microservice.infrastructure.persistence.mapper.AuditLogMapper;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuditLogRepositoryImpl implements AuditLogRepository {

    private final AuditLogJpaRepository jpaRepository;
    private final AuditLogMapper mapper;

    @Autowired
    public AuditLogRepositoryImpl(
            AuditLogJpaRepository jpaRepository,
            AuditLogMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public AuditLog save(AuditLog auditLog) {
        AuditLogEntity entity = mapper.toEntity(auditLog);
        AuditLogEntity saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public AuditLog findByTransactionId(UUID transactionId) {
        return jpaRepository
                .findById(transactionId)
                .map(mapper::toDomain)
                .orElse(null);
    }

    @Override
    public List<AuditLog> findByRequestId(String requestId) {
        return jpaRepository.findByRequestId(requestId).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<AuditLog> findByUserId(String userId) {
        return jpaRepository.findByUserId(userId).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<AuditLog> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }
}
