package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Embeddable;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Embeddable
public class Point {

    private Double latitude;
    private Double longitude;

    public Point() {
    }

    public Point(final Double latitude, final Double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(final Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(final Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .toString();
    }
}
