package com.olindena.online.chat.dto;

import java.time.Instant;

public record MessageDto(String text, String nickname, Instant createdAt) {
}
