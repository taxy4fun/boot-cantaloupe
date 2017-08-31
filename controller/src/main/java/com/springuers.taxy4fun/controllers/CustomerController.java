package com.springuers.taxy4fun.controllers;

import com.springuers.taxy4fun.configuration.AppProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private final AppProperties properties;

    public CustomerController(AppProperties properties) {
        this.properties = properties;
    }

    @PostMapping("/v1/customers/")
    HttpStatus register() {
        return HttpStatus.CREATED;
    }

}
