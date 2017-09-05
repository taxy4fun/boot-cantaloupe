package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Point;
import com.taxy4fun.repository.entity.Route;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static com.taxy4fun.repository.RepositoryTestUtils.newLocalDateTime;
import static com.taxy4fun.repository.RepositoryTestUtils.newPoints;
import static com.taxy4fun.repository.RepositoryTestUtils.newRoute;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by mvillafuertem on 9/5/17.
 */
@SpringBootTest(classes = RouteRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class RouteRepositoryTest {

    @Autowired
    private RouteRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void create() {

        final Route routeSaved = this.repository.save(newRoute());
        routeSaved.getPoints().stream().forEach(System.out::println);
        assertThat(routeSaved.getPoints().get(0).getDatetime()).isEqualTo(newLocalDateTime());
    }

    @Test
    public void findByPlate() {

        final Route routeSaved = this.repository.save(newRoute());


    }
}