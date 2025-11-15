package com.example.microservice.application.service;

import com.example.microservice.application.dto.RequestDecisionRequestDTO;
import com.example.microservice.application.dto.RequestDecisionResponseDTO;
import com.example.microservice.application.exception.DecisionException;
import com.example.microservice.domain.model.AuditLog;
import com.example.microservice.domain.model.DecisionStatus;
import com.example.microservice.domain.model.RequestDecision;
import com.example.microservice.domain.model.TransactionType;
import com.example.microservice.domain.port.AuditLogRepository;
import com.example.microservice.domain.port.QueuePublisher;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RequestDecisionServiceImpl
        implements RequestDecisionService {

    private final AuditLogRepository auditLogRepository;
    private final QueuePublisher queuePublisher;

    @Autowired
    public RequestDecisionServiceImpl(
            AuditLogRepository auditLogRepository,
            QueuePublisher queuePublisher) {
        this.auditLogRepository = auditLogRepository;
        this.queuePublisher = queuePublisher;
    }

    @Override
    public RequestDecisionResponseDTO makeDecision(
            RequestDecisionRequestDTO request,
            String userId) {
        try {
            DecisionStatus status
                    = DecisionStatus.valueOf(request.getDecision().toUpperCase());

            UUID transactionId = UUID.randomUUID();

            RequestDecision decision = new RequestDecision(
                    transactionId,
                    request.getRequestId(),
                    request.getCliente(),
                    request.getCorreo(),
                    request.getTelefono(),
                    request.getMensaje(),
                    request.getUbicacion(),
                    request.getServicio(),
                    request.getPaquete(),
                    request.getOfertante(),
                    status,
                    request.getRazon(),
                    LocalDateTime.now(),
                    userId);

            TransactionType transactionType
                    = status == DecisionStatus.ACCEPTED
                            ? TransactionType.ACCEPTED_REQUEST
                            : TransactionType.DENIED_REQUEST;

            String metadata = String.format(
                    "{\"cliente\":\"%s\",\"servicio\":\"%s\",\"paquete\":\"%s\","
                    + "\"razon\":\"%s\",\"status\":\"%s\"}",
                    request.getCliente(),
                    request.getServicio(),
                    request.getPaquete(),
                    request.getRazon() != null ? request.getRazon() : "",
                    status);

            AuditLog auditLog = new AuditLog(
                    transactionId,
                    request.getRequestId(),
                    request.getOfertante(),
                    "OFERTANT",
                    transactionType,
                    LocalDateTime.now(),
                    metadata,
                    null);

            auditLogRepository.save(auditLog);
            queuePublisher.publishDecision(decision);

            return mapToResponseDTO(decision);
        } catch (IllegalArgumentException e) {
            throw new DecisionException(
                    "Invalid decision status. Must be ACCEPTED or DENIED", e);
        } catch (Exception e) {
            throw new DecisionException(
                    "Error processing decision: " + e.getMessage(), e);
        }
    }

    private RequestDecisionResponseDTO mapToResponseDTO(
            RequestDecision decision) {
        return new RequestDecisionResponseDTO(
                decision.getId(),
                decision.getRequestId(),
                decision.getCliente(),
                decision.getCorreo(),
                decision.getServicio(),
                decision.getPaquete(),
                decision.getOfertante(),
                decision.getStatus().toString(),
                decision.getRazon(),
                decision.getDecidedAt(),
                decision.getDecidedBy());
    }
}
