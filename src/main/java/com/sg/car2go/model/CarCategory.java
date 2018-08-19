package com.sg.car2go.model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "car_category")
public class CarCategory implements Serializable {
    @Id
    @GeneratedValue(generator = "car_category_generator")
    @SequenceGenerator(
            name = "car_category_generator",
            sequenceName = "car_category_sequence",
            initialValue = 1005
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @Column(name = "rental_value", columnDefinition = "numeric")
    @Positive
    private BigDecimal rentalValue;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRentalValue() {
        return rentalValue;
    }

    public void setRentalValue(BigDecimal rentalValue) {
        this.rentalValue = rentalValue;
    }
}
