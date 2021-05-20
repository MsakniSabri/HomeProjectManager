package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "housing")
public class Housing {

    @Id
    @GeneratedValue
    private long housing_id;

    private String title;

    private String address;

    private int livingSpace;

    private String description;

    private Boolean available;

    @ManyToOne
    @JoinColumn(name="person_id", nullable = false)
    private Person person;

    public Housing(Person person) {
        this.person = person;
    }
    @OneToMany( targetEntity=Constraint.class, mappedBy="housing" )
    private List<Constraint> constraints = new ArrayList<>();

    @OneToMany( targetEntity=Image.class, mappedBy="housing" )
    private List<Image> images = new ArrayList<>();
}
