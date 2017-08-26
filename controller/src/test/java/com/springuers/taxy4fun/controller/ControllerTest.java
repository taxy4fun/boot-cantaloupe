package com.springuers.taxy4fun.controller;

import com.springuers.taxy4fun.DummyService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    private static final ResultMatcher statusOk = status().isOk();
    private static final ResultMatcher statusCreated = status().isCreated();

    private MockMvc mockMvc;

    @Mock
    private DummyService dummyService;

    private Taxy4FunController controller;

    @Before
    public void setUp() {
        this.controller = new Taxy4FunController(this.dummyService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller)
                .build();
    }

    @Test
    public void test() throws Exception {
        Vehicle vehicle = new Vehicle(1L);

        this.mockMvc.perform(post("/vehicles/", vehicle))
                .andDo(print())
                .andExpect(statusCreated);
    }
}
