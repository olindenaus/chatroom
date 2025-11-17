package com.olindena.online.chat.db;

import org.springframework.data.repository.CrudRepository;

public interface MessagesRepository extends CrudRepository<MappedMessage, Long> {

    MappedMessage findById(long id);

}
