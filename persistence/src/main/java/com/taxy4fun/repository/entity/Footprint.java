package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Embeddable
public class Footprint extends Point {

    private LocalDateTime time;

    public Footprint() {
    }

    public Footprint(final Double latitude, final Double longitude, final LocalDateTime time) {
        super(latitude, longitude);
        this.time = time;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(final LocalDateTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("point", super.toString())
                .append("time", time)
                .toString();
    }
}
