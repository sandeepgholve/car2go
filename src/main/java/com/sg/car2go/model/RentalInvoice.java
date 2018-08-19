package com.sg.car2go.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "rental_invoice")
public class RentalInvoice implements Serializable {
    @Id
    @GeneratedValue(generator = "rental_invoice_generator")
    @SequenceGenerator(
            name = "rental_invoice_generator",
            sequenceName = "rental_invoice_sequence",
            initialValue = 1000
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "rental_id")
    private Rental rental;

    @NotNull
    @Column(name = "car_rent")
    private BigDecimal carRent;

    @NotNull
    @Column(name = "equipment_rent_total")
    private BigDecimal equipmentRentalTotal;

    @NotNull
    @Column(name = "insurance_cost")
    private BigDecimal insuranceCost;

    @NotNull
    @Column(name = "service_tax")
    private BigDecimal serviceTax;

    @NotNull
    @Column(name = "VAT")
    private BigDecimal VAT;

    @NotNull
    @Column(name = "total_amount_payable")
    private BigDecimal totalAmount;

    @NotNull
    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @NotNull
    @Column(name = "net_amount_payable")
    private BigDecimal netAmount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rental getRental() {
        return rental;
    }

    public void setRental(Rental rental) {
        this.rental = rental;
    }

    public BigDecimal getCarRent() {
        return carRent;
    }

    public void setCarRent(BigDecimal carRent) {
        this.carRent = carRent;
    }

    public BigDecimal getEquipmentRentalTotal() {
        return equipmentRentalTotal;
    }

    public void setEquipmentRentalTotal(BigDecimal equipmentRentalTotal) {
        this.equipmentRentalTotal = equipmentRentalTotal;
    }

    public BigDecimal getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(BigDecimal insuranceCost) {
        this.insuranceCost = insuranceCost;
    }

    public BigDecimal getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(BigDecimal serviceTax) {
        this.serviceTax = serviceTax;
    }

    public BigDecimal getVAT() {
        return VAT;
    }

    public void setVAT(BigDecimal VAT) {
        this.VAT = VAT;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(BigDecimal netAmount) {
        this.netAmount = netAmount;
    }
}
