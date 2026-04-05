package com.wipro.kong.kong.kafkasvc.service;

import com.example.kafkasvc.model.LlmResponseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class LlmResponseConsumer {

    private static final Logger log = LoggerFactory.getLogger(LlmResponseConsumer.class);

    @KafkaListener(
            topics = "${app.kafka.response-topic}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(LlmResponseEvent event, Acknowledgment acknowledgment) {
        try {
            log.info("Consumed response requestId={} model={} status={}",
                    event.getRequestId(),
                    event.getModelName(),
                    event.getStatus());

// TODO:
            // 1. Save response to DB
            // 2. Aggregate by requestId
            // 3. Send grouped responses to Pegasus
            // 4. Update request status

            acknowledgment.acknowledge();
        } catch (Exception e) {
            log.error("Error while processing requestId={}", event.getRequestId(), e);
            throw e;
        }
    }
}