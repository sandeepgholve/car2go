package com.sg.car2go.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(generator = "car_generator")
    @SequenceGenerator(
            name = "car_generator",
            sequenceName = "car_sequence",
            initialValue = 1000
    )
    private Long id;
    private String brand;
    private String color;
    private Integer mileage;
    private String model;
    private Integer productionYear;
}
