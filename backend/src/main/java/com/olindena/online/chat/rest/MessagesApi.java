package com.olindena.online.chat.rest;

import com.olindena.online.chat.MessageRepository;
import com.olindena.online.chat.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesApi {

    private static final Logger log = LoggerFactory.getLogger(MessagesApi.class);

    private final MessageRepository messageRepository;

    public MessagesApi(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @GetMapping("/messages")
    public List<MessageDto> getMessages() {
        return messageRepository.listAll();
    }

}
