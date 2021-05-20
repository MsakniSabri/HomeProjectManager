package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "conversation")
public class Conversation {

    @Id
    @GeneratedValue
    private Long conversation_id;

    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private Person person;

    /*@ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private Person secondPerson;*/

    @OneToMany( targetEntity=Message.class, mappedBy="conversation" )
    private List<Message> messages = new ArrayList<>();
}
