package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue
    private Long message_id;

    private String message;

    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name="conversation_id", nullable = false)
    private Conversation conversation;

    public Message(Conversation conversation) {
        this.conversation = conversation;
    }
}
