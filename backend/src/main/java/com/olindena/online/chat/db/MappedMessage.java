package com.olindena.online.chat.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "messages")
public class MappedMessage {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String author;
    private String content;
    private Long createdAt;

    protected MappedMessage() {

    }

    public MappedMessage(String author, String content, Long createdAt) {
        this.author = author;
        this.content = content;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }
    public String getContent() {
        return content;
    }
    public Long getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "MappedMessage{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
