package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Driver;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackageClasses = DriverRepository.class)
@EntityScan(basePackageClasses = Driver.class)
public class RepositoryConfig {
}
