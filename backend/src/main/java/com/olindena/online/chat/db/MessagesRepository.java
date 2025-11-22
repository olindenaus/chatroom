package com.olindena.online.chat.db;

import com.olindena.online.chat.dto.MessageDto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessagesRepository extends CrudRepository<MappedMessage, Long> {

    MappedMessage findById(long id);

    List<MappedMessage> findTop10ByOrderByCreatedAtDesc();
}
