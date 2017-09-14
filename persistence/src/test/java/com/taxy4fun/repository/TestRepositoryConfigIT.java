package com.taxy4fun.repository;

/*
Indicates that a class provides Spring Boot application @Configuration. Can be used as an alternative to the Spring's standard @Configuration annotation so that configuration can be found automatically (for example in tests).
Application should only ever include one @SpringApplicationConfiguration and most idiomatic Spring Boot applications will inherit it from @SpringBootApplication.
*/

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;

@SpringBootConfiguration
@Import({RepositoryConfig.class})
//use to test our class with Spring boot  autoconfig
public class TestRepositoryConfigIT {
}
