package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Embeddable;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Embeddable
public class Point extends Track {

    private Long latitude;
    private Long longitude;

    public Point() {
    }

    public Point(final Long latitude, final Long longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("latitude", latitude)
                .append("longitude", longitude).append("date", getDatetime())
                .toString();
    }
}
