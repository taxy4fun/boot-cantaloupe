package com.springuers.taxy4fun;

import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.hamcrest.Matchers.hasItem;


/**
 * @author jperezdelafuente
 */
@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    private static final int DEFAULT_ID = 1;

    private static final String DEFAULT_FIRST_NAME = "First Name";

    private static final String DEFAULT_LAST_NAME = "Last Name";

    private static final int DEFAULT_AGE = 22;

    private static final Boolean DEFAULT_ACTIVE = true;

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void listUsers() throws Exception {
        this.mockMvc
                .perform(get("/user").accept(org.springframework.http.MediaType.APPLICATION_JSON))
                .andExpect(status().isFound())
                .andExpect(content().contentType(org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$.[*].id").value(hasItem(DEFAULT_ID)))
                .andExpect(jsonPath("$.[*].firstname").value(hasItem(DEFAULT_FIRST_NAME)))
                .andExpect(jsonPath("$.[*].lastname").value(hasItem(DEFAULT_LAST_NAME)))
                .andExpect(jsonPath("$.[*].age").value(hasItem(DEFAULT_AGE)))
                .andExpect(jsonPath("$.[*].active").value(hasItem(DEFAULT_ACTIVE)));
    }



}
