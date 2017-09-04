package com.taxy4fun.repository.entity;

import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Track {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime datetime;

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(final LocalDateTime datetime) {
        this.datetime = datetime;
    }
}
