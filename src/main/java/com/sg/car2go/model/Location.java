package com.sg.car2go.model;

import javax.persistence.*;

public class Location {
    @Id
    @GeneratedValue(generator = "location_generator")
    @SequenceGenerator(
            name = "location_generator",
            sequenceName = "location_sequence",
            initialValue = 1000
    )
    private Long id;

}
