package com.sg.car2go.model;

import javax.persistence.*;

public class Equipment {
    @Id
    @GeneratedValue(generator = "equipment_generator")
    @SequenceGenerator(
            name = "equipment_generator",
            sequenceName = "equipment_sequence",
            initialValue = 1000
    )
    private Long id;
}
