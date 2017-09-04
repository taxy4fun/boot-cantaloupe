package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Driver;
import com.taxy4fun.repository.entity.Person;
import com.taxy4fun.repository.entity.Profile;
import com.taxy4fun.repository.entity.Vehicle;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by mvillafuertem on 31/08/2017.
 */
final class RepositoryTestUtils {

    static final String BRAND_AUDI = "Audi";
    static final String PLATE_AUDI = "1234ABC";
    static final String DRIVER_NAME = "Conductor";
    static final String DRIVER_LASTNAME = "Bueno";
    static final String PERSON = "Person";

    static Person newPerson() {

        final Person person = new Person();
        person.setIc(1234567890L);
        person.setFirstname(PERSON);
        person.setLastname(PERSON);
        person.setBirthdate(LocalDate.of(1900,10,30));
        person.setPhone(1234567890);

        person.setAddress("Calle de Madrid");
        person.setCity("Madrid");
        person.setPostalcode(123456);
        return person;
    }

    static Vehicle newVehicle() {

        final Vehicle vehicle = new Vehicle();
        vehicle.setPlate(PLATE_AUDI);
        vehicle.setBrand(BRAND_AUDI);
        vehicle.setDescription("A4 Black");
        vehicle.setDriver(newDriver());
        return vehicle;
    }

    static Driver newDriver() {

        final Driver driver = new Driver();
        driver.setIc(1234567890L);
        driver.setFirstname(DRIVER_NAME);
        driver.setLastname(DRIVER_LASTNAME);
        driver.setBirthdate(LocalDate.of(1900,10,30));

        driver.setEin(123456789L);
        driver.setProfile(newProfile());
        return driver;
    }

    static Profile newProfile() {

        final Profile profile = new Profile();
        return profile;
    }
}
