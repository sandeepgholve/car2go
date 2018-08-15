package com.sg.car2go.model;

import javax.persistence.*;

public class Rental {
    @Id
    @GeneratedValue(generator = "rental_generator")
    @SequenceGenerator(
            name = "rental_generator",
            sequenceName = "rental_sequence",
            initialValue = 1000
    )
    private Long id;

}
