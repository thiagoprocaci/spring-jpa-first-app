package com.tbp.repository;

import com.tbp.model.Alocacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlocacaoRepository extends CrudRepository<Alocacao, Long> {
}
