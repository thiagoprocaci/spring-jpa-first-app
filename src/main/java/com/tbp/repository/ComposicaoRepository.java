
package com.tbp.repository;

import com.tbp.modelo.Composicao;
import com.tbp.modelo.Pizza;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComposicaoRepository extends CrudRepository<Composicao, Integer>{
 
    List<Composicao> findByPizza(Pizza pizza);
    
}
