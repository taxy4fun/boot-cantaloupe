package com.taxy4fun.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by mvillafuertem on 01/09/2017.
 */
@Entity
public class Customer extends Person {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Payment payment;


    public Long getId() {
        return id;
    }

    private void setId(final Long id) {
        this.id = id;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(final Payment payment) {
        this.payment = payment;
    }
}
