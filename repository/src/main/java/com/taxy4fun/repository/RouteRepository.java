package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Stream;

/**
 * Created by mvillafuertem on 9/5/17.
 */
@Repository
public interface RouteRepository extends CrudRepository<Route, LocalDateTime> {

}
