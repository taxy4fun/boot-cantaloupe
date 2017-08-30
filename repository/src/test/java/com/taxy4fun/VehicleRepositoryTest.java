package com.taxy4fun;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mvillafuertem on 8/29/17.
 */
@SpringBootTest(classes = VehicleRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class VehicleRepositoryTest {

    public static final String BRAND_AUDI = "Audi";
    public static final String PLATE_AUDI = "1234ABC";
    @Autowired
    private VehicleRepository repository;

    @Before
    public void setUp() throws Exception {
        assertThat(repository).isNotNull();
    }

    @Test
    public void create() {

        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(PLATE_AUDI);
        vehicle.setBrand(BRAND_AUDI);
        vehicle.setDescription("A4 Black");

        /*
            Verificamos que todavia ¡NO!
            hemos persistido la entidad
         */
        assertThat(vehicle.getId()).isNull();

        /*
            Probamos el repository
         */
        Vehicle entity = this.repository.save(vehicle);

        /*
            Verificamos que ha persistido
         */
        assertThat(entity.getId()).isNotNull();
        assertThat(entity.getBrand()).isEqualTo(BRAND_AUDI);
        assertThat(entity.getPlate()).isEqualTo(PLATE_AUDI);

    }

    @Test
    public void find() {

        Vehicle vehicle = new Vehicle();
        vehicle.setPlate(PLATE_AUDI);
        vehicle.setBrand(BRAND_AUDI);
        vehicle.setDescription("A4 Black");

        /*
            Verificamos que todavia ¡NO!
            hemos persistido la entidad
         */
        assertThat(vehicle.getId()).isNull();

        /*
            Probamos el repository
         */
        Vehicle entity = this.repository.save(vehicle);

        /*
            Verificamos que ha persistido
         */
        assertThat(entity.getId()).isNotNull();

        /*
            Buscamos la entidad por uno
            de sus atributos
         */
        Vehicle entityFound = this.repository.findByPlate(PLATE_AUDI);
        assertThat(entity).isNotNull();
        assertThat(entity.getPlate()).isEqualTo(PLATE_AUDI);
    }

}