package com.springuers.taxy4fun.controller;

import com.springuers.taxy4fun.CreateVehicleRequest;
import com.springuers.taxy4fun.CreateVehicleResponse;
import com.springuers.taxy4fun.DummyService;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Taxy4FunController {
    private final Logger logger = LoggerFactory.getLogger(Taxy4FunController.class);

    private DummyService dummyService;

    public Taxy4FunController(final DummyService dummyService) {
        this.dummyService = dummyService;
    }

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @RequestMapping(value = "/vehicles",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Vehicle> createVehicle(final Vehicle request) {

        this.logger.debug("request: {}", request.toString());

        // TODO resource validation

        // TODO mapper.facadeToService
        final CreateVehicleRequest serviceRequest = new CreateVehicleRequest();

        Try<CreateVehicleResponse> createVehicleResponses = this.dummyService.create(serviceRequest);

        // TODO mapper.serviceToFacade

        Vehicle response = new Vehicle(1L);

        this.logger.debug("response: {}", response.toString());

        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
