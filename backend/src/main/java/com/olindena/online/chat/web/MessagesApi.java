package com.olindena.online.chat.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MessagesApi {

    private final List<Message> messages = new ArrayList<>();

    @GetMapping("messages")
    public List<Message> getMessages() {
        return messages;
    }

    @PostMapping("messages")
    public void saveMessage(Message message) {
        messages.add(message);
    }

    public record Message(String content, String author, Instant timestamp) {
    }
}
