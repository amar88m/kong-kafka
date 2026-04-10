package com.wipro.kong.kafka.model;

public class LlmResponseEvent {

    private String promptId;
    private String responseText;

    public LlmResponseEvent() {
    }

    public LlmResponseEvent(String promptId, String responseText) {
        this.promptId = promptId;
        this.responseText = responseText;
    }

    public String getPromptId() {
        return promptId;
    }

    public void setPromptId(String promptId) {
        this.promptId = promptId;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }
}