package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Route;
import com.taxy4fun.repository.entity.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.stream.Stream;

import static com.taxy4fun.repository.RepositoryTestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mvillafuertem on 8/29/17.
 */
@SpringBootTest(classes = VehicleRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class VehicleRepositoryTest {

    @Autowired
    private VehicleRepository repository;

    @Before
    public void setUp() throws Exception {
        assertThat(repository).isNotNull();
    }

    @Test
    public void create() {

        /*
            Verificamos que todavia ¡NO!
            hemos persistido la entidad
         */
        final Vehicle vehicle = newVehicle();
        assertThat(vehicle.getId()).isNull();

        /*
            Probamos el repository y
            verificamos que ha persistido
         */
        final Vehicle entity = this.repository.save(vehicle);
        assertThat(entity.getId()).isNotNull();
        assertThat(entity.getBrand()).isEqualTo(BRAND_AUDI);
        assertThat(entity.getPlate()).isEqualTo(PLATE_AUDI);

        /*
            Verificamos que se ha creado
            la asociación Driver
         */
        assertThat(entity.getDriver()).isNotNull();
        assertThat(entity.getDriver().getFirstname()).isEqualTo(DRIVER_NAME);
    }

    @Test
    public void delete() {

        final Vehicle vehicle = newVehicle();
        assertThat(vehicle.getId()).isNull();

        final Vehicle vehicleSave = this.repository.save(vehicle);
        final Long initialCount = this.repository.count();
        assertThat(vehicleSave.getId()).isNotNull();
        final Long id = vehicleSave.getId();

        this.repository.delete(id);

        assertThat(this.repository.findOne(id)).isNull();
        assertThat(1L).isEqualTo(initialCount - this.repository.count());
    }

    @Test
    public void findByPlate() {

        /*
            Verificamos que todavia ¡NO!
            hemos persistido la entidad
         */
        Vehicle vehicle = newVehicle();
        assertThat(vehicle.getId()).isNull();

        /*
            Probamos el repository y
            verificamos que ha persistido
         */
        final Vehicle entity = this.repository.save(vehicle);
        assertThat(entity.getId()).isNotNull();

        /*
            Buscamos la entidad por uno
            de sus atributos
         */
        final Vehicle entityFound = this.repository.findByPlate(PLATE_AUDI);
        assertThat(entityFound).isNotNull();
        assertThat(entityFound.getPlate()).isEqualTo(PLATE_AUDI);
    }

    @Test
    public void findByBrand() {

        final Vehicle vehicle = newVehicle();
        assertThat(vehicle.getId()).isNull();

        final Vehicle vehicleSave = this.repository.save(vehicle);
        assertThat(vehicleSave.getId()).isNotNull();

        Vehicle vehicleFound = this.repository.findByBrand(BRAND_AUDI);
        assertThat(vehicleFound).isNotNull();
        assertThat(vehicleFound.getBrand()).isEqualTo(BRAND_AUDI);
    }

    @Test
    public void findByDriverEin() {

        final Vehicle vehicleSaved = this.repository.save(newVehicle());

        final Long driverEin = vehicleSaved.getDriver().getEin();
        assertThat(driverEin).isNotNull();
        final Stream<Vehicle> vehicleFound = this.repository.findByDriverEin(driverEin);
        final Optional<Vehicle> first = vehicleFound.findFirst();
        assertThat(first.isPresent());
        assertThat(first.get().getDriver().getEin()).isEqualTo(driverEin);
    }
}