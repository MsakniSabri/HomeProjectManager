package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class House {

    @Id
    @GeneratedValue
    private String id;
    private String title;
    private String description;

    @ManyToOne
    private User user;
}
