package com.taxy4fun.repository;

import com.taxy4fun.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mvillafuertem on 9/1/17.
 */
@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {


}
