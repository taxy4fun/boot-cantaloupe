package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    @ElementCollection
    private List<Point> points = new ArrayList<>();

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(final List<Point> points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("points", points)
                .toString();
    }
}
