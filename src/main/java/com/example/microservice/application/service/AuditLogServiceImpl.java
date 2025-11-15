package com.example.microservice.application.service;

import com.example.microservice.application.dto.AuditLogDTO;
import com.example.microservice.application.dto.HistoryFilterDTO;
import com.example.microservice.application.exception.AuditException;
import com.example.microservice.domain.model.AuditLog;
import com.example.microservice.domain.port.AuditLogRepository;
import com.example.microservice.infrastructure.persistence.mapper.AuditLogMapper;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;
    private final AuditLogMapper auditLogMapper;

    @Autowired
    public AuditLogServiceImpl(
            AuditLogRepository auditLogRepository,
            AuditLogMapper auditLogMapper) {
        this.auditLogRepository = auditLogRepository;
        this.auditLogMapper = auditLogMapper;
    }

    @Override
    public List<AuditLogDTO> getHistoryByRequestId(String requestId) {
        try {
            if (requestId == null || requestId.isBlank()) {
                throw new AuditException("RequestId cannot be null or empty");
            }
            return auditLogRepository.findByRequestId(requestId).stream()
                    .map(auditLogMapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new AuditException(
                    "Error fetching audit logs by requestId: " + e.getMessage(),
                    e);
        }
    }

    @Override
    public List<AuditLogDTO> getHistoryByUserId(String userId) {
        try {
            if (userId == null || userId.isBlank()) {
                throw new AuditException("UserId cannot be null or empty");
            }
            return auditLogRepository.findByUserId(userId).stream()
                    .map(auditLogMapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new AuditException(
                    "Error fetching audit logs by userId: " + e.getMessage(), e);
        }
    }

    @Override
    public List<AuditLogDTO> getAllHistory(HistoryFilterDTO filter) {
        try {
            List<AuditLog> allLogs = auditLogRepository.findAll();

            if (filter.getRequestId() != null
                    && !filter.getRequestId().isBlank()) {
                allLogs = allLogs.stream()
                        .filter(log -> log.getRequestId()
                        .contains(filter.getRequestId()))
                        .toList();
            }

            if (filter.getUserId() != null && !filter.getUserId().isBlank()) {
                allLogs = allLogs.stream()
                        .filter(log -> log.getUserId()
                        .contains(filter.getUserId()))
                        .toList();
            }

            if (filter.getTransactionType() != null
                    && !filter.getTransactionType().isBlank()) {
                allLogs = allLogs.stream()
                        .filter(log -> log.getTransactionType().toString()
                        .equals(filter.getTransactionType()))
                        .toList();
            }

            int offset = filter.getOffset() != null ? filter.getOffset() : 0;
            int limit = filter.getLimit() != null ? filter.getLimit() : 100;

            return allLogs.stream()
                    .skip(offset)
                    .limit(limit)
                    .map(auditLogMapper::toDTO)
                    .toList();
        } catch (Exception e) {
            throw new AuditException(
                    "Error fetching audit logs: " + e.getMessage(), e);
        }
    }
}
