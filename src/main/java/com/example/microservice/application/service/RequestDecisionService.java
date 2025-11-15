package com.example.microservice.application.service;

import com.example.microservice.application.dto.RequestDecisionRequestDTO;
import com.example.microservice.application.dto.RequestDecisionResponseDTO;

public interface RequestDecisionService {

    RequestDecisionResponseDTO makeDecision(
            RequestDecisionRequestDTO request,
            String userId);
}
