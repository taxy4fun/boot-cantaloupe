package com.taxy4fun.repository;

import com.taxy4fun.repository.entity.Route;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mvillafuertem on 9/5/17.
 */
@Repository
public interface RouteRepository extends CrudRepository<Route, Long> {

}
