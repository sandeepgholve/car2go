package com.sg.car2go.model;

import javax.persistence.*;

public class RentalInvoice {
    @Id
    @GeneratedValue(generator = "rental_invoice_generator")
    @SequenceGenerator(
            name = "rental_invoice_generator",
            sequenceName = "rental_invoice_sequence",
            initialValue = 1000
    )
    private Long id;

}
