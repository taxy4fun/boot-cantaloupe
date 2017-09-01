package com.taxy4fun.repository;

import com.taxy4fun.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cmartin on 23/06/2017.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByLastname(String lastname);
}

