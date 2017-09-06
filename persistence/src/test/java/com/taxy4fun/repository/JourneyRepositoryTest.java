package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Journey;
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
 * Created by mvillafuertem on 9/6/17.
 */
@SpringBootTest(classes = JourneyRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class JourneyRepositoryTest {

    @Autowired
    private JourneyRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        final Journey journeySaved = createJourney();
    }
    /*
        Buscar los viajes de un vehiculo por su placa
     */
    @Test
    public void  findByVehiclePlate() {
        final Journey journeySaved = this.createJourney();

        final Stream<Journey> journeys = this.repository.findByVehiclePlate(newVehicle().getPlate());
        final Optional<Journey> first = journeys.findFirst();
        assertThat(first.isPresent());
        assertThat(first.get().getId()).isEqualTo(journeySaved.getId());
    }

    /*
        Buscar los viajes de un cliente por su ic
     */
    @Test
    public void findByCustomerIc() {
        final Journey journeySaved = this.createJourney();

        final Stream<Journey> journeys = this.repository.findByCustomerIc(newCustomer().getIc());
        final Optional<Journey> first = journeys.findFirst();
        assertThat(first.isPresent());
        assertThat(first.get().getId()).isEqualTo(journeySaved.getId());
    }

    private Journey createJourney() {
        final Journey journeySaved = this.repository.save(newJourney());
        assertThat(journeySaved.getId()).isNotNull();
        return journeySaved;
    }

}