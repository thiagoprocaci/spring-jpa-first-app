package com.tbp.repository;

import com.tbp.modelo.Ingrediente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer>{
    
    Ingrediente findByNome(String nome);
    
}
