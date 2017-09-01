package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Driver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by mvillafuertem on 9/1/17.
 */
@SpringBootTest(classes = DriverRepositoryTest.class)
@DataJpaTest
@RunWith(SpringRunner.class)
@Import(Driver.class)
public class DriverRepositoryTest {
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {

    }

}