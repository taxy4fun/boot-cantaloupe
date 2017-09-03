package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Track {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime datetime;
}
