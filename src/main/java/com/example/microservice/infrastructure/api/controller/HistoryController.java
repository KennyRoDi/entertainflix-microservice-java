package com.example.microservice.infrastructure.api.controller;

import com.example.microservice.application.dto.AuditLogDTO;
import com.example.microservice.application.dto.HistoryFilterDTO;
import com.example.microservice.application.service.AuditLogService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history")
public class HistoryController {

        private final AuditLogService auditLogService;

        @Autowired
        public HistoryController(AuditLogService auditLogService) {
                this.auditLogService = auditLogService;
        }

        @GetMapping("/request/{requestId}")
        //@PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<List<AuditLogDTO>> getHistoryByRequestId(
                        @PathVariable("requestId") String requestId) {
                List<AuditLogDTO> history = auditLogService.getHistoryByRequestId(requestId);
                return ResponseEntity.ok(history);
        }

        @GetMapping("/user/{userId}")
        //@PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<List<AuditLogDTO>> getHistoryByUserId(
                        @PathVariable("userId") String userId) {
                List<AuditLogDTO> history = auditLogService.getHistoryByUserId(userId);
                return ResponseEntity.ok(history);
        }

        @GetMapping
        //@PreAuthorize("hasRole('ADMIN')")
        public ResponseEntity<List<AuditLogDTO>> getAllHistory(
                        @RequestParam(required = false) String requestId,
                        @RequestParam(required = false) String userId,
                        @RequestParam(required = false) String transactionType,
                        @RequestParam(defaultValue = "0") Integer offset,
                        @RequestParam(defaultValue = "100") Integer limit) {

                HistoryFilterDTO filter = new HistoryFilterDTO(
                                requestId,
                                userId,
                                transactionType,
                                limit,
                                offset);

                List<AuditLogDTO> history = auditLogService.getAllHistory(filter);
                return ResponseEntity.ok(history);
        }
}
