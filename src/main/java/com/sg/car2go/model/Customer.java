package com.sg.car2go.model;

import javax.persistence.*;

public class Customer {
    @Id
    @GeneratedValue(generator = "customer_generator")
    @SequenceGenerator(
            name = "customer_generator",
            sequenceName = "customer_sequence",
            initialValue = 1000
    )
    private Long id;

}
