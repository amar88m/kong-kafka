package com.wipro.kong.kafka.model;

public class PromptEvent {

    private String promptId;
    private String promptText;

    public PromptEvent() {
    }

    public PromptEvent(String promptId, String promptText) {
        this.promptId = promptId;
        this.promptText = promptText;
    }

    public String getPromptId() {
        return promptId;
    }

    public void setPromptId(String promptId) {
        this.promptId = promptId;
    }

    public String getPromptText() {
        return promptText;
    }

    public void setPromptText(String promptText) {
        this.promptText = promptText;
    }
}