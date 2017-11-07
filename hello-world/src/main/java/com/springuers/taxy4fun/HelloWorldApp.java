package com.springuers.taxy4fun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloWorldApp implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorldApp.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Hello from Boot Cantaloupe basic application!");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldApp.class, args);
    }

}
