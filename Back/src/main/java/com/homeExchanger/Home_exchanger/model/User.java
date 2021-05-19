package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long user_id;

    private String name;

    private String surname;

    private String emailAddress;

    private String phoneNumber;

    private String profilePictureAddress;

    private String birthdate;

    private String globalInformation;

    private boolean isAdmin;

    private String password;
}
