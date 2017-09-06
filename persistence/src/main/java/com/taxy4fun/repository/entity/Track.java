package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.time.LocalDateTime;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
public class Track {

    private LocalDateTime datetime;

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(final LocalDateTime datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("datetime", datetime)
                .toString();
    }
}
