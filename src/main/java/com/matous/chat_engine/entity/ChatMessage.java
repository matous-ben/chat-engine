package com.matous.chat_engine.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "chat_messages")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private ChatMember sender;

    @Column(name = "message",  nullable = false, length = 1024)
    private String message;

    @Column(name = "sent_at", nullable = false,
            columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant sentAt;
}
