package com.homeExchanger.Home_exchanger.model;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "image")
public class Image {

    @Id
    @GeneratedValue
    private Long image_id;

    private String imageAddress;

    @ManyToOne
    @JoinColumn(name="housing_id", nullable = false)
    private Housing housing;
}
