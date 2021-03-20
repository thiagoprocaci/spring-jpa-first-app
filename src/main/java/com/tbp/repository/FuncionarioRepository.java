
package com.tbp.repository;

import com.tbp.modelo.Funcionario;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository 
        extends CrudRepository<Funcionario, Integer>{
    
    List<Funcionario> findByNomeIgnoreCaseContaining(String nome);
    
}
