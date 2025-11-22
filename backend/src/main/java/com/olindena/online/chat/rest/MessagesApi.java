package com.olindena.online.chat.rest;

import com.olindena.online.chat.db.MappedMessage;
import com.olindena.online.chat.db.MessagesRepository;
import com.olindena.online.chat.dto.MessageDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Collections;
import java.util.List;

@RestController
public class MessagesApi {

    private final MessagesRepository messagesRepository;

    public MessagesApi(MessagesRepository messagesRepository) {
        this.messagesRepository = messagesRepository;
    }

    @GetMapping("/messages")
    public List<MessageDto> getMessages() {
        return messagesRepository.findTop10ByOrderByCreatedAtDesc()
                .stream()
                .map(this::toDto)
                .toList();
    }

    private MessageDto toDto(MappedMessage message) {
        return new MessageDto(
                message.getContent(),
                message.getAuthor(),
                Instant.ofEpochMilli(message.getCreatedAt()));
    }

}
