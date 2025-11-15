package com.example.microservice.infrastructure.api.controller;

import com.example.microservice.application.dto.RequestDecisionRequestDTO;
import com.example.microservice.application.dto.RequestDecisionResponseDTO;
import com.example.microservice.application.service.RequestDecisionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
public class RequestDecisionController {
        private final RequestDecisionService requestDecisionService;

        @Autowired
        public RequestDecisionController(
                        RequestDecisionService requestDecisionService) {
                this.requestDecisionService = requestDecisionService;
        }

        @PostMapping("/{id}/decision")
        public ResponseEntity<RequestDecisionResponseDTO> makeDecisionPost(
                        @PathVariable("id") String requestId,
                        @Valid @RequestBody RequestDecisionRequestDTO request,
                        Authentication authentication) {

                String userId = authentication != null
                                ? authentication.getName()
                                : "SYSTEM";

                RequestDecisionResponseDTO response = requestDecisionService.makeDecision(request, userId);

                return new ResponseEntity<>(response, HttpStatus.CREATED);
        }

        @PatchMapping("/{id}/decision")
        public ResponseEntity<RequestDecisionResponseDTO> makeDecisionPatch(
                        @PathVariable("id") String requestId,
                        @Valid @RequestBody RequestDecisionRequestDTO request,
                        Authentication authentication) {

                String userId = authentication != null
                                ? authentication.getName()
                                : "SYSTEM";

                RequestDecisionResponseDTO response = requestDecisionService.makeDecision(request, userId);

                return new ResponseEntity<>(response, HttpStatus.OK);
        }

        @GetMapping("/{id}/status")
        public ResponseEntity<String> getRequestStatus(
                        @PathVariable("id") String requestId) {
                return ResponseEntity.ok(
                                String.format(
                                                "{\"message\":\"Request %s status check not yet "
                                                                + "implemented\"}",
                                                requestId));
        }
}