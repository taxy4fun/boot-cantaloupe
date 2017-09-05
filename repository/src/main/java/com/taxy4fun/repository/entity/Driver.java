package com.taxy4fun.repository.entity;

import javax.persistence.*;

/**
 * Created by mvillafuertem on 9/1/17.
 */
@Entity
public class Driver extends Person {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * Employer Identification Number (EIN)
     */
    private Long ein;

    /**
     * Driver License
     */
    private Long license;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Long getEin() {
        return ein;
    }

    public void setEin(Long ein) {
        this.ein = ein;
    }

    public Long getLicense() {
        return license;
    }

    public void setLicense(Long license) {
        this.license = license;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
