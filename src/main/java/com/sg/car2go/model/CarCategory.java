package com.sg.car2go.model;

import javax.persistence.*;

public class CarCategory {
    @Id
    @GeneratedValue(generator = "car_category_generator")
    @SequenceGenerator(
            name = "car_category_generator",
            sequenceName = "car_category_sequence",
            initialValue = 1000
    )
    private Long id;

}
