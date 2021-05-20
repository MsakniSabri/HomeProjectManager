package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "constraint")
public class Constraint {

    @Id
    @GeneratedValue
    private Long constraint_id;

    private String constraint;

    @ManyToOne
    @JoinColumn(name="housing_id", nullable = false)
    private Housing housing;
}
