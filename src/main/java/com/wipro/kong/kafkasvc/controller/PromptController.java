package com.wipro.kong.kong.kafkasvc.controller;

import com.example.kafkasvc.model.PromptEvent;
import com.example.kafkasvc.service.PromptProducerService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prompts")
public class PromptController {

    private final PromptProducerService producerService;

    public PromptController(PromptProducerService producerService) {
        this.producerService = producerService;
    }

    @PostMapping
    public ResponseEntity<PromptEvent> publish(@Valid @RequestBody PromptEvent event) {
        producerService.publishPrompt(event);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK");
    }
}