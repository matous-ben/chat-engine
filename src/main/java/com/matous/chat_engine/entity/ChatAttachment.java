package com.matous.chat_engine.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "chat_attachments")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class ChatAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attachmentId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_id", nullable = false)
    private ChatMember sender;

    @Column(name = "filename", nullable = false)
    private String filename;

    @Column(name = "data", nullable = false, columnDefinition = "BYTEA")
    private byte[] data;

    @Column(name = "sent_at", nullable = false,
            columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private Instant sentAt;
}
