package com.olindena.online.chat.websocket;

import com.olindena.online.chat.MessageCache;
import com.olindena.online.chat.db.MappedMessage;
import com.olindena.online.chat.db.MessagesRepository;
import com.olindena.online.chat.dto.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private final MessageCache messageCache;
    private final MessagesRepository messagesRepository;

    public ChatController(MessageCache messageCache, MessagesRepository messagesRepository) {
        this.messageCache = messageCache;
        this.messagesRepository = messagesRepository;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDto send(MessageDto messageDto) {
        messageCache.save(messageDto);
        messagesRepository.save(new MappedMessage(
            messageDto.nickname(),
            messageDto.text(),
            messageDto.createdAt().toEpochMilli()));
        return messageDto;
    }
}
