package com.springuers.taxy4fun.controllers;

import com.springuers.taxy4fun.dtos.Customer;
import com.springuers.taxy4fun.dtos.CustomerCreateRequest;
import com.springuers.taxy4fun.dtos.Driver;
import com.springuers.taxy4fun.dtos.DriverCreateRequest;
import com.springuers.taxy4fun.interfaces.CustomerService;
import com.springuers.taxy4fun.interfaces.DriverService;
import com.springuers.taxy4fun.mappers.CustomerFacadeMapper;
import com.springuers.taxy4fun.mappers.DriverFacadeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private CustomerService customerService;

    private CustomerFacadeMapper customerFacadeMapper;

    public CustomerController(final CustomerService customerService, final CustomerFacadeMapper customerFacadeMapper) {
        this.customerService = customerService;
        this.customerFacadeMapper = customerFacadeMapper;
    }

    @PostMapping("/v1/customers")
    ResponseEntity<HttpStatus> create(@RequestBody CustomerCreateRequest customerCreateRequest) {

        Customer serviceResponse = customerService.create(customerFacadeMapper.createRequestToCustomer(customerCreateRequest));
        HttpStatus statusResponse = serviceResponse!=null?HttpStatus.CREATED:HttpStatus.CONFLICT;

        return ResponseEntity.status(statusResponse).build();
    }

}
