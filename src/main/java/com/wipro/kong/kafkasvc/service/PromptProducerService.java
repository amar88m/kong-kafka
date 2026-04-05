package com.wipro.kong.kong.kafkasvc.service;

import com.example.kafkasvc.model.PromptEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PromptProducerService {

    private static final Logger log = LoggerFactory.getLogger(PromptProducerService.class);

    private final KafkaTemplate<String, PromptEvent> kafkaTemplate;

    @Value("${app.kafka.prompt-topic}")
    private String promptTopic;

    public PromptProducerService(KafkaTemplate<String, PromptEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishPrompt(PromptEvent event) {
        kafkaTemplate.send(promptTopic, event.getRequestId(), event)
                .whenComplete((result, ex) -> {
                    if (ex != null) {
                        log.error("Failed to publish prompt for requestId={}", event.getRequestId(), ex);
                    } else {
                        log.info("Published prompt requestId={} topic={} partition={} offset={}",
                                event.getRequestId(),
                                result.getRecordMetadata().topic(),
                                result.getRecordMetadata().partition(),
                                result.getRecordMetadata().offset());
                    }
                });
    }
}