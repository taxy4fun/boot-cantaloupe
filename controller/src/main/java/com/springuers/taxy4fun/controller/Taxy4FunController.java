package com.springuers.taxy4fun.controller;

import com.springuers.taxy4fun.CreateVehicleRequest;
import com.springuers.taxy4fun.CreateVehicleResponse;
import com.springuers.taxy4fun.ExistsVehicleRequest;
import com.springuers.taxy4fun.VehicleService;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static io.vavr.API.*;
import static io.vavr.Patterns.$Failure;
import static io.vavr.Patterns.$Success;

/*
http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
 */

@RestController
public class Taxy4FunController {
    private final Logger logger = LoggerFactory.getLogger(Taxy4FunController.class);

    private VehicleService vehicleService;

    public Taxy4FunController(final VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @PostMapping(value = "/vehicles",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Vehicle> createVehicle(@RequestBody final Vehicle request) {
        HttpStatus status;

        this.logger.debug("request: {}", request.toString());

        // TODO resource validation

        // TODO mapper.facadeToService
        ExistsVehicleRequest existsVehicleRequest = new ExistsVehicleRequest();
        if (this.vehicleService.exists(existsVehicleRequest)) {
            this.logger.debug("vehicle exists");
            status = HttpStatus.CONFLICT;
        } else {
            // TODO mapper.facadeToService
            final CreateVehicleRequest serviceRequest = new CreateVehicleRequest();
            Try<CreateVehicleResponse> createVehicleResponse = this.vehicleService.create(serviceRequest);
            this.logger.debug("response: {}", this.tryToString(createVehicleResponse));
            status = getResult(createVehicleResponse);
        }

        return new ResponseEntity<>(status);
    }

    private String tryToString(final Try<CreateVehicleResponse> monad) {
        return Match(monad).of(
                Case($Success($()), s -> s.toString()),
                Case($Failure($()), f -> f.getMessage())
        );
    }


    private HttpStatus getResult(final Try<CreateVehicleResponse> monad) {
        return Match(monad).of(
                Case($Success($()), HttpStatus.CREATED),
                Case($Failure($()), HttpStatus.INTERNAL_SERVER_ERROR)
        );
    }
}
