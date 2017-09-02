package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Journey {

    @Id
    @GeneratedValue
    private Long id;
    private String origin;
    private String destiny;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Vehicle vehicle;
}
