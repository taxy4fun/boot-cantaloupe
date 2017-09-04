package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Driver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import static com.taxy4fun.repository.RepositoryTestUtils.newDriver;

/**
 * Created by mvillafuertem on 9/1/17.
 */
@SpringBootTest(classes = DriverRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
public class DriverRepositoryTest {

    @Autowired
    private DriverRepository repository;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
    }

}