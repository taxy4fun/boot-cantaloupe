package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Journey {

    @Id
    @GeneratedValue
    private Long id;
    private String origin;
    private String destiny;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(final String origin) {
        this.origin = origin;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(final String destiny) {
        this.destiny = destiny;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(final Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
