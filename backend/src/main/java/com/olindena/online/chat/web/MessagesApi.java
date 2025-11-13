package com.olindena.online.chat.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessagesApi {

    private static final Logger log = LoggerFactory.getLogger(MessagesApi.class);
    private final List<Message> messages = new ArrayList<>();

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messages;
    }

    @PostMapping("/messages")
    public void saveMessage(Message message) {
        log.info("Received message: {}", message);
        messages.add(message);
    }

    public record Message(String content, String author, Instant timestamp) {
    }
}
