package com.sg.car2go.model;

import javax.persistence.*;

public class CarEquipment {
    @Id
    @GeneratedValue(generator = "car_equipment_generator")
    @SequenceGenerator(
            name = "car_equipment_generator",
            sequenceName = "car_equipment_sequence",
            initialValue = 1000
    )
    private Long id;

}
