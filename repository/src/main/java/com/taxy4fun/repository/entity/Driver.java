package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mvillafuertem on 9/1/17.
 */
@Entity
public class Driver extends Person {

    @Id
    @GeneratedValue
    private Long id;


}
