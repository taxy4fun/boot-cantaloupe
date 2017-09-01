package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by cmartin on 23/06/2017.
 */
@Entity
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    private Long ic;

    private String firstname;

    private String lastname;

    private Integer age;

    private Boolean active;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIc() {
        return ic;
    }

    public void setIc(final Long ic) {
        this.ic = ic;
    }

    @Override
    public String toString() {
        return new org.apache.commons.lang3.builder.ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("firstname", firstname)
                .append("lastname", lastname)
                .append("age", age)
                .append("active", active)
                .toString();
    }

}