package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue
    private Long conversation_id;
}
