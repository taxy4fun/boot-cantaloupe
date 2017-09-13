package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Driver;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.taxy4fun.repository.RepositoryTestUtils.*;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by mvillafuertem on 9/1/17.
 */
@SpringBootTest(classes = RepositoryConfig.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class DriverRepositoryTest {

    @Autowired
    private DriverRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {
        final Driver entity = this.createDriver();

        final Driver driverFound = this.repository.findOne(entity.getId());

        assertThat(driverFound.getEin()).isEqualTo(DRIVER_EIN);
        assertThat(driverFound.getLicense()).isEqualTo(DRIVER_LICENSE);

        // profile association
        Assertions.assertThat(driverFound.getProfile()).isNotNull();
        Assertions.assertThat(driverFound.getProfile().getEmail()).isNotNull();
        Assertions.assertThat(driverFound.getProfile().getEmail()).isEqualTo(PERSON_EMAIL);
    }


    @Test
    public void delete() {
        final Driver entity = this.createDriver();
        final Long previousCount = this.repository.count();

        final Long entityId = entity.getId();
        final Driver driverFound = this.repository.findOne(entityId);
        assertThat(driverFound).isNotNull();

        this.repository.delete(driverFound);
        final Long actualCount = this.repository.count();

        assertThat(this.repository.findOne(entityId)).isNull();
        assertThat(previousCount - actualCount).isEqualTo(1);
    }

    private Driver createDriver() {
        /*
            Verificamos que todavia ¡NO! hemos persistido la entidad
         */
        final Driver bean = newDriver();
        assertThat(bean.getId()).isNull();

        /*
            Probamos el repository y verificamos que ha persistido
         */
        final Driver entity = this.repository.save(bean);
        assertThat(entity.getId()).isNotNull();

        return entity;
    }
}