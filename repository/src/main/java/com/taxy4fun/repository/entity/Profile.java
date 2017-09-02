package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Profile {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String password;
    private Integer rank;
}
