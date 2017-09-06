package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by mvillafuertem on 8/29/17.
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private Long id;
    private String brand;
    private String description;
    private String photo;
    private String plate;

    // Associations
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Driver driver;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private Route route;

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(final String photo) {
        this.photo = photo;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(final String plate) {
        this.plate = plate;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(final Driver driver) {
        this.driver = driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(final Route route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("brand", brand)
                .append("description", description)
                .append("photo", photo)
                .append("plate", plate)
                .append("driver", driver)
                .append("route", route)
                .toString();
    }
}
