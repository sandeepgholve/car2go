package com.sg.car2go.model;

import javax.persistence.*;

public class Reservation {
    @Id
    @GeneratedValue(generator = "reservation_generator")
    @SequenceGenerator(
            name = "reservation_generator",
            sequenceName = "reservation_sequence",
            initialValue = 1000
    )
    private Long id;

}
