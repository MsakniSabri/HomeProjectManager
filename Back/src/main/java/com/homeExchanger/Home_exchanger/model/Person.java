package com.homeExchanger.Home_exchanger.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email address")
    private String email_address;

    @Column(name = "phone number")
    private String phone_number;

    @Column(name = "img address")
    private String img_address;

    @Column(name = "general information")
    private String general_information;

    @Column(name = "admin")
    private boolean isAdmin;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "housing")
    @JoinColumn(name = "housing_id")
    private List<Housing> housings;


}
