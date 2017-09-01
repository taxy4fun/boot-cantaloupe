package com.springuers.taxy4fun.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springuers.taxy4fun.dtos.Driver;
import com.springuers.taxy4fun.dtos.DriverCreateRequest;
import com.springuers.taxy4fun.interfaces.DriverService;
import com.springuers.taxy4fun.mappers.DriverFacadeMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by gevaudan on 30/08/17.
 */

/* @RunWith(SpringRunner.class)
@SpringBootTest(classes=DriverControllerTest.class)
@AutoConfigureMockMvc */

/* @RunWith(SpringRunner.class)
@AutoConfigureRestDocs("target/generated-snippets")
@SpringBootTest(classes=DriverControllerTest.class) */

@RunWith(MockitoJUnitRunner.class)
public class DriverControllerTest {

    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation("target/generated-snippets");

    /* @Autowired
    private WebApplicationContext context; */

    private MockMvc mockMvc;

    private ObjectMapper jsonMapper;

    @Mock
    private DriverService driverService;

    @Mock
    private DriverFacadeMapper driverFacadeMapper;

    private DriverController driverController;

    @Before
    public void setUp() {
        jsonMapper = new ObjectMapper();
        driverController = new DriverController(driverService, driverFacadeMapper);
        this.mockMvc = MockMvcBuilders.standaloneSetup(driverController)
                .apply(documentationConfiguration(this.restDocumentation)).build();

        /* this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .apply(documentationConfiguration(this.restDocumentation))
                .build(); */
    }

    @Test
    public void testCreateNew() throws Exception {

        DriverCreateRequest createRequest = new DriverCreateRequest("admin");
        Driver driver = new Driver("admin");

        when(driverService.create(any(Driver.class)))
                .thenReturn(driver);

        String jsonCreateRequest = jsonMapper.writeValueAsString(createRequest);

        this.mockMvc.perform(post("/v1/drivers")
                // Unit Test
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(jsonCreateRequest)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andDo(print())
                // Rest Docs
                .andDo(document("driver-doc", requestParameters(parameterWithName("id").description("Identificador de conductor"))));
    }

    @Test
    public void testCreateExistent() throws Exception {

        DriverCreateRequest createRequest = new DriverCreateRequest("admin");

        when(driverService.create(any(Driver.class)))
                .thenThrow(RuntimeException.class);

        String jsonCreateRequest = jsonMapper.writeValueAsString(createRequest);

        this.mockMvc.perform(post("/v1/drivers")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(jsonCreateRequest)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())
                .andDo(print());
    }

}