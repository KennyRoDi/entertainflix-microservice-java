package com.example.microservice.infrastructure.persistence.repository;

import com.example.microservice.infrastructure.persistence.entity.AuditLogEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditLogJpaRepository
        extends JpaRepository<AuditLogEntity, UUID> {

    List<AuditLogEntity> findByRequestId(String requestId);

    List<AuditLogEntity> findByUserId(String userId);

    List<AuditLogEntity> findByTransactionType(String transactionType);
}
