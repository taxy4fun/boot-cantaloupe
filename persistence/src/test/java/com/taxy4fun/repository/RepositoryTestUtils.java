package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Customer;
import com.taxy4fun.repository.entity.Driver;
import com.taxy4fun.repository.entity.Journey;
import com.taxy4fun.repository.entity.Person;
import com.taxy4fun.repository.entity.Point;
import com.taxy4fun.repository.entity.Profile;
import com.taxy4fun.repository.entity.Route;
import com.taxy4fun.repository.entity.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvillafuertem on 31/08/2017.
 */
final class RepositoryTestUtils {

    public static final String BRAND_AUDI = "Audi";
    public static final String PLATE_AUDI = "1234ABC";
    public static final String DRIVER_NAME = "Conductor";
    public static final String DRIVER_LASTNAME = "Bueno";
    public static final String PERSON = "Person";
    public static final String PERSON_EMAIL = "first.last@taxy4fun.com";
    public static final long DRIVER_EIN = 123456789L;
    public static final long DRIVER_LICENSE = 12345678L;

    static Person newPerson() {

        final Person person = new Person();
        person.setIc(1234567890L);
        person.setFirstname(PERSON);
        person.setLastname(PERSON);
        person.setBirthdate(LocalDate.of(1900, 10, 30));
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
        point.setDatetime(newLocalDateTime(8, 0, 0));
        points.add(point);

        point = new Point(2L, 4L);
        point.setDatetime(newLocalDateTime(8, 0, 1));
        points.add(point);

        return points;
    }

    static LocalDateTime newLocalDateTime() {
        return LocalDateTime.of(newDate(), newTime());
    }

    static LocalDateTime newLocalDateTime(Integer hour, Integer minute, Integer second) {
        return LocalDateTime.of(newDate(), newTime());
    }

    private static LocalTime newTime() {
        final LocalTime time = newTime(14, 30, 25);
        return time;
    }

    private static LocalTime newTime(Integer hour, Integer minute, Integer second) {
        final LocalTime time = LocalTime.of(hour, minute, second);
        return time;
    }

    private static LocalDate newDate() {
        final LocalDate date = LocalDate.of(2017, 8, 21);
        return date;
    }


    static Driver newDriver() {

        final Driver driver = new Driver();
        driver.setIc(1234567890L);
        driver.setFirstname(DRIVER_NAME);
        driver.setLastname(DRIVER_LASTNAME);
        driver.setBirthdate(LocalDate.of(1980, 10, 30));
        driver.setLicense(DRIVER_LICENSE);

        driver.setEin(DRIVER_EIN);
        driver.setProfile(newProfile());

        return driver;
    }


    static Profile newProfile() {

        final Profile profile = new Profile();
        profile.setEmail(PERSON_EMAIL);
        return profile;
    }

    static Journey newJourney() {
        final Journey journey = new Journey();
        journey.setCustomer(newCustomer());
        journey.setVehicle(newVehicle());
        return journey;
    }

    static Customer newCustomer() {
        final Customer customer = new Customer();
        customer.setIc(1234567890L);
        customer.setFirstname("Cliente");
        customer.setLastname("Bueno");
        return customer;
    }
}
