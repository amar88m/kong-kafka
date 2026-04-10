package com.wipro.kong.kafkasvc.service;

import com.wipro.kong.kafkasvc.model.LlmResponseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class LlmResponseConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(LlmResponseConsumer.class);

    @KafkaListener(
            topics = "${app.kafka.response-topic}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consume(
            LlmResponseEvent event,
            Acknowledgment acknowledgment
    ) {

        try {
            log.info(
                    "Consumed response | requestId={} | model={} | status={}",
                    event.getRequestId(),
                    event.getModelName(),
                    event.getStatus()
            );

            // TODO:
            // 1. Persist response
            // 2. Aggregate by requestId
            // 3. Send downstream event
            // 4. Update request status

            acknowledgment.acknowledge();

        } catch (Exception ex) {

            log.error(
                    "Failed processing response | requestId={}",
                    event != null ? event.getRequestId() : "unknown",
                    ex
            );

            // rethrow → Kafka retry / DLQ later
            throw ex;
        }
    }
}
``