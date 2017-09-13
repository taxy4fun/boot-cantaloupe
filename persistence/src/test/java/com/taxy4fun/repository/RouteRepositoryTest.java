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
@SpringBootTest(classes = RepositoryConfig.class)
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

        assertThat(entity.getFootprints()).isEmpty();
    }

    @Test
    public void delete() {
        final Route entity = this.createRoute();
        final Long previousCount = this.repository.count();

        final Long entityId = entity.getId();
        final Route routeFound = this.repository.findOne(entityId);
        assertThat(routeFound).isNotNull();

        this.repository.delete(routeFound);
        final Long actualCount = this.repository.count();

        assertThat(this.repository.findOne(entityId)).isNull();
        assertThat(previousCount - actualCount).isEqualTo(1);
    }

    @Test
    public void update() {
        final Route entity = this.createRouteWithPoints();
        final Integer previousCount = entity.getFootprints().size();

        entity.getFootprints().remove(0);
        final Long entityId = entity.getId();
        this.repository.findOne(entityId);

        final Route routeFound = this.repository.findOne(entityId);

        final Integer actualCount = routeFound.getFootprints().size();
        assertThat(previousCount - actualCount).isEqualTo(1);
    }

    @Test
    public void createWithPoints() {

        final Route entity = this.createRouteWithPoints();

        final Route routeFound = this.repository.findOne(entity.getId());
        assertThat(routeFound).isNotNull();
        assertThat(routeFound.getFootprints()).isNotEmpty();
    }

    @Test
    public void findByPlate() {

        final Route routeSaved = this.repository.save(newRouteWithFootprints());


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
        bean.setFootprints(newFootprints(5));
        final Route entity = this.repository.save(bean);
        assertThat(entity.getId()).isNotNull();
        assertThat(entity.getFootprints()).isNotEmpty();
        return entity;
    }
}