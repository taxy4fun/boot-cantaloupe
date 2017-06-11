package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class Example implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Example.class);

    private final FooProperties properties;

    public Example(FooProperties properties) {
        this.properties = properties;
    }

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Hola melón");
        logger.debug("Hola DEBUG");
        logger.info("Properties:" + properties);
    }


    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

}
