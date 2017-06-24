package com.taxy4fun;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by cmartin on 23/06/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLastname(String lastname);
}

