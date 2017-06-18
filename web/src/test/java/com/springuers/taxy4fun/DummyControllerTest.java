package com.springuers.taxy4fun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.*;

/**
 * @author springuers
 */
@RunWith(SpringRunner.class)
public class DummyControllerTest {
    //@Autowired
    private MockMvc mvc;

    @Test
    public void testDummyController() {
        Boolean result = true;
        assertThat(result).isEqualTo(true);
    }
}
