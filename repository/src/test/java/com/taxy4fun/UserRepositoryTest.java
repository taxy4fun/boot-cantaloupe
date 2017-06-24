package com.taxy4fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by cmartin on 23/06/2017.
 */
@SpringBootTest(classes = UserRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    public static final String PECADOR = "Pecador";
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testCreate() {
        User user = new User();
        user.setFirstname("Chiquito");
        user.setLastname(PECADOR);
        this.userRepository.save(user);

        assertThat(user.getId()).isNotNull();

        User userEntity = this.userRepository.findByLastname(PECADOR);
        assertThat(user).isNotNull();
        assertThat(user.getLastname()).isEqualTo(PECADOR);
    }

}
