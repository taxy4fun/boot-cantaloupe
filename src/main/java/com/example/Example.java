package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Example implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Hola melón");
        logger.debug("Hola DEBUG");
    }


    public static void main(String[] args) throws Exception {

        SpringApplication.run(Example.class, args);

    }

}
