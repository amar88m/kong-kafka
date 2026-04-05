package com.wipro.kong.kong.kafkasvc.model;

import jakarta.validation.constraints.NotBlank;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public class PromptEvent {

    private String requestId = UUID.randomUUID().toString();

    @NotBlank
    private String prompt;

    private String sourceAgent;
    private Instant timestamp = Instant.now();
    private List<String> expectedModels;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getSourceAgent() {
        return sourceAgent;
    }

    public void setSourceAgent(String sourceAgent) {
        this.sourceAgent = sourceAgent;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public List<String> getExpectedModels() {
        return expectedModels;
    }

    public void setExpectedModels(List<String> expectedModels) {
        this.expectedModels = expectedModels;
    }
}