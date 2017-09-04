package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by mvillafuertem on 02/09/2017.
 */
@Entity
public class Payment {

    @Id
    @GeneratedValue
    private Long id;
    private Long account;

    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public Long getAccount() {
        return account;
    }

    public void setAccount(final Long account) {
        this.account = account;
    }
}
