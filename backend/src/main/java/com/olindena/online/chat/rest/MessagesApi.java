package com.olindena.online.chat.rest;

import com.olindena.online.chat.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessagesApi {

    private static final Logger log = LoggerFactory.getLogger(MessagesApi.class);
    private final List<MessageDto> messages = new ArrayList<>();

    @GetMapping("/messages")
    public List<MessageDto> getMessages() {
        return messages;
    }

    @MessageMapping("/app/chat")
    @SendTo("/topic/messages")
    public void saveMessage(MessageDto message) {
        log.info("Received message: {}", message);
        messages.add(message);
    }

//    @MessageMapping
//    @SendTo("/topic/messages")
//    public MessageDto message(MessageDto messageDto) {
//        return messageDto;
//    }

}
