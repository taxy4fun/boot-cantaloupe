package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Driver;
import com.taxy4fun.repository.entity.Vehicle;

/**
 * Created by mvillafuertem on 31/08/2017.
 */
final class RepositoryTestUtils {

    static final String BRAND_AUDI = "Audi";
    static final String PLATE_AUDI = "1234ABC";
    static final String DRIVER_NAME = "Conductor";
    static final String DRIVER_LASTNAME = "Bueno";
    static final int AGE = 35;

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
        driver.setAge(AGE);
        return driver;
    }
}
