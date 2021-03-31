package com.tbp.repository;

import com.tbp.modelo.Conta;
import com.tbp.modelo.Transacao;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends CrudRepository<Transacao, Integer>{
 
    List<Transacao> findByConta(Conta conta);
    
}
