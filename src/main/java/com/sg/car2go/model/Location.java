package com.sg.car2go.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "location")
public class Location implements Serializable {
    @Id
    @GeneratedValue(generator = "location_generator")
    @SequenceGenerator(
            name = "location_generator",
            sequenceName = "location_sequence",
            initialValue = 1005
    )
    private Long id;

    @NotNull
    @Size(min = 3, max = 255)
    @Column(name = "street_address")
    private String streetAddress;

    @NotNull
    @Size(min = 3, max = 50)
    private String city;

    @NotNull
    @Size(min = 3, max = 50)
    private String state;

    @NotNull
    @Size(min = 3, max = 50)
    private String country;

    @NotNull
    @Size(min = 3, max = 50)
    private String zip;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
