package com.springuers.taxy4fun.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by manuelmola on 31/08/17.
 */
public class DriverCreateRequest implements Serializable {

    //Driver
    private boolean available;
    private String driverLicense;
    private Date expirationDate;

    //User
    private String id;
    private String password;

    //Person
    private String name;
    private String surname;
    private String email;
    private Integer phone;
    private String postalCode;
    private String address;
    private String city;

    public DriverCreateRequest() {}

    public DriverCreateRequest(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
                .append("available", available)
                .append("driverLicense", driverLicense)
                .append("expirationDate", expirationDate)
                .append("id", id)
                .append("password", password)
                .append("name", name)
                .append("surname", surname)
                .append("email", email)
                .append("phone", phone)
                .append("postalCode", postalCode)
                .append("address", address)
                .append("city", city)
                .toString();
    }
}
