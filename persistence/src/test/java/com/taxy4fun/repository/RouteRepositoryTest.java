package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Route;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.taxy4fun.repository.RepositoryTestUtils.*;
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
        Route entity = this.createRoute();

        assertThat(entity.getPoints()).isEmpty();
    }

    @Test
    public void createWithPoints() {

        final Route entity = this.createRouteWithPoints();

        final Route routeFound = this.repository.findOne(entity.getId());
        assertThat(routeFound).isNotNull();
        assertThat(routeFound.getPoints()).isNotEmpty();

//        entity.getPoints().stream().forEach(System.out::println);
//        assertThat(entity.getPoints().get(0).getDatetime()).isEqualTo(newLocalDateTime());


//        this.repository.f
    }

    @Test
    public void findByPlate() {

        final Route routeSaved = this.repository.save(newRouteWithPoints());


    }

    private Route createRoute() {
        /*
            Verificamos que todavia ¡NO! hemos persistido la entidad
         */
        final Route bean = newRoute();
        assertThat(bean.getId()).isNull();

        /*
            Probamos el repository y verificamos que ha persistido
         */
        final Route entity = this.repository.save(bean);
        assertThat(entity.getId()).isNotNull();

        return entity;
    }

    private Route createRouteWithPoints() {

        final Route bean = newRoute();
        bean.setPoints(newPoints());
        final Route entity = this.repository.save(bean);
        assertThat(entity.getId()).isNotNull();
        assertThat(entity.getPoints()).isNotEmpty();
        return entity;
    }
}