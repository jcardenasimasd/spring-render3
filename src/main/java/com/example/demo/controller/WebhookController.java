package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.WebHookEvent;
import com.example.demo.repository.WebhookEventRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Autowired
    private WebhookEventRepository repository;

    @PostMapping
    public ResponseEntity<String> handleWebhook(@RequestBody Map<String, Object> event) {
        // Crear una nueva entidad y guardar el evento
        WebHookEvent webhookEvent = new WebHookEvent();
        webhookEvent.setFecha(LocalDateTime.now());
        webhookEvent.setBody(event.toString());

        repository.save(webhookEvent);

        return ResponseEntity.ok("Received");
    }

    @GetMapping("/events")
    public ResponseEntity<List<WebHookEvent>> listAllEvents() {
        List<WebHookEvent> events = repository.findAll();
        return ResponseEntity.ok(events);
    }
}