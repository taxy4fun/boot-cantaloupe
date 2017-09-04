package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;

import java.util.stream.Stream;

/**
 * Created by mvillafuertem on 8/29/17.
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {


    Vehicle findByPlate(final String plate);

    Vehicle findByBrand(final String brand);

    Stream<Vehicle> findByDriverEin(final Long ein);
}
