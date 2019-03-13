package com.tbp.repository;

import com.tbp.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    Person findByUsername(String username);
}
