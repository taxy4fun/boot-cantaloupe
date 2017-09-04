package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }
}
