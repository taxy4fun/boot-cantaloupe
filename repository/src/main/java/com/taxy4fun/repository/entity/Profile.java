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

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(final Integer rank) {
        this.rank = rank;
    }
}
