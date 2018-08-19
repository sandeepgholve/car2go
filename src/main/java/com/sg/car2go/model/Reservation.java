package com.sg.car2go.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {
    @Id
    @GeneratedValue(generator = "reservation_generator")
    @SequenceGenerator(
            name = "reservation_generator",
            sequenceName = "reservation_sequence",
            initialValue = 1000
    )
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pick_up_location_id")
    private Location pickUpLocation;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "drop_off_location_id")
    private Location dropOffLocation;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "car_category_id")
    private CarCategory carCategory;

    @NotNull
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "reservation_equipment",
        joinColumns = @JoinColumn(name = "reservation_id"),
        inverseJoinColumns = @JoinColumn(name = "equipment_category_id"))
    private List<EquipmentCategory> equipments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(Location pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public Location getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(Location dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public CarCategory getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(CarCategory carCategory) {
        this.carCategory = carCategory;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<EquipmentCategory> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentCategory> equipments) {
        this.equipments = equipments;
    }
}
