package br.edu.infnet.repository;

import br.edu.infnet.model.UsuarioAdmin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioAdminRepository extends CrudRepository<UsuarioAdmin, Long> {

    List<String> findByDescricao(String descricao);

}
