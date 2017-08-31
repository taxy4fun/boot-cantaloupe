package com.springuers.taxy4fun.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springuers.taxy4fun.dtos.Customer;
import com.springuers.taxy4fun.dtos.CustomerCreateRequest;
import com.springuers.taxy4fun.interfaces.CustomerService;
import com.springuers.taxy4fun.mappers.CustomerFacadeMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gevaudan on 30/08/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper jsonMapper;

    @Mock
    private CustomerService customerService;

    @Mock
    private CustomerFacadeMapper customerFacadeMapper;

    private CustomerController customerController;

    @Before
    public void setUp() {
        jsonMapper = new ObjectMapper();
        customerController = new CustomerController(customerService, customerFacadeMapper);
        this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
    }

    @Test
    public void testCreateNew() throws Exception {

        CustomerCreateRequest createRequest = new CustomerCreateRequest("admin");
        Customer customer = new Customer("admin");

        when(customerService.create(any(Customer.class)))
                .thenReturn(customer);

        String jsonCreateRequest = jsonMapper.writeValueAsString(createRequest);

        this.mockMvc.perform(post("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(jsonCreateRequest)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    public void testCreateExistent() throws Exception {

        CustomerCreateRequest createRequest = new CustomerCreateRequest("admin");

        when(customerService.create(any(Customer.class)))
                .thenReturn(null);

        String jsonCreateRequest = jsonMapper.writeValueAsString(createRequest);

        this.mockMvc.perform(post("/v1/customers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(jsonCreateRequest)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andDo(print());
    }

}