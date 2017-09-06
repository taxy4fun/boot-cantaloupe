package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Journey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

/**
 * Created by mvillafuertem on 9/6/17.
 */
@Repository
public interface JourneyRepository extends CrudRepository<Journey, Long> {
    Stream<Journey> findByVehiclePlate(final String plate);

    Stream<Journey> findByCustomerIc(final Long ic);
}
