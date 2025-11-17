package com.olindena.online.chat;

import com.olindena.online.chat.dto.MessageDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MessageCache {
    private final List<MessageDto> messages = new ArrayList<>();

    public List<MessageDto> listAll() {
        return messages;
    }

    public void save(MessageDto messageDto) {
        messages.add(messageDto);
    }
}
