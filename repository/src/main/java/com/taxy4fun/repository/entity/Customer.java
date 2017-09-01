package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mvillafuertem on 01/09/2017.
 */
@Entity
public class Customer extends Person {

    @Id
    @GeneratedValue
    private Long id;
}
