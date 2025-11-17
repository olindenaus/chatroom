package com.olindena.online.chat.rest;

import com.olindena.online.chat.MessageCache;
import com.olindena.online.chat.dto.MessageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessagesApi {

    private final MessageCache messageCache;

    public MessagesApi(MessageCache messageCache) {
        this.messageCache = messageCache;
    }

    @GetMapping("/messages")
    public List<MessageDto> getMessages() {
        return messageCache.listAll();
    }

}
