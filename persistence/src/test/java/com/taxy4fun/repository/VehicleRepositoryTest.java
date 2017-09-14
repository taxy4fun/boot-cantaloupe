package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.stream.Stream;

import static com.taxy4fun.repository.RepositoryTestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mvillafuertem on 8/29/17.
 */
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

        final Vehicle entity = this.createVehicle();

        assertThat(entity.getBrand()).isEqualTo(BRAND_AUDI);
        assertThat(entity.getPlate()).isEqualTo(PLATE_AUDI);

        /*
            Verificamos que se ha creado la asociación Driver
         */
        assertThat(entity.getDriver()).isNotNull();
        assertThat(entity.getDriver().getFirstname()).isEqualTo(DRIVER_NAME);
    }


    @Test
    public void delete() {

        final Vehicle entity = this.createVehicle();

        final Long initialCount = this.repository.count();
        assertThat(entity.getId()).isNotNull();
        final Long id = entity.getId();

        this.repository.delete(id);

        assertThat(this.repository.findOne(id)).isNull();
        assertThat(1L).isEqualTo(initialCount - this.repository.count());
    }

    @Test
    public void findByPlate() {

        final Vehicle entity = this.createVehicle();

        /*
            Buscamos la entidad por uno de sus atributos
         */
        final Vehicle entityFound = this.repository.findByPlate(PLATE_AUDI);
        assertThat(entityFound).isNotNull();
        assertThat(entityFound.getPlate()).isEqualTo(PLATE_AUDI);
    }

    @Test
    public void findByBrand() {

        this.createVehicle();

        Vehicle vehicleFound = this.repository.findByBrand(BRAND_AUDI);
        assertThat(vehicleFound).isNotNull();
        System.out.println(vehicleFound.toString());
        assertThat(vehicleFound.getBrand()).isEqualTo(BRAND_AUDI);
    }

    @Test
    public void findByDriverEin() {

        final Vehicle entity = this.createVehicle();

        final Long driverEin = entity.getDriver().getEin();
        assertThat(driverEin).isNotNull();

        final Stream<Vehicle> vehicleFound = this.repository.findByDriverEin(driverEin);
        final Optional<Vehicle> first = vehicleFound.findFirst();
        System.out.println(first.toString());
        assertThat(first.isPresent());
        assertThat(first.get().getDriver().getEin()).isEqualTo(driverEin);
    }


    private Vehicle createVehicle() {
        /*
            Verificamos que todavia ¡NO! hemos persistido la entidad
         */
        final Vehicle bean = newVehicle();
        assertThat(bean.getId()).isNull();

        /*
            Probamos el repository y verificamos que ha persistido
         */
        final Vehicle entity = this.repository.save(bean);
        assertThat(entity.getId()).isNotNull();

        return entity;
    }

}