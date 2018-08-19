package com.sg.car2go.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
public class Car implements Serializable {
    @Id
    @GeneratedValue(generator = "car_generator")
    @SequenceGenerator(
            name = "car_generator",
            sequenceName = "car_sequence",
            initialValue = 1005
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_category_id")
    @JsonIgnore
    private CarCategory category;

    @NotBlank
    @Size(min = 3, max = 100)
    private String brand;

    @NotBlank
    @Size(min = 3, max = 100)
    private String model;

    @NotBlank
    @Size(min = 3, max = 100)
    private String color;

    @NotNull
    private Integer mileage;

    @NotNull
    @Column(name = "production_year", columnDefinition = "int")
    private Integer productionYear;

    @ManyToOne
    @JoinColumn(name = "current_location_id")
    @JsonIgnore
    private Location currentLocation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarCategory getCategory() {
        return category;
    }

    public void setCategory(CarCategory category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public void setProductionYear(Integer productionYear) {
        this.productionYear = productionYear;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
