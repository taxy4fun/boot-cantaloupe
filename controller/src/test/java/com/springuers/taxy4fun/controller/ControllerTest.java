package com.springuers.taxy4fun.controller;

import com.springuers.taxy4fun.CreateVehicleRequest;
import com.springuers.taxy4fun.ExistsVehicleRequest;
import com.springuers.taxy4fun.VehicleService;
import com.springuers.taxy4fun.test.TestUtils;
import io.vavr.control.Try;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    private static final ResultMatcher statusCreated = status().isCreated();
    private static final ResultMatcher statusConflict = status().isConflict();
    private static final ResultMatcher statusServerError = status().isInternalServerError();

    private MockMvc mockMvc;

    @Mock
    private VehicleService vehicleService;

    private Taxy4FunController controller;

    @Before
    public void setUp() {
        this.controller = new Taxy4FunController(this.vehicleService);
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller)
                .build();
    }

    @Test
    public void testCreateVehicleOk() throws Exception {
        // preconditions
        when(this.vehicleService.exists(any(ExistsVehicleRequest.class))).thenReturn(false);
        when(this.vehicleService.create(any(CreateVehicleRequest.class)))
                .thenReturn(ControllerTestUtils.newCreateVehicleResponse());

        // controller function
        this.mockMvc.perform(post("/vehicles/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(TestUtils.convertObjectToJsonString(ControllerTestUtils.newVehicle())))
                .andDo(print())
                .andExpect(statusCreated);

        // posconditions
        verify(this.vehicleService).exists(any(ExistsVehicleRequest.class));
        verify(this.vehicleService).create(any(CreateVehicleRequest.class));
    }

    @Test
    public void testCreateVehicleConfilct() throws Exception {
        // preconditions
        when(this.vehicleService.exists(any(ExistsVehicleRequest.class))).thenReturn(true);

        // controller function
        this.mockMvc.perform(post("/vehicles/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(TestUtils.convertObjectToJsonString(ControllerTestUtils.newVehicle())))
                .andDo(print())
                .andExpect(statusConflict);

        // posconditions
        verify(this.vehicleService).exists(any(ExistsVehicleRequest.class));
    }

    @Test
    public void testCreateVehicleServerError() throws Exception {
        // preconditions
        when(this.vehicleService.exists(any(ExistsVehicleRequest.class))).thenReturn(false);
        when(this.vehicleService.create(any(CreateVehicleRequest.class)))
                .thenReturn(Try.failure(new RuntimeException("Transaction Error")));

        // controller function
        this.mockMvc.perform(post("/vehicles/")
                .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE)
                .content(TestUtils.convertObjectToJsonString(ControllerTestUtils.newVehicle())))
                .andDo(print())
                .andExpect(statusServerError);

        // posconditions
        verify(this.vehicleService).exists(any(ExistsVehicleRequest.class));
        verify(this.vehicleService).create(any(CreateVehicleRequest.class));
    }

}
