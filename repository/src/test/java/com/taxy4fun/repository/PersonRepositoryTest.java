package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cmartin on 23/06/2017.
 */
@SpringBootTest(classes = PersonRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class PersonRepositoryTest {

    public static final String PECADOR = "Pecador";

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void testCreate() {
        Person personBean = new Person();
        personBean.setFirstname("Chiquito");
        personBean.setLastname(PECADOR);
        assertThat(personBean.getId()).isNull();
        // bean persistence
        this.personRepository.save(personBean);

        // bean -> entity
        assertThat(personBean.getId()).isNotNull();

        // entity search
        Person personEntity = this.personRepository.findByLastname(PECADOR);
        assertThat(personEntity).isNotNull();
        assertThat(personEntity.getLastname()).isEqualTo(PECADOR);
    }

}
