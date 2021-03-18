package com.tbp.repository;

import com.tbp.modelo.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa, Integer>{
    
}
