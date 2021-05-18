package com.homeExchanger.Home_exchanger.model;

import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    @OneToMany
    private List<House> house;
}
