package com.tbp.repository;

import com.tbp.modelo.Conta;
import com.tbp.modelo.Pessoa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{
    
   Pessoa findByConta(Conta conta);
    
}
