package com.matous.chat_engine.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
        name = "chat_members",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {"chat_id", "username"}
        )
)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder

public class ChatMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    // chat muze mit vice clenu, clen patri do jednoho konretniho chatu
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @Column(name = "username", nullable = false)
    private String username;
}
