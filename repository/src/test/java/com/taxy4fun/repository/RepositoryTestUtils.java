package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

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
        vehicle.setRoute(newRouteWithPoints());
        return vehicle;
    }

    static Route newRoute() {
        final Route route = new Route();
        return route;
    }

    static Route newRouteWithPoints() {
        final Route route = new Route();
        route.setPoints(newPoints());
        return route;
    }

    static List<Point> newPoints() {
        final List<Point> points = new ArrayList<>();
        Point point = new Point(1L, 2L);
        point.setDatetime(newLocalDateTime());
        points.add(point);
        return points;
    }

    static LocalDateTime newLocalDateTime() {
        return LocalDateTime.of(newDate(), newTime());
    }

    private static LocalTime newTime() {
        final LocalTime time = LocalTime.of(14,30,25);
        return time;
    }

    private static LocalDate newDate() {
        final LocalDate date = LocalDate.of(2017,8,21);
        return date;
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
