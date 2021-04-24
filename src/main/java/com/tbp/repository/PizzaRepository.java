package com.tbp.repository;

import com.tbp.modelo.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza, Integer>{
    
}
