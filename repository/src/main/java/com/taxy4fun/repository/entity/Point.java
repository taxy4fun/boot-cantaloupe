package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Point {

    @Id
    @GeneratedValue
    private Long id;
    private Long latitude;
    private Long longitude;

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(final Long latitude) {
        this.latitude = latitude;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(final Long longitude) {
        this.longitude = longitude;
    }
}
