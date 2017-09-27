package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Journey {

    @Id
    @GeneratedValue
    private Long id;

    //TODO type Point
    private String origin;
    private String destiny;

    //TODO ManyToOne Driver
    //TODO OneToOne pickup Route
    //TODO OneToOne destination Route

    // Associations
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Customer customer;
    @ManyToOne(cascade = CascadeType.PERSIST)
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
    

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("origin", origin)
                .append("destiny", destiny)
                .append("customer", customer)
                .append("vehicle", vehicle)
                .toString();
    }
}
