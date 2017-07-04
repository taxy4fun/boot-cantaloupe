package com.taxy4fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cmartin on 23/06/2017.
 */
@SpringBootTest(classes = UserRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    private static final String FIRST_NAME = "Pecador";

    private static final String LAST_NAME = "Pradera";

    private static final boolean ACTIVE = true;

    private static final LocalDate LOCAL_DATE = LocalDate.of(1985, Month.DECEMBER, 19);


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User userBean = new User();
        userBean.setFirstname(FIRST_NAME);
        userBean.setLastname(LAST_NAME);
        userBean.setActive(ACTIVE);
        userBean.setDateOfBirth(LOCAL_DATE);

        assertThat(userBean.getId()).isNull();
        // bean persistence
        this.userRepository.save(userBean);

        // bean -> entity
        assertThat(userBean.getId()).isNotNull();

        // entity search
        User userEntity = this.userRepository.findByLastname(LAST_NAME);
        assertThat(userEntity).isNotNull();
        assertThat(userEntity.getFirstname()).isEqualTo(FIRST_NAME);
        assertThat(userEntity.getLastname()).isEqualTo(LAST_NAME);
        assertThat(userEntity.getActive()).isEqualTo(ACTIVE);
        assertThat(userEntity.getDateOfBirth()).isEqualTo(LOCAL_DATE);
    }

}
