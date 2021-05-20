package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue
    private Long person_id;

    private String name;

    private String surname;

    private String emailAddress;

    private String phoneNumber;

    private String profilePictureAddress;

    private String birthdate;

    private String globalInformation;

    private boolean isAdmin;

    private String password;

    @OneToMany( targetEntity=Housing.class, mappedBy="person" )
    private List<Housing> housings = new ArrayList<>();

    @OneToMany( targetEntity=Conversation.class, mappedBy="person" )
    private List<Conversation> conversations = new ArrayList<>();
}
