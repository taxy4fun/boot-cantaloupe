package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne(cascade = CascadeType.ALL)
    private Journey journey;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(final List<Point> points) {
        if (points != null) {
            this.points = points;
        }
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("points", points)
                .toString();
    }
}
