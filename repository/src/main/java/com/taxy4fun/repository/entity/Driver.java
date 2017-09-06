package com.taxy4fun.repository.entity;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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

    // Associations
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

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("id", id)
                .append("ein", ein)
                .append("license", license)
                .append("profile", profile)
                .toString();
    }
}
