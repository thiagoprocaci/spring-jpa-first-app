package com.tbp.repository;

import com.tbp.modelo.Conta;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaRepository extends CrudRepository<Conta, Integer>{

    List<Conta> findByNumero(Integer numero);
    
}
