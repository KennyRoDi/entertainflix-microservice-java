package com.example.microservice.application.service;

import com.example.microservice.application.dto.AuditLogDTO;
import com.example.microservice.application.dto.HistoryFilterDTO;
import java.util.List;

public interface AuditLogService {

    List<AuditLogDTO> getHistoryByRequestId(String requestId);

    List<AuditLogDTO> getHistoryByUserId(String userId);

    List<AuditLogDTO> getAllHistory(HistoryFilterDTO filter);
}
