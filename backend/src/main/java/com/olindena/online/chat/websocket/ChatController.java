package com.olindena.online.chat.websocket;

import com.olindena.online.chat.MessageRepository;
import com.olindena.online.chat.dto.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final MessageRepository messageRepository;

    public ChatController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDto send(MessageDto messageDto) {
        messageRepository.save(messageDto);
        return messageDto;
    }
}
