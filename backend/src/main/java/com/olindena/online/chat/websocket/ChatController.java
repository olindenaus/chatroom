package com.olindena.online.chat.websocket;

import com.olindena.online.chat.dto.MessageDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public MessageDto send(MessageDto messageDto) {
        return messageDto;
    }
}
