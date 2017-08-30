package com.taxy4fun;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by mvillafuertem on 8/29/17.
 */
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {


    Vehicle findByPlate(String plate);
}
