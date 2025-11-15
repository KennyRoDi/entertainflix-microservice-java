package com.example.microservice.infrastructure.queue.publisher;

import com.azure.storage.queue.QueueClient;
import com.example.microservice.domain.model.RequestDecision;
import com.example.microservice.domain.port.QueuePublisher;
import com.example.microservice.infrastructure.queue.schema.DecisionEventSchema;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class AzureQueuePublisherImpl implements QueuePublisher {
    private static final Logger logger = LoggerFactory.getLogger(AzureQueuePublisherImpl.class);

    private final QueueClient queueClient;
    private final ObjectMapper objectMapper;

    @Autowired
    public AzureQueuePublisherImpl(
            QueueClient queueClient,
            ObjectMapper objectMapper) {
        this.queueClient = queueClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public void publishDecision(RequestDecision decision) {
        try {
            DecisionEventSchema eventSchema = new DecisionEventSchema(
                    decision.getRequestId(),
                    decision.getOfertante(),
                    decision.getCliente(),
                    decision.getStatus().toString(),
                    decision.getDecidedAt().format(
                            DateTimeFormatter.ISO_DATE_TIME),
                    decision.getRazon());

            String messageJson = objectMapper.writeValueAsString(eventSchema);

            queueClient.sendMessage(messageJson);

            logger.info("✓ Message queued for request: {}",
                    decision.getRequestId());

        } catch (Exception e) {
            logger.error("✗ Failed to publish decision to queue: {}",
                    e.getMessage(), e);
            // Don't throw - queue failure shouldn't fail the API
            // In production, implement retry logic here
        }
    }

    @Override
    @Async
    public void publishDecisionAsync(RequestDecision decision) {
        publishDecision(decision);
    }
}