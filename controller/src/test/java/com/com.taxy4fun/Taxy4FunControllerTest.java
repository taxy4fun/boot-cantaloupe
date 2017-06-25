package com.taxy4fun;

import com.taxy4fun.services.LoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.*;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Springuers on 23/06/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(Taxy4FunController.class)
public class Taxy4FunControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private LoginService loginService;

    @Test
    public void testLoginValidPassword() throws Exception {

        final String MESSAGE_OK = "Welcome to Spring Boot Springuer";

        given(this.loginService.login("Springuer","admin")).willReturn(MESSAGE_OK);

        MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>() {{
            put("username", Arrays.asList("Springuer"));
            put("password", Arrays.asList("admin"));
        }};

        this.mvc.perform(post("/login").params(params).accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(content().string(MESSAGE_OK));
    }

    @Test
    public void testLoginInvalidPassword() throws Exception {

        final String MESSAGE_KO = "Wrong user / password combination";

        given(this.loginService.login("Springuer","badPassword")).willReturn(MESSAGE_KO);

        MultiValueMap<String,String> params = new LinkedMultiValueMap<String, String>() {{
            put("username", Arrays.asList("Springuer"));
            put("password", Arrays.asList("badPassword"));
        }};

        this.mvc.perform(post("/login").params(params).accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andExpect(content().string(MESSAGE_KO));
    }

}