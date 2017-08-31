package com.springuers.taxy4fun.controllers;

import com.springuers.taxy4fun.dtos.Driver;
import com.springuers.taxy4fun.dtos.DriverCreateRequest;
import com.springuers.taxy4fun.interfaces.DriverService;
import com.springuers.taxy4fun.mappers.DriverFacadeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;

@RestController
public class DriverController {

    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    private DriverService driverService;

    private DriverFacadeMapper driverFacadeMapper;

    public DriverController(final DriverService driverService, final DriverFacadeMapper driverFacadeMapper) {
        this.driverService = driverService;
        this.driverFacadeMapper = driverFacadeMapper;
    }

    @PostMapping("/v1/drivers")
    ResponseEntity<HttpStatus> create(@RequestBody DriverCreateRequest driverCreateRequest) {

        Driver serviceResponse = driverService.create(driverFacadeMapper.createRequestToDriver(driverCreateRequest));
        HttpStatus statusResponse = serviceResponse!=null?HttpStatus.CREATED:HttpStatus.CONFLICT;

        return ResponseEntity.status(statusResponse).build();
    }

}
